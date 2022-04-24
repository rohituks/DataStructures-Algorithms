package com.DS.TwoPointer;

import java.util.Arrays;

import javax.print.event.PrintJobListener;

import ch.qos.logback.core.joran.conditional.ElseAction;

public class TwoSum {


    public static int[] TwoSumBruteForce(int[] arr, int aTarget){
        //Brute force way
        //int[] result = new int[2]; //1
        int i = 0; //start pointer
        for(i =0; i < arr.length; i++){ //n
            for(int j = i+1; j < arr.length; j++){ //n
                if (arr[j] == aTarget - arr[i]){ //1 
                    return new int[] {i,j}; //1
                }
            }

        }
        return null;//1
    }
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,7,8,18};
        int target = 15;
        //Brute Force Time Complexity -> O(n²) //Alt + 0178(right keypad)
        System.out.println(Arrays.toString(TwoSumBruteForce(input, target)));
        System.out.println(Arrays.toString(TwoSumTwoPointers(input, target)));
        //Lets try for O(nlogn)
        //Two pointer approach for O(n) time complexity
    }

    
    public static int[] TwoSumTwoPointers(int[] arr, int aTarget){
        //Two pointer way
        //Multiple pointers-> To keep track of multiple indices of the input.e.g., looking at two different indices at the same time.
        //int[] result = new int[2]; //1
        int i = 0; //start pointer
        int j = arr.length - 1;
        for(i =0; i < arr.length; i++){ //n // we can use while loop as well, Doesnt matter
            // This gap is very important, because depending upon problem we can write conidtions here
            if(arr[i] + arr[j]== aTarget){
                    return new int[] {i,j};
            }
            else if( arr[i] + arr[j] < aTarget)
            {
                i++;
            }
            else {
                j--;
            }
        }
        return null;//1
    }
    
}
