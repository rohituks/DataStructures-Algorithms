package com.DS.Sorting;

public class OddEvenSwap {
    public static void main(String[] args){

        int[] inputarr = {-20, 34, 1, 345, 98, 21};
        int i = 0;
        int j = inputarr.length -1;

        while ( i < j) {
            if (inputarr[j] % 2 == 0) {
                swap(inputarr, i, j);
                i++;
            } else
                j--;
        }

        for( int q =0; q <inputarr.length; q ++){
            System.out.println(inputarr[q]);
        }
    }
    public static void swap(int[] inputarray, int startIndex, int endIndex){
        if( startIndex == endIndex){
            return;
        }

        int tempVariable = inputarray[startIndex];
        inputarray[startIndex] = inputarray[endIndex];
        inputarray[endIndex] = tempVariable;
    }

}
