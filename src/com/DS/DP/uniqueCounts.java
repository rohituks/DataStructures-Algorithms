package com.DS.DP;

import java.util.ArrayList;
import java.util.List;

public class uniqueCounts {

    public static void main(String[] args){
        uniqueCounts uniqueCounts = new uniqueCounts();
        System.out.println(uniqueCounts.countPaths(5,5));
//        System.out.println(uniqueCounts(5,5));
    }

    public  int countPaths(int m, int n){
        int[][] table = new int[m][n]; //For each vertices in the graph

        for(int i =0; i <m; i++ ){
            table[i][0] = 1;

        }

        for(int i=0; i <n ; i++){
            table[0][i]=1;
        }
        /*
                for(int[] arr : table) {
             Arrays.fill(arr, 1);
        }

        */

        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                table[i][j] = table[i-1][j] + table[i][j-1];
            }
        }


        return table[m-1][n-1];
    }


    /*Time Complexity   O(2n), when m == n
                        O(n), m<<n
                        O(m), n<<m

        C(m+n-2, m-1),  C(m+n-2,n-1) = C(m+n-2,m-1)
        For m=5, n=5, number of unique paths would be -
            C(8,4) = C(8,4) =(8x7x6x5)/(4x3x2x1) = 70
     */
}
