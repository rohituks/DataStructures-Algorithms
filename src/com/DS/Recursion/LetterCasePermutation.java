package com.DS.Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> resultImmutable = new ArrayList<>();
    public List<String> resultMutable= new ArrayList<>();

    public static void main(String[] args) {
        String st = "a1z";
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        letterCasePermutation.runOverall(st);
    }

    /*
    https://leetcode.com/problems/letter-case-permutation/
    https://www.tutorialspoint.com/how-to-check-if-a-given-character-is-a-number-letter-in-java
    Letter Case Permutation
        Return the set of strings which can be generated from a given string by changing the case of a group of letter(s).
        Return all the possible strings in lexicographic order.
        Example One:
        Input: “a1z”
        Output: [“A1Z”, “A1z”, “a1Z”, “a1z”]
        Example Two:
        Input: “123”
        Output: [“123”]
     */




    public void runOverall (String s){
        helperimmutable(s ,0 ,"");
        System.out.println("The result of immutable combination " +  resultImmutable);
        helperMutable(s ,0 ,"");
        System.out.println("The result of Mutable combination " +  resultMutable);
    }


    public List<String> helperimmutable(String input, int i, String slate){
        // Base case: Leafnode
        if( i == input.length()){
        //Add the content of the slate to the global bag
            resultImmutable.add(slate);
            return resultImmutable;
        }

        //Recursive case: Internal node worker
        if( Character.isDigit(input.charAt(i)) ){
            helperimmutable(input, i+1, slate + input.charAt(i));
        }
        else if (Character.isAlphabetic(input.charAt(i))){
            helperimmutable(input, i+1, slate + Character.toLowerCase(input.charAt(i)));
            helperimmutable(input, i+1, slate + Character.toUpperCase(input.charAt(i)));

        }
        return resultImmutable;
    }

    public List<String> helperMutable(String st, int i, String slate) {
        if (i == st.length()) {
            resultMutable.add(String.join("", st));
            return resultMutable;
        }
        StringBuilder stb = new StringBuilder(slate);
        if (Character.isDigit(st.charAt(i))){
            stb.append(st.charAt(i));
            helperMutable(st, i+1, slate);
            st.substring(0, st.length() -1);
        }
        else if (Character.isAlphabetic(st.charAt(i))){
            stb.append(Character.toLowerCase(st.charAt(i)));
            helperMutable(st, i+1, stb.toString() );
            stb.substring(0, stb.length() -1);
            stb.append(Character.toUpperCase(st.charAt(i)));
            helperMutable(st, i+1, stb.toString() );
            stb.substring(0, stb.length() -1);
        }
        return resultMutable;
    }

}
