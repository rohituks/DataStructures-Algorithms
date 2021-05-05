package com.DS.Sorting;

public class MergeSortAscending {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(intArray, 0, intArray.length);

        for (int i =0; i<intArray.length; i++){
            System.out.println(intArray[i]);
        }
    }

    public static void mergeSort(int[] inputArray, int start, int end) {
        if (end - start <= 1) {
            return;
        }
//        int mid = (start + end) / 2;
        int mid = start + (end-start)/2 ;// To not have Overflow error we dont do (start+end)/2
        mergeSort(inputArray, start, mid);
        mergeSort(inputArray, mid, end);
        merge(inputArray, start, mid, end);


    }

    //{20,35,-15,7,55,1,-22}
    public static void merge(int[] inputArray, int start, int mid, int end) {
        if (inputArray[mid - 1] <= inputArray[mid]) {
            return;
        }
        int i = start;
        int j = mid;

        int tempindex = 0;

        int[] temparray = new int[end - start];

        while (i < mid && j < end) {

            temparray[tempindex++] = inputArray[i] <= inputArray[j] ? inputArray[i++] : inputArray[j++];
        }
        //{32, 34} , {33, 36}
        //{ 32, 33, 34 , }

        System.arraycopy(inputArray, i, inputArray, start + tempindex, mid - i);

        System.arraycopy(temparray, 0, inputArray, start, tempindex);

    }

}

