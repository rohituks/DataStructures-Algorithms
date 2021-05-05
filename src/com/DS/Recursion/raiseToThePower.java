package com.DS.Recursion;

public class raiseToThePower {

    public static void main(String[] args){

        int number = 2;
        int power = 3;

        System.out.println(raiseToThePower(number, power));

    }

    /*
    Time Complexity - Recursive and Iterative  O(k)
     */

    static int raiseToThePower(int number, int power){
        if( power == 0){
            return 1;
        }
        return  number * raiseToThePower(number, power -1);
    }
}
