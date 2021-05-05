package com.DS.DP;

import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    //Incomplete

    public static void main(String[] args){
        System.out.println(Arrays.deepToString(generate(3)));
    }
    public static int[][] generate(int numRows){
        int[][] table = new int[numRows][numRows+1];

        for(int[] arr: table) {
            Arrays.fill( arr, 1);
        }

        for(int row=2; row < table.length; row++ ){
            for(int col =1; col< table[row].length-1; col++){
                table[row][col] = table[row-1][col] + table[row][col-1];
            }
        }
        return table;
    }
}
