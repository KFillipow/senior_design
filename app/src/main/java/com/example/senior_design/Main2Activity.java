package com.example.senior_design;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main2Activity extends AppCompatActivity {

    TextView chord_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        chord_id = (TextView)findViewById(R.id.chord_id);
        float[] sample_x = new float[]{84,126,169,213,253,338,426,506,676,759,85,126,169,214,254,338,428,507,677,761,85,126,169,214,254,339,428,507,677,762,85,126,169,214,254,339,427,507,677,761,85,126,169,214,254,338,427,507,677,761,85,126,169,213,252,255,338,427,507,677,85,126,169,213,253,338,427,507,677,761,85,126,169,213,253,338,426,506,676,759,85,126,169,213,253,338,427,507,677,761,85,126,169,214,254,338,427,507,677,761,85,126,169,213,253,338,427,507,676,760,112,169,226,284,338,453,569,676,853,1015,112,169,223,226,284,338,452,507,568,676,112,169,224,227,284,338,454,569,677,1015,112,169,224,227,284,338,451,567,676,1014,112,169,224,227,284,338,451,568,676,1014,112,169,224,227,284,338,453,569,677,1015,112,169,226,284,338,453,569,676,679,1015,112,169,227,285,338,453,569,677,680,1016,112,169,226,284,287,338,453,569,676,1015,112,169,224,227,285,338,453,569,677,854,113,169,224,227,285,339,454,569,677,1016,90,134,179,227,269,359,454,539,718,808,90,134,179,227,269,359,454,539,718,808,89,134,179,227,270,359,454,539,718,809,89,134,179,227,269,359,454,538,718,807,90,134,179,227,269,359,454,538,717,807,89,134,179,227,269,359,454,538,717,808,89,134,179,227,269,358,454,538,717,807,89,134,179,227,269,358,454,537,717,806,89,134,179,226,269,358,453,538,717,807,89,134,179,226,266,269,359,453,538,717,89,134,179,226,269,359,453,538,717,807,100,126,150,201,253,301,402,451,603,805,100,127,150,201,253,299,302,402,604,805,100,126,150,200,253,301,402,451,603,804,100,126,150,198,201,253,301,402,603,804,100,126,150,200,253,301,402,451,602,804,100,126,150,198,201,253,302,402,603,804,100,127,150,201,253,301,402,405,604,805,100,126,150,200,203,253,301,402,603,804,100,126,150,201,253,301,402,451,603,805,100,126,150,201,253,301,401,451,602,804,100,126,150,201,253,301,402,451,603,804,150,226,299,302,379,452,603,679,759,905,150,226,301,379,452,602,679,759,904,1132,150,226,301,304,379,452,603,678,759,904,150,226,301,379,452,602,678,759,903,1139,150,226,298,301,379,452,602,678,759,1139,150,226,301,379,452,602,679,759,903,1139,150,223,226,298,301,379,451,602,678,759,150,226,298,301,379,452,602,678,759,903,150,225,228,298,301,379,451,602,677,759,150,226,301,304,379,452,603,679,759,904,150,226,298,301,379,451,454,602,678,759,134,168,200,268,338,401,536,602,676,804,134,168,200,268,401,536,602,675,804,1014,134,168,200,268,338,401,536,602,676,804,133,168,200,268,338,401,536,601,675,804,134,168,200,268,337,401,536,601,676,804,134,168,200,268,338,401,536,602,676,804,131,134,166,169,201,268,338,402,536,674,131,134,169,201,205,268,337,402,536,674,99,134,137,169,201,265,268,338,402,536,100,130,134,137,169,200,268,337,401,536,99,129,134,168,200,267,337,401,535,674,84,116,124,127,168,201,253,337,401,505,84,124,127,130,169,201,253,338,402,506,84,126,137,166,169,200,253,337,401,505,81,84,126,166,169,200,253,337,401,505,84,117,127,165,168,200,253,337,401,505,84,127,148,169,200,252,338,401,505,673,84,126,165,168,200,252,338,401,505,673,84,126,158,169,200,253,337,401,505,673,84,96,126,129,169,200,252,337,401,505,84,104,124,127,169,201,253,337,401,505,84,126,166,169,200,211,253,337,401,505,86,113,169,222,226,268,337,452,537,674,113,116,169,226,229,268,337,451,537,674,86,109,113,169,223,226,268,337,451,537,85,113,116,169,225,268,338,451,536,674,113,116,155,169,225,268,337,451,536,674,85,113,116,169,225,228,268,338,451,536,113,117,156,169,225,268,337,452,537,674,99,113,155,169,225,268,338,451,537,674,85,99,113,116,169,226,268,337,451,536,113,116,169,180,225,268,337,451,536,674,113,156,169,222,226,268,338,452,537,674,94,131,150,189,226,301,357,451,602,714,112,150,169,188,225,301,357,451,602,714,94,131,150,223,226,301,357,451,602,714,112,150,188,225,298,301,357,451,602,714,94,114,131,150,225,301,357,451,602,714,95,150,188,225,298,301,357,451,602,714,112,150,207,225,298,301,357,450,602,713,131,147,225,357,376,451,602,713,18352,64768,95,150,187,223,226,301,357,451,602,714,131,150,187,225,301,304,357,451,603,714,112,150,188,225,301,357,375,451,526,602};
        double[] sample_y = new double[]{52.306565,100,78.673849,91.754155,99.839315,50.427271,71.166932,86.313967,65.276022,41.982814,64.549417,83.636472,89.597396,100,67.777203,57.719803,69.179167,57.30416,43.743861,31.393609,55.958994,66.401398,43.552748,100,77.048328,36.675927,79.92856,70.44612,58.070781,29.345977,77.844244,83.086983,57.512915,100,84.91783,49.580763,83.269882,68.750078,62.065073,33.500006,100,87.634293,76.947011,83.439895,94.591889,54.946616,92.394602,88.761898,62.903322,52.279733,75.182729,100,47.060515,72.07957,60.937702,35.931407,70.373931,62.659845,74.270786,26.533119,69.140988,89.657254,100,76.68269,71.124513,44.766051,82.756608,97.332331,36.278552,32.608513,56.480649,50.397741,83.935072,80.406252,91.454379,68.239514,59.847536,100,70.617299,37.675382,67.713299,52.915666,100,62.140608,55.912646,82.036472,69.329724,82.823102,33.78961,29.929018,95.721955,85.428849,100,80.298108,75.736789,68.943014,54.097597,71.19157,49.981888,26.381055,62.576726,71.674021,100,77.578679,75.297288,75.032935,60.186038,50.075488,45.155814,30.7241,45.673444,71.636418,76.381645,79.712543,100,76.959891,52.675244,39.880347,15.329184,14.137558,63.454994,94.352071,27.529227,100,83.489026,30.306876,67.483753,16.71758,43.842596,44.629531,59.185844,91.303889,29.666964,100,75.990342,54.26896,66.852175,70.607673,51.390323,27.307941,73.423405,94.454285,95.446078,31.463708,86.749003,87.527518,100,58.430705,61.110425,20.86909,68.31646,87.187332,93.036007,26.173257,98.118972,59.395695,100,68.680821,53.571415,25.771908,55.136003,78.63629,39.187095,89.694973,82.771547,100,65.062608,70.071219,47.522336,19.858837,49.745586,75.713552,92.038208,84.786417,100,66.685975,47.743638,45.417284,18.215298,20.812109,51.542759,80.250923,100,91.521253,77.138524,87.774876,64.074374,70.724179,22.309713,20.483519,59.711915,76.195818,73.478946,84.491524,12.826007,100,70.035132,74.178591,41.112626,18.588072,63.171109,100,57.605136,84.625785,82.913589,65.174904,97.750474,70.941846,60.401938,22.742277,39.263684,56.551018,15.481514,100,58.866244,67.440048,78.568717,50.244173,54.144333,13.489854,54.722358,56.732098,100,74.610753,52.753852,44.435583,37.58179,52.426457,36.05623,12.894475,35.279993,39.64548,100,78.887582,47.024775,19.137905,62.879904,52.042238,41.285455,28.621811,53.528623,62.382092,100,54.02607,49.404427,66.555394,40.852823,66.706074,43.979436,18.370535,57.574782,67.356532,92.754764,87.628223,28.093634,40.762223,68.714806,100,43.90744,25.555282,44.467053,47.817714,87.920031,75.096242,100,41.961371,46.137673,57.69548,41.632768,15.045001,44.033271,50.258909,77.644439,74.933796,100,67.076019,45.262853,72.020827,51.063262,20.110727,65.43431,54.065286,100,79.974631,98.874012,53.898531,61.309679,68.004178,59.875862,19.390797,72.752409,80.541238,100,99.597746,32.635636,91.571289,60.061734,63.179324,60.026948,24.984485,58.26219,59.044706,100,72.700238,67.243818,75.022639,59.189371,66.942763,50.041323,28.843179,65.900286,57.559777,100,51.509386,14.286282,88.995563,26.552556,47.320854,67.309566,46.972587,100,69.901847,48.194467,85.047508,96.631288,45.719255,48.950396,85.990726,56.113543,22.79102,94.016619,48.590755,37.76317,37.80507,20.158182,100,41.487693,14.808692,56.85664,31.834964,47.185926,19.827401,22.909145,100,8.530785,9.646596,48.81232,16.989276,54.319507,25.976034,77.900779,61.754004,39.090741,37.043337,47.827907,100,29.179194,15.490137,22.781643,17.639981,76.562458,43.721758,30.019516,11.816774,99.460014,25.260945,100,71.525185,33.865201,26.088258,89.918337,54.470899,44.850138,92.358861,29.25839,100,86.136222,14.686831,36.981577,41.709542,70.818244,33.685142,30.543932,13.795618,86.383396,16.664416,36.674122,100,55.235121,17.797673,47.87044,25.746128,23.962923,88.982779,12.945039,90.153997,100,15.782023,55.780406,22.675723,100,40.465842,29.594844,75.436518,14.094248,16.466869,95.599227,35.892659,35.073314,31.795582,69.05955,59.422792,36.720163,64.270581,42.897804,100,90.945266,12.574645,17.070693,22.39484,100,67.999942,53.650078,30.545531,39.658845,65.029278,72.270223,20.295994,17.153776,24.001844,78.953216,36.180941,42.191503,83.745094,15.818314,65.486625,100,17.290135,56.661523,24.326423,40.816254,100,14.643106,56.752449,49.406932,59.623299,58.944428,14.419549,44.812607,17.446889,25.100068,56.451611,100,31.60991,51.07245,23.386431,8.400181,26.959308,6.644571,7.090514,48.116093,100,88.408673,13.194803,63.252271,88.756029,48.181564,14.853929,57.539991,11.912314,37.876172,75.210203,100,64.392227,61.625817,46.620725,11.861651,44.193426,10.962111,9.732353,31.861365,62.815448,9.138219,100,54.322884,55.671186,37.293925,11.826952,31.84291,7.439814,42.307769,100,83.950739,73.117628,80.261772,50.250437,15.515457,53.444897,11.352542,12.830967,58.153858,13.471094,80.82525,16.526785,100,75.341789,81.024045,68.560439,15.457162,44.347498,30.956151,60.752673,7.403644,100,41.80038,50.060375,29.290863,10.243744,30.573695,9.632632,36.510415,62.205208,10.164047,14.514665,100,53.288246,70.628308,30.491622,12.174714,29.969661,44.495042,100,81.153919,12.448223,59.886445,64.401379,40.968651,14.145006,49.93086,12.795717,28.875128,56.084434,12.183446,100,50.614347,42.571198,8.57755,39.311134,8.978232,32.550811,48.134053,38.493086,47.297687,100,60.232316,52.434037,73.524123,26.622715,43.449777,23.968349,67.329316,46.19623,51.877517,100,59.786952,55.176902,24.699748,39.760108,17.242093,18.240418,58.50983,58.047868,57.901065,100,36.179152,71.183389,63.866704,31.542686,34.055523,23.597953,67.200049,83.453012,100,65.975587,51.129753,75.099995,81.450637,42.63681,63.975236,27.608757,49.84706,49.857636,55.843535,100,34.42706,55.708519,63.98104,21.462487,36.750355,24.039332,91.172312,88.879785,90.982178,81.529316,93.063196,96.009841,100,35.712393,55.355501,29.9587,11.022862,100,14.114127,44.124393,38.652411,56.985621,18.555109,18.033222,19.934592,11.012226,20.66338,100,40.413095,91.689761,17.123381,66.96407,42.409931,26.803718,24.42167,17.649164,13.163825,100,15.211943,60.663635,75.920117,15.665012,42.561695,29.990686,32.359587,20.729874,15.467534,18.80249,100,13.634269,50.207745,49.6486,97.888206,34.440725,33.351218,21.565606,20.069342,19.697847,100,56.385026,71.324505,56.035122,47.97193,37.990945,23.103459,19.881222,100,12.424727,13.137711,49.097741,25.062855,48.406579,49.844405,25.317119,21.375548,19.440307,100,21.233178,65.954368,13.808341,40.554152,61.031212,44.528072,29.744586,23.372693,27.098562,100,53.744055,15.334889,19.855871,82.032669,50.344054,35.900587,39.364539,28.407148,26.742755,15.419747,100,40.460776,17.485344,66.669006,40.154223,53.950625,24.802116,20.151417,26.209282,100,13.29545,61.759593,17.091298,54.213773,47.80192,47.607135,19.713762,27.196707,27.455925,100,53.768376,14.765737,38.022142,47.25845,33.589032,22.778764,25.666545,22.421729,14.460156,100,60.442452,15.028846,71.073328,49.016563,33.366498,20.071604,18.006724,19.097784,15.813429,100,51.682501,9.948952,12.57085,38.621101,46.596932,23.396373,19.88269,23.48903,11.050334,100,15.08708,55.811472,15.518814,14.984243,50.419247,25.823998,27.296331,26.212343,26.943348,100,10.202596,9.515358,44.518922,57.230777,34.192945,54.761944,26.190048,11.332064,13.941862,100,37.926519,14.743216,52.075892,29.381923,13.796331,51.324036,17.790727,16.758268,18.569193,14.123322,100,70.666273,20.41544,88.597794,47.257589,25.418209,21.808236,26.116333,15.450127,100,14.298772,63.93333,98.726654,14.928135,58.636811,36.599936,17.461401,21.202078,19.159226,15.658284,16.620882,98.632552,36.49942,22.102521,100,30.327862,22.969966,17.435491,18.416248,18.477255,84.747147,18.201527,59.2231,100,61.188716,40.875424,26.655137,25.433262,20.023674,100,18.357258,15.841706,79.944657,84.081248,75.799994,44.049653,33.226075,33.691827,21.152486,17.699948,83.344014,14.118591,61.039614,100,19.043033,48.074472,50.581133,20.194037,21.459679,100,17.428861,18.910767,71.451755,42.946026,67.720642,57.653603,29.379123,35.505059,26.594661,13.309821,100,14.63158,52.770548,31.362358,49.695889,39.358759,21.631738,27.317533,16.583666,19.077345,19.638878,100,17.883571,55.183692,57.975966,56.378697,40.12388,34.00559,26.179219,86.717556,16.703482,48.410311,15.907776,100,59.414451,42.12065,23.716578,26.191836,19.743941,100,16.17168,48.614196,11.739146,47.356521,42.89255,42.311294,25.465574,29.226533,17.54219,22.030598,29.496914,100,15.532056,70.12813,89.95875,49.580514,54.420266,22.614829,23.513358,12.825897,65.434834,12.806889,10.439998,59.083319,100,26.57258,29.398942,15.500518,11.587514,19.395831,21.342078,64.884512,15.211313,100,42.361615,55.470963,37.763217,30.095447,27.023809,13.590274,58.131382,11.484852,56.246497,14.326195,100,29.654273,28.179089,15.768894,12.672645,30.129197,17.505914,20.344298,73.980463,100,43.092992,60.790209,58.724209,36.937673,24.727567,12.089807,76.067926,18.401722,71.176831,17.679461,100,38.482426,31.584263,19.649747,18.19539,17.288126,31.9796,15.928108,87.017563,20.308594,100,30.422126,36.426906,16.362386,15.997518,20.882723,10.605125,64.189675,24.39705,12.069897,48.572579,17.005227,13.388589,80.450559,100,17.857601,71.974213,15.400636,16.605123,100,37.516991,50.993974,39.592669,26.724196,23.809728,22.652435,65.112428,18.344776,89.236974,100,17.904134,44.285295,40.145077,27.612603,20.847306,12.952292,38.273237,9.616765,68.352875,100,16.80857,10.329021,20.972557,14.030135,11.66208};
        int[] group_num = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8};
        Bundle extras = getIntent().getExtras();
        String [] str_x_values = extras.getStringArray("x_vals");
        String [] str_y_values = extras.getStringArray("y_vals");
        ArrayList<DistanceAndGroup> distance_group = new ArrayList<DistanceAndGroup>(); //append to this
        int [] x_values = new int[10];
        int group_amount = 9;
        int [] group_freq = new int[group_amount];
        int k_val = 5;
        double [] y_values = new double[10];

        double [] temp_distance_group = new double[20];

        for(int i=0;i<10;i++){
            //remove the newline and carriage return characters
            str_x_values[i] = str_x_values[i].replace("\n", "").replace("\r", "");
            str_y_values[i] = str_y_values[i].replace("\n", "").replace("\r", "");
            //convert to int and doubles
            x_values[i] = Integer.parseInt(str_x_values[i]);
            y_values[i] = Double.parseDouble(str_y_values[i]);
        }

        Log.i("2nd ACt","Check arrays");
        //begin finding frobenius norm and storing the data into
        double max_value = y_values[0];
        for(int i=0;i<10;i++){
            y_values[i] = (y_values[i]/max_value)*100;
        }
        //place values in an arraylist of object
        ArrayList<SortByXValue> sort_xvalue = new ArrayList<SortByXValue>();
        for(int i=0;i<10;i++){
            sort_xvalue.add(new SortByXValue(x_values[i],y_values[i]));
        }
        //sort the values now
        sort_xvalue.sort(Comparator.comparingInt(SortByXValue::getX_value));
        //place the values back into the x and y arrays
        int temp_iter = 0;
        for(SortByXValue iter: sort_xvalue){
            x_values[temp_iter] = iter.getX_value();
            y_values[temp_iter] = iter.getY_value();
            temp_iter++;
        }
        //first subtract the two 'matrices' from eachother
        //include offset variable
        for(int j=0; j<(sample_y.length);j = j+10) {
            for (int i = 0; i < 10; i++) {
                temp_distance_group[i] = Math.abs(x_values[i] - sample_x[i + j]);
                temp_distance_group[i + 10] = Math.abs(y_values[i] - sample_y[i + j]);
            }
            double f_norm = 0;
            for (int k = 0; k < 20; k++) {
                f_norm = f_norm + Math.pow(temp_distance_group[k], 2);
            }
            f_norm = Math.sqrt(f_norm);
            distance_group.add(new DistanceAndGroup(f_norm, group_num[j]));
        }
        /*
        distance_group.sort((d1,d2)->{
            return d1.getDistance()-d2.getDistance();
        });
        for(int i=0;i<k_val;i++){
            if(distance_group[i].getGroup){

            }
        }
        */
        distance_group.sort(Comparator.comparingDouble(DistanceAndGroup::getDistance));


        int k_iter = 0;
        for(DistanceAndGroup iter: distance_group){
            if(k_iter >= k_val){
                break;
            }
            if(iter.getGroup()==0){
                group_freq[0]++;
            }
            else if(iter.getGroup()==1){
                group_freq[1]++;
            }
            else if(iter.getGroup()==2){
                group_freq[2]++;
            }
            else if(iter.getGroup()==3){
                group_freq[3]++;
            }
            else if(iter.getGroup()==4){
                group_freq[4]++;
            }
            else if(iter.getGroup()==5){
                group_freq[5]++;
            }
            else if(iter.getGroup()==6){
                group_freq[6]++;
            }
            else if(iter.getGroup()==7){
                group_freq[7]++;
            }
            else if(iter.getGroup()==8){
                group_freq[8]++;
            }
            k_iter++;
        }
        int temp_max = group_freq[0];
        int max_group = 0;
        for(int i=1;i<group_freq.length;i++){
            if(temp_max < group_freq[i]){
                temp_max = group_freq[i];
                max_group = i;
            }
        }
        if(max_group == 0){
            chord_id.setText("Open E Major");
        }
        else if(max_group == 1){
            chord_id.setText("Open A Major");
        }
        else if(max_group == 2){
            chord_id.setText("F Major");
        }
        else if(max_group == 3){
            chord_id.setText("Open G Major");
        }
        else if(max_group == 4){
            chord_id.setText("Open D Major");
        }
        else if(max_group == 5){
            chord_id.setText("Open C Major");
        }
        else if(max_group == 6){
            chord_id.setText("Open E Minor");
        }
        else if(max_group == 7){
            chord_id.setText("Open A Minor");
        }
        else if(max_group == 8){
            chord_id.setText("Open D Minor");
        }
    }
}
