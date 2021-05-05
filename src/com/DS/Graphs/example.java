package com.DS.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class example {


    public static void main(String[] args){
        List<Integer> edges1 = new LinkedList<>();
        edges1.addAll(Arrays.asList(1,3));
        List<Integer> edges2 = new LinkedList<>();
        edges2.addAll(Arrays.asList(0,2));



        //root = [1,2,3,4,5,6,7]

        //#323 Leetcode Connected Graph

        System.out.println(can_be_divided(5, edges1, edges2));
    }

    // Complete the function below.
    public static boolean can_be_divided(int num_of_people, List<Integer> dislike1, List<Integer> dislike2){
        List<Integer> [] adjList = new ArrayList[num_of_people];
        for (int i = 0; i < num_of_people; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int j = 0; j < dislike1.size(); j++) {
            adjList[dislike1.get(j)].add(dislike2.get(j));
            adjList[dislike2.get(j)].add(dislike1.get(j)); // both ways
        }

        boolean [] visited = new boolean[num_of_people];
        int [] parent = new int[num_of_people];
        int [] color = new int[num_of_people];
        for (int k = 0; k < num_of_people; k++) {
            if (!visited[k]) {
                if (dfs(k, adjList, visited, parent, color))
                    return false;
            }
        }

        return true;
    }

    public static boolean dfs(int node, List<Integer>[] adjList, boolean [] visited, int [] parent, int [] color) {
        visited[node] = true;
        for (int neighbor: adjList[node]) {
            if (!visited[neighbor]) {
                parent[neighbor] = node;
                color[neighbor] = 1 - color[node];
                if (dfs(neighbor, adjList, visited, parent, color))
                    return true;
            } else {
                if (neighbor != parent[node])
                    if (color[node] == color[neighbor])
                        return true; // cannot be split
            }
        }

        return false;
    }

}
