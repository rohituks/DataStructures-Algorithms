package com.DS.Sorting;

public class InsertionSortIterative {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int unSortedIndex = 1; unSortedIndex < intArray.length; unSortedIndex++) {
            int newElement = intArray[unSortedIndex];
            int i;

            for (i = unSortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }
            intArray[i] = newElement;
        }
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}
