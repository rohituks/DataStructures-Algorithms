package com.DS.Recursion;

import java.util.*;

public class Permutations {

    /*
    https://leetcode.com/problems/permutations/
    https://leetcode.com/problems/permutations-ii/
     */


    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> nums_lst = new ArrayList<>();
        List<List<Integer>> nums_II = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        System.out.println("Permutations");
        System.out.println(nums);
        System.out.println(permutations.helper(nums, 0, nums_lst));
        System.out.println("Permutations-II");
        List<Integer> nums1 = new ArrayList<>();
        nums1.add(1);
        nums1.add(1);
        nums1.add(2);
        System.out.println(nums1);
        System.out.println(permutations.helperII(nums1, 0, nums_II));

    }



    private List<List<Integer>> helper(List<Integer> arr, int i, List<List<Integer>> slate){

        //Base case
        if(i == arr.size()){
            slate.add(new ArrayList<>(arr));
            return slate;
        }

        //Recursive case
        for (int j= i; j < arr.size() ; j ++ ){
                swapValues(arr, i, j);
                helper(arr, i + 1, slate);
                swapValues(arr, i, j);
        }
        return  slate;

    }


    private List<List<Integer>> helperII(List<Integer> arr, int i, List<List<Integer>> slate){

        //Base case
        if(i == arr.size()){
            slate.add(new ArrayList<>(arr));
            return slate;
        }

        Set<Integer> map = new HashSet<>();
        //Recursive case
        for (int j= i; j < arr.size() ; j ++ ){
            if (!map.contains(arr.get(j) )) {
                map.add(arr.get(j));
                swapValues(arr, i, j);
                helperII(arr, i + 1, slate);
                swapValues(arr, i, j);
            }
        }
        return  slate;

    }


    private void swapValues(List<Integer> input, int i, int j) {
        int temp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, temp);
    }
}
