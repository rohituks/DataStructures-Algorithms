package com.DS.Recursion;

public class Factorial {

    public static void main (String[] args) {
//        iterativeFactorial( 4);
        int output = recursiveFactorial(4);
    }

    //n! = n * (n-1) !

    // Time Complexity of recursive solution  - O(n) -> similar to iterative solution
    public static int recursiveFactorial(int n){
        if ( n ==1){
            return 1;
        }
        return  n * recursiveFactorial(n-1);

    }

    public static int iterativeFactorial(int n) {
        if ( n == 0){
            return 1;
        }

        int factorial =1;
        for (int i=1; i <=n ; i++ ){
            factorial *= i;
        }

        return factorial;
    }
}
