package com.DS.DP;

import java.util.Arrays;

public class UniquePaths {
    /*
    https://leetcode.com/problems/unique-paths/
     */

    public static void main(String[] args){
        int m=3;
        int n=7;
        System.out.println(usingTabulation(m, n));
        System.out.println(usingMemoization(m, n));
    }
    public static int usingTabulation(int m, int n){
        int[][] grid = new int[m][n];

        for(int row=0; row <= m-1; row++){
            grid[row][0] =1;
        }

        for(int col=0; col <= n-1; col++) {
            grid[0][col] = 1;
        }


        for(int i =1; i<m; i++){
            for(int j=1; j<n; j++){
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }


        return grid[m-1][n-1];
    }

    public static int usingMemoization(int m, int n){
        if(m==1 || n==1){
            return 1;
        }

        return usingMemoization(m-1, n) + usingMemoization(m, n-1);
    }
}
