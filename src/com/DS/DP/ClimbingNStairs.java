package com.DS.DP;

public class ClimbingNStairs {

    public static void main (String[] args){
        int nthstairs =10;
        System.out.println(climbingNstair(nthstairs));
    }


    public static int climbingNstair(int stairs){
        if( stairs ==1 || stairs ==2){
            return stairs;
        }
        Integer[] result = new Integer[stairs +1];

        result[0] = 0;
        result[1] = 1;
        result[2] = 2;


        for (int i=3; i <=stairs; i++){
            result[i] = result[i-1] + result[i-2];
        }
        return result[stairs];
    }
}
