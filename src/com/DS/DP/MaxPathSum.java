package com.DS.DP;

import java.util.Arrays;

public class MaxPathSum {

    public static void main(String[] args){
        //[[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
//        System.out.println(Arrays.deepToString(grid));
        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println(maxPathSum.maximumPath(grid));
    }

    public int maximumPath(int[][] inputgrid){
        int m = inputgrid.length;
        int n = inputgrid[0].length;
        int[][] table = new int[m][n];
        //table[i][j] will store the value of the max path from (0,0) to (i,j)
        table[0][0] = inputgrid[0][0]; // Top values, first values are same

        for (int i=1; i<=n-1; i++){
            table[0][i] = table[0][i-1] + inputgrid[0][i];
        }

        for (int i=1; i<=m-1; i++){
            table[i][0] = table[i-1][0] + inputgrid[i][0];
        }

        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                table[i][j] = inputgrid[i][j] + Math.max(table[i-1][j] ,table[i][j-1]);
            }
        }

        return table[m-1][n-1];
    }
}
