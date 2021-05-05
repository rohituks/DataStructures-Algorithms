package com.DS.Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] intArray = {20,35,-15,7,55,1,-22};
        /* -Variation of Brute Force
           - Time complexity = Θ(n

         */
        for(int i = intArray.length -1; i >= 0 ; i --)
        {
            for (int j = 0; j < i ; j++){
                if (intArray[j]> intArray[j+1]){
                    swap(intArray,j, j+1);
                }

            }
        }
        for (int i=0;i< intArray.length ; i++){
            System.out.println(intArray[i]);
        }
    }

    private static void swap (int[] intArrays, int i, int j){
        if ( i == j) {
            return;
        }
        int temp = intArrays[i];
        intArrays[i] = intArrays[j];
        intArrays[j] = temp;


    }
}
