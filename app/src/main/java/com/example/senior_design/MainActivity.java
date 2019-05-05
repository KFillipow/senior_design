package com.example.senior_design;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
//import packageName.SampledData;




public class MainActivity extends AppCompatActivity {

    CheckBox enable_bt,visible_bt;
    ImageView search_bt;
    ListView listView;
    TextView name_bt;
    Handler mHandler;
    private static final UUID BTMODULEUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); // "random" unique identifier
    private final String DEVICE_ADDRESS="98:D3:11:FC:1C:3D";
    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;
    public static final int MESSAGE_READ = 0;
    public static final int MESSAGE_WRITE = 1;
    public static final int MESSAGE_TOAST = 2;
    private BluetoothDevice mDevice =  null;
    public int counter = 0;
    String y_values[] = new String[10];
    String x_values[] = new String[10];
        // ... (Add other message types here as needed.)



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enable_bt = findViewById(R.id.enable_bt);
        search_bt = findViewById(R.id.search_bt);
        name_bt = findViewById(R.id.name_bt);
        listView = findViewById(R.id.list_view);

        name_bt.setText(getLocalBluetoothName());
        BA = BluetoothAdapter.getDefaultAdapter();

        //add bluetoothIn = new Handler(){}
        //once the button gets pressed, if statement goes through
        //once data is collected, go to 2nd activity?
        if(BA == null){
            Toast.makeText(this,"Bluetooth not supported",Toast.LENGTH_SHORT).show();
            //finish();
        }
        if(BA.isEnabled()){
            enable_bt.setChecked(true);
        }
        enable_bt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    BA.disable();
                    Toast.makeText(MainActivity.this,"Turned Off",Toast.LENGTH_SHORT).show();;
                }
                else{
                    Intent intentOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intentOn,0);
                    Toast.makeText(MainActivity.this,"Turned On", Toast.LENGTH_SHORT).show();
                }
            }
        });

        search_bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                list();
            }
        });
        //BluetoothDevice mDevice =  BA.getRemoteDevice(DEVICE_ADDRESS);
        //private BluetoothDevice mDevice =  null;
        Set<BluetoothDevice> pairedDevices = BA.getBondedDevices();
        if(pairedDevices.size() > 0){
            for (BluetoothDevice device : pairedDevices){
                if(device.getAddress().equals(DEVICE_ADDRESS)){
                    mDevice = device;
                    Toast.makeText(this, "Found KAI", Toast.LENGTH_SHORT).show();
                    break;
                }
                mDevice = device;
            }
        }
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                byte[] writeBuf = (byte[]) msg.obj;
                int begin = (int)msg.arg1;
                int end = (int)msg.arg2;

                switch(msg.what){
                    case 1:
                        String writeMessage = new String(writeBuf);
                        writeMessage = writeMessage.substring(begin,end);
                        Log.i("My app","BT"+writeMessage);
                        //int x_iter,y_iter;

                        if(counter >=3 && counter <= 12){
                            y_values[counter-3] = writeMessage;
                            //write to  y values
                            //convert to float
                        }
                        else if(counter >= 14 && counter <= 23){
                            x_values[counter-14] = writeMessage;
                            //write to x values
                            //convert to int
                        }
                        else if(counter == 24)
                        {
                            Toast.makeText(getBaseContext(), "Data Aqcuired", Toast.LENGTH_SHORT).show();
                        }
                        else if(counter == 25){
                            Toast.makeText(getBaseContext(), "Data Aqcuired", Toast.LENGTH_SHORT).show();
                            counter = 0;
                        }
                        counter++;
                        break;
                }
            }
        };
       // private class ConnectThread extends Thread{
        ConnectThread mConnectThread = new ConnectThread(mDevice);
        mConnectThread.start();

        configureKKN();
        }



        //read in data from bluetooth into two arrays
        //first -- look for bluetooth device
        //enable device
        //check for matching paired device
        //create and connect
        //listen for data
        //k nearest neighbor calculations
        //output result to app interface

    //}
    private class ConnectThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final BluetoothDevice mmDevice;
        private final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
        public ConnectThread(BluetoothDevice device) {
            BluetoothSocket tmp = null;
            mmDevice = device;
            try {
                tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
            } catch (IOException e) {
                //Log.e("ConnectThread" ,"Socket's creation failed");
                Toast.makeText(getBaseContext(), "Socket creation failed", Toast.LENGTH_SHORT).show();
            }
            mmSocket = tmp;
        }
        public void run() {
            BA.cancelDiscovery();
            try {
                mmSocket.connect();
            } catch (IOException connectException) {
                try {
                    mmSocket.close();
                } catch (IOException closeException) {
                    //Log.e("ConnectThread", "Could not close the client socket", closeException);
                    Toast.makeText(getBaseContext(), "Couldnt close", Toast.LENGTH_SHORT).show();
                }
                return;
            }
            ConnectedThread mConnectedThread = new ConnectedThread(mmSocket);
            mConnectedThread.start();

        }
        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {
                //Log.e("ConnectThread", "Could not close the client socket", e);
                Toast.makeText(getBaseContext(), "Couldn't close", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class ConnectedThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;
        public ConnectedThread(BluetoothSocket socket) {
            mmSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) { }
            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }
        public void run() {
            byte[] buffer = new byte[1024];
            int begin = 0;
            int bytes = 0;
            while (true) {
                try {
                    bytes += mmInStream.read(buffer, bytes, buffer.length - bytes);
                    for(int i = begin; i < bytes; i++) {
                        if(buffer[i] == "\n".getBytes()[0]) {
                            mHandler.obtainMessage(1, begin, i, buffer).sendToTarget();
                            begin = i + 1;
                            if(i == bytes - 1) {
                                bytes = 0;
                                begin = 0;
                            }
                        }
                    }
                } catch (IOException e) {
                    break;
                }
            }
        }
        public void write(byte[] bytes) {
            try {
                mmOutStream.write(bytes);
            } catch (IOException e) { }
        }
        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) { }
        }
    }



    private void list(){
        pairedDevices = BA.getBondedDevices();

        ArrayList list = new ArrayList();
        for(BluetoothDevice bt : pairedDevices){
            list.add(bt.getName());
        }
        Toast.makeText(this, "Showing Devices",Toast.LENGTH_SHORT).show();
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
    }

    public String getLocalBluetoothName(){
        if (BA == null){
            BA = BluetoothAdapter.getDefaultAdapter();
        }
        String name = BA.getName();
        if (name == null){
            name = BA.getAddress();
        }
        return name;
    }


    public void configureKKN(){
        Button btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("My app","Magic Log mess");
                Intent secondAct = new Intent(MainActivity.this,Main2Activity.class);
                secondAct.putExtra("x_vals",x_values);
                secondAct.putExtra("y_vals",y_values);
                startActivity(secondAct);

            }
        });
    }

    //SampledData test = new SampledData();
}
