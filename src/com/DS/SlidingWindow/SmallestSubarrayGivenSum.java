package com.DS.SlidingWindow;

public class SmallestSubarrayGivenSum {

    public static int smallestSubarray(int targetSum, int[] arr) {
        int minWindowSize = Integer.MAX_VALUE;//We are trying to minimize
        int currentWindowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentWindowSum += arr[windowEnd];

            while(currentWindowSum >= targetSum) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currentWindowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return minWindowSize;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4,2,2,7,8,1,2,8,10};
        int targetSum = 8;
        System.out.println(smallestSubarray(targetSum, input));
    }
}