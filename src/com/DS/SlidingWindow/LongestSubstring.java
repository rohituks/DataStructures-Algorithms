package com.DS.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Variable Length with hashmap
 */
public class LongestSubstring {


    public static int fruitsintobasket(int[] fruits) {
        int maxWindowSize = Integer.MIN_VALUE;//We are trying to minimize
        int windowStart = 0;
        Map<Integer,Integer> basketMap= new HashMap<>();

        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
            basketMap.put(fruits[windowEnd], basketMap.getOrDefault(fruits[windowEnd],0) +1 ); // array

            while(windowStart < windowEnd && basketMap.size() > 2) {
                basketMap.put(fruits[windowStart], basketMap.getOrDefault(fruits[windowEnd],0) -1);
                if(basketMap.get(fruits[windowStart]) ==0)
                    basketMap.remove(fruits[windowStart]);
                windowStart++;
            }
            maxWindowSize = Math.max(maxWindowSize, windowEnd - windowStart + 1);
        }

        return maxWindowSize;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,2,2};
        System.out.println(fruitsintobasket(input));
        //System.out.println(totalFruit(input));
    }
}
