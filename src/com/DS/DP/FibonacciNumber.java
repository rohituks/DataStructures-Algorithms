package com.DS.DP;

public class FibonacciNumber {
    public static Integer[] cache = new Integer[31];

    public static void main(String[] args){
        int nthElement = 10;
        /* 1-Top-Down Memoization Technique- This Technique is useful when lot of repeated work is done
        2 -Time Complexity is linear,
        3- NOt used frequently

         */
        System.out.println(fibonacciMemoization(nthElement));
        System.out.println(fibonacciTabulation(nthElement));
        /*Store previously stored result
        Optimal Substructure - An optimal solution can be constructed
        Overlalapping Subproblems
        */
    }
    public static int fibonacciMemoization(int n){
        if( n <= 1){
            return n;
        }

        cache[0]=0;
        cache[1]=1;
        return memoize(n);
    }

    public static int memoize(int fibNumber){
        if(cache[fibNumber] != null){
            return cache[fibNumber];
        }
        cache[fibNumber] = memoize(fibNumber -1 ) + memoize( fibNumber -2);
        return memoize(fibNumber);

        //Alternative way of doing memoization without using cache
/*        if(fibNumber ==0){
            return 0;
        }
        if(fibNumber ==1){
            return 1;
        }

        return memoize(fibNumber -1) + memoize( fibNumber -2);*/
    }


    public static int fibonacciTabulation(int n){
        if( n == 0 || n ==1){
            return n;
        }
        Integer[] table = new Integer[n + 1];
        table[0]=0;
        table[1]=1;
        for(int i=2; i<=n; i++){
            table[i%3] = table[(i-1)%3] + table[(i-2)%3];
        }
        return table[n%3];
    }

}
