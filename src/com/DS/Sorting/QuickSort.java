package com.DS.Sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22};

        quickSort(intArray, 0, intArray.length);

        for (int i =0; i<intArray.length; i++){
            System.out.println(intArray[i]);
        }
    }

    public static void quickSort(int[] inputArray, int start, int end) {
        if (end - start <= 1) {
            return;
        }
//        int mid = (start + end) / 2;
        int pivotIndex = partition(inputArray, start, end); ;
        quickSort(inputArray, start, pivotIndex);
        quickSort(inputArray, pivotIndex + 1, end);
    }

    //{20,35,-15,7,55,1,-22}
    public static int partition(int[] inputArray, int start, int end) {

        int pivot = inputArray[start];
        int i = start;
        int j = end;
        while (i <j){
            //This is empty loop
            while (i< j && inputArray[--j] >= pivot);
            if( i<j){
                inputArray[i] = inputArray[j];
            }
            //empty loop
            while ( i<j && inputArray[++i] <= pivot);
            if(i<j){
                inputArray[j] =inputArray[i];
            }

        }
        inputArray[j] = pivot;
        return j;

    }

}

