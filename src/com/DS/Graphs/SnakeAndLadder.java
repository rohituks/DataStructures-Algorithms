package com.DS.Graphs;

import java.util.*;

public class SnakeAndLadder {


    public static void main(String[] args){
        List<Integer> edges1 = new LinkedList<>();
        edges1.add(0);
        edges1.add(1);
        List<Integer> edges2 = new LinkedList<>();
        edges2.add(0);
        edges2.add(2);

        List<Integer> edges3 = new LinkedList<>();
        edges3.add(0);
        edges3.add(3);

        List<Integer> edges4 = new LinkedList<>();
        edges4.add(1);
        edges4.add(4);


        //root = [1,2,3,4,5,6,7]
        List<List<Integer>> edgesLists = new LinkedList<>();
        edgesLists.add(edges1);
        edgesLists.add(edges2);
        edgesLists.add(edges3);
        edgesLists.add(edges4);
        System.out.println(edgesLists);
        //#323 Leetcode Connected Graph
        System.out.println(snakeLadder(101, edgesLists));
    }
    static boolean snakeLadder(int n, List<List<Integer>> edgesList) {
        List<List<Integer>> adjList = new ArrayList<>(n);
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int connectedComponents = 0;
        //Incomplete
        return true;
    }
}
