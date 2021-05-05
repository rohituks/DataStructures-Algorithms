package com.DS.Sorting;

public class Main {

    public static void main(String[] args) {
        int[] intArray = {20,35,-15,7,55,1,-22};

        for(int unSortedIndex = intArray.length -1; unSortedIndex >= 0 ; unSortedIndex --)
            {
                for (int i = 0; i < unSortedIndex ; i++){
                    if (intArray[i]> intArray[i+1]){
                        swap(intArray,i, i+1);
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
