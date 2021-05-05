package com.DS.Sorting;

import java.util.Arrays;
import java.util.List;

public class MergeSortDescending {

    public static void main(String[] args) {

        // Using List of Integers as input here. Converting Integers to Arrays.
        List<Integer> integerList = Arrays.asList(20, 35, -15, 7, 55, 1, -22);

        int[] intArray = new int[integerList.size()];

        for( int j=0; j<intArray.length; j++){
            intArray[j] = integerList.get(j);
        }


        mergeSort(intArray, 0, intArray.length);

        for (int i=0; i<intArray.length; i++){
            System.out.println(intArray[i]);
        }
    }

    public static void mergeSort(int[] inputArray, int startIndex, int endIndex){
        if (endIndex - startIndex <= 1){
            return;
        }
        int mid = startIndex + (endIndex - startIndex)/2;
//        System.out.println(startIndex + "," + mid + "," + endIndex);
        mergeSort(inputArray, startIndex, mid);
        mergeSort(inputArray, mid, endIndex);

        merge(inputArray, startIndex, mid, endIndex);

    }

    private static void merge(int[] inputArray, int startIndex, int midIndex, int endIndex) {
        if (inputArray[midIndex-1] >= inputArray[midIndex]){
            return;
        }
        int i = startIndex;
        int j = midIndex;
        int tempindex =0;
        int[] tempArray = new int[endIndex-startIndex];

        while(i < midIndex && j < endIndex){
            tempArray[tempindex++] = inputArray[i] >= inputArray[j] ? inputArray[i++] : inputArray[j++];
        }

        System.arraycopy(inputArray, i, inputArray, startIndex + tempindex, midIndex -i);
        System.arraycopy(tempArray, 0, inputArray, startIndex, tempindex);
    }

}

