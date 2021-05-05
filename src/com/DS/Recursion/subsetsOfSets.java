package com.DS.Recursion;

public class subsetsOfSets {

    public static void main(String[] args){

        int noOfSets = 4;

        System.out.println(setsOfSubsets(noOfSets));
    }

    static int setsOfSubsets(int numberoFSets){
        if( numberoFSets ==0){
            return 1;
        }

        return 2 * setsOfSubsets(numberoFSets -1);
    }
}
