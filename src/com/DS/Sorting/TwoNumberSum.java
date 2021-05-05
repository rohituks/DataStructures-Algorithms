package com.DS.Sorting;

public class TwoNumberSum {

    public static void main(String[] args) {

        int[] intArray = {31, 35, -15, 7, 55, 1, 5};
        int target = 36;
       int[] numbers = sumOfNumbers(intArray, target);

       for (int i=0; i< numbers.length; i++ ){
           System.out.println(numbers[i]);
       }

    }

    static int[] sumOfNumbers(int[] inputArray, int sum) {

        for (int i = 0; i < inputArray.length ; i++) {
            for (int j = inputArray.length - 1; j > 0; j--) {
                if (inputArray[j] == sum - inputArray[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("Numbers not found");
    }
}
