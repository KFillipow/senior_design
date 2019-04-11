package com.example.senior_design;

public class SampledData {
    float[] x_distance_group = new float[10];
    float[] y_distance_group = new float[10];
    int[]   group_num = new int[10];

    public SampledData(float[] x_distance_group, float[] y_distance_group, int[] group_num){
        this.x_distance_group = x_distance_group;
        this.y_distance_group = y_distance_group;
        this.group_num = group_num;
    }

    public float[] getx(){
        return x_distance_group;
    }

    public float[] gety(){
        return y_distance_group;
    }

    public int[] getGroup(){
        return group_num;
    }
}

