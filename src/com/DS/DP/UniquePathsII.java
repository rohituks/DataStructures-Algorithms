package com.DS.DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UniquePathsII {
    /*
    https://leetcode.com/problems/unique-paths-ii/
     */

    public static void main(String[] args){
        int[][] grid = {{0,0,0}, {0,1,0}, {0,0,0}};

        System.out.println(usingTabulation(grid));
    }
    public static int usingTabulation(int[][] inputgrid){
        int m = inputgrid.length;
        int n = inputgrid[0].length;
        int[][] table = new int[m][n];
        //For First cell- If first cell has obstacle, we cannot proceed
        if(inputgrid[0][0] == 1){
            return 0;
        }
        //for First column
        for(int row=1; row <= m-1; row++){
            if(inputgrid[row][0]==1){
                break;
            }
            table[row][0]=1;
        }

        for(int col=1; col <=n-1; col++){
            if(inputgrid[0][col]==1){
                break;
            }
            table[0][col] =1;
        }

        for(int i=1;i<m; i++){
            for(int j=1; j<n; j++){
                if(inputgrid[i][j]==1){
                    table[i][j]=0;
                }
                else
                {
                    table[i][j] = table[i-1][j] + table[i][j-1];
                }
            }
        }

        return table[m-1][n-1];
    }

    public static int usingMemoization(int[][] inputgrid){

        return 1;
    }
}
