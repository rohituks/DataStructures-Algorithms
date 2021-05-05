package com.DS.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CoinChange {

    public static void main(String[] args){
        List<Integer> coins = new ArrayList<>();
        coins.add(9);
        coins.add(1);
        coins.add(8);
        coins.add(10);
        coins.add(3);

        System.out.println(number_of_ways(coins, 12));
    }
    public static final int mod = 1000000007;
    public static int number_of_ways(List<Integer> coins, int amount) {
        int[] table = new int[amount+1]; //Initialize the table
        table[0] = 1 ; //Setting the first cell to some value
//        Arrays.fill(table, 1);

        for (int c : coins) { //Looping thru for all coins
            for (int i=1; i <= amount; i++) { // Looping thru amount
                if (c <= i) {
                    table[i] = table[i] % mod + table[i-c] % mod;
                }
            }
        }

        return table[amount] % mod ;
    }
}
