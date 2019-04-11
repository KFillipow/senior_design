package com.example.senior_design;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

   private BluetoothAdapter BA;
   private Set<BluetoothDevice> pairedDevices;


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

       // private class ConnectThread extends Thread{
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


    private void configureKKN(){
        Button btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
                //Log.i("My app","Magic Log mess");
            }
        });
    }

    //SampledData test = new SampledData();
}
