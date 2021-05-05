package com.DS.SearchAlgorithms;

public class LinearSearch {

    public static void main (String[] args){
        int[] arr = {20,35,-15,7,55,1,-22};

        System.out.println(linearSearch(arr, 35));
        System.out.println(linearSearch(arr, 12));
        System.out.println(linearSearch(arr, 55));
        System.out.println(linearSearch(arr, 455));
    }

    static int linearSearch(int[] inputArr, int number){

        for(int i=0; i<inputArr.length; i++){
            if(inputArr[i] == number){
                return i;
            }
        }
        return -1;
    }
}
