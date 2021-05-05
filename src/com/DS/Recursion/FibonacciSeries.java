package com.DS.Recursion;

public class FibonacciSeries {

    public static void main(String[] args){
        int nthElement = 4;
        System.out.println(fibonacciCalc(nthElement));

        System.out.println(fibonacciLinear(nthElement, 1 , 1 ));
    }

    //non-liner time execution O(1.4^n)
    static int fibonacciCalc(int n){
        if( n ==0 || n == 1){
            return 1;
        }

        return fibonacciCalc(n -1) + fibonacciCalc(n -2);
    }

    static int fibonacciLinear(int n, int base1, int base2){
        if( n==0){
            return base1;
        }

        return fibonacciLinear( n-1 , base2, base1 + base2);
    }
}
