package com.DS.Sorting;


public class InsetionSortRecursive {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int unSortedIndex = intArray.length - 1; unSortedIndex > 0; unSortedIndex--) {
            if (intArray[unSortedIndex - 1] > intArray[unSortedIndex]) {
                swap(intArray, unSortedIndex - 1, unSortedIndex);
            }
        }

        for (int i=0; i< intArray.length; i++){
            System.out.println(intArray[i]);
        }
    }
    public static void swap(int[] inputArray, int fromIndex, int toIndex){
        if(inputArray[fromIndex] < inputArray[toIndex]){
            return;
        }

        int tempValue = inputArray[toIndex];
        inputArray[toIndex] = inputArray[fromIndex];
        inputArray[fromIndex] = tempValue;
    }
}
