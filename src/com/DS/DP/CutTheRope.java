package com.DS.DP;

public class CutTheRope {

    public static void main(String[] args){
        CutTheRope cutTheRope = new CutTheRope();
        System.out.println(cutTheRope.max_product_from_cut_pieces(5));
    }

    /*
     * Complete the max_product_from_cut_pieces function below.
     */
    public  long max_product_from_cut_pieces(int n) {
        /*
         * Write your code here.
         */
        long[] table = new long[n+1];

        //Base case
        table[1] =1;
        //recursive loop
        for(int i=1; i<=n; i++){ //loop through length of the rope
            for (int j=1; j <= i/2; j++){
                table[i] =Math.max(Math.max(table[j], j) * Math.max(table[i-j], i-j), table[i]);
            }
        }
        return table[n];
    }


}
