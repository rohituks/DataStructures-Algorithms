package com.DS.TwoPointer;

//Binary search problem LC-704

public class BinarySearch {
    public static int twopointerApproach(int[] arr, int aTarget){
        int i =0;
        int j = arr.length -1;

        while(i<=j){//for loop

            int midindex = (i+j)/2;
            ///
            if(arr[midindex] == aTarget){
                return midindex;
            } else if (arr[midindex] < aTarget){
                i++;
            } else {
                j--;
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,7,8,18};
        int target = 18;
        System.out.println(twopointerApproach(input, target));
        
    }

}
