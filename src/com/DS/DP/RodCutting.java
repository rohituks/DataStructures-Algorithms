package com.DS.DP;

import java.util.Arrays;

public class RodCutting {

    public static void main(String[] args){
        int[] prices = {2,4,5,6,7};
        int rodLength = 5;
        System.out.println(rodLength);
        /*Store previously stored result
        Optimal Substructure - An optimal solution can be constructed
        Overlalapping Subproblems
        */
    }
    public static int fibonacciDP(int n){
        int result=0;

        return result;
    }

        /*
     * Complete the function below.
     */
    /*
    static int get_maximum_profit(List<Integer> price) {
        int l = price.size();
        int[] table = new int[l+1];


        for (int i=1; i<=l; i++) {
            int maxRev = 0;
            for (int cut = 1; cut<=i; cut++) {
                int rev = table[i-cut] + price.get(cut-1);
                maxRev = Math.max(maxRev, rev);
            }
            table[i] = maxRev;
        }

        return table[l];
    }

     */
}
