package com.DS.Sorting;

public class BruteForce {

    //Also called Selection Sort
    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        for (int i = 0; i < intArray.length; i++)
        {
            int min = i;
            for (int j=0; j<intArray.length; j++) {
                if(intArray[i] < intArray[j]) {
                    swap(intArray, min, j);
                }
            }
        }

        for (int i=0; i< intArray.length; i++){
            System.out.println(intArray[i]);
        }

    }

    public static void swap(int[] array, int i, int j){
        if( i== j){
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
