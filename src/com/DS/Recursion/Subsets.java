package com.DS.Recursion;

import java.util.*;

public class Subsets {

      /*
        https://leetcode.com/problems/subsets/
     */
    public List<String> output = new LinkedList<>();

    public static void main (String[] args){
        String st = "abc";
        Subsets subsets = new Subsets();
        subsets.helper(st, 0, "");
    }

    private List<String> helper(String inputString, int i, String subsets) {
        if( i == inputString.length()){
            output.add(subsets);
            return output;
        }
        System.out.println(subsets);
//        Set<String> map = new HashSet<>();
        StringBuilder st = new StringBuilder(subsets);
        helper(inputString, i+1, st.toString());
        st.append(inputString);
        helper(inputString, i+1, st.toString());
        st.substring(0, st.length()-1);

        long hello =0;
        int number = 0;

        if(number == hello){
            System.out.println("worked");
        }
        return output;
    }


}
