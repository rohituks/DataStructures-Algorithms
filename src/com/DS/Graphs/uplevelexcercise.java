package com.DS.Graphs;

import java.util.*;

public class uplevelexcercise {


    public static void main(String[] args){
        List<Integer> edges1 = new LinkedList<>();
        edges1.add(0);
        edges1.add(0);
        edges1.add(0);
        List<Integer> edges2 = new LinkedList<>();
        edges2.add(1);
        edges2.add(2);
        edges2.add(3);


        //#323 Leetcode Connected Graph
        System.out.println(is_it_a_tree(4, edges1, edges2));
    }
/*

    public static boolean is_it_a_tree(int node_count, List<Integer> edge_start, List<Integer> edge_end) {
        int[] visited = new int[node_count];
        int[] parent = new int[node_count];
        int connectedComponent =0;
        List<List<Integer>> adjList = new ArrayList<>(node_count);

        for(int i=0; i<node_count ; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i< edge_start.size(); i++){
            adjList.get(edge_start.get(i)).add(edge_end.get(i));
            adjList.get(edge_end.get(i)).add(edge_start.get(i));
        }

        for(int i=0; i<node_count; i++){
            if(visited[i] ==0){
                if(connectedComponent >1){
                    return false;
                }
                if(!bfs(i, adjList, visited, parent)){
                    return false;
                }
                connectedComponent++;
            }
        }
        return true;
    }

    public static boolean bfs(int node, List<List<Integer>> adjList, int[] visited, int[] parent){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] =1;

        while(!queue.isEmpty()){
            Integer val = queue.remove();
            for(Integer neighbor : adjList.get(val)){
                if(visited[neighbor] == 0){
                    visited[neighbor] =1;
                    parent[neighbor] = val;
                    queue.add(neighbor);
                }
                else if(neighbor !=parent[val]){
                    return false;
                }
            }
        }
        return true;
    }
*/

    // Complete the function below
    static int[] visited = null;
    static int[] parent = null;
    static List<List<Integer>> adjList = null;

    public static boolean is_it_a_tree(int node_count, List<Integer> edge_start, List<Integer> edge_end) {
        adjList = new ArrayList<>(node_count);
        for (int i = 0; i < node_count; i++) {
            adjList.add(new ArrayList<>());
        }

        int n = node_count;

        for (int i = 0; i < edge_start.size(); i++) {
            adjList.get(edge_start.get(i)).add(edge_end.get(i));
            adjList.get(edge_end.get(i)).add(edge_start.get(i));
        }

        visited = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = -1;
        }

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }

        int comps = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                if (!bfs(i) || comps >= 1) {
                    return false;
                }

                comps++;
            }
        }

        return true;
    }

    static boolean bfs(int s) {
        Deque<Integer> queue = new ArrayDeque<Integer>();

        visited[s] = 1;
        queue.addLast(s);

        while (!queue.isEmpty()) {
            int node = queue.removeFirst();

            for (int i = 0; i < adjList.get(node).size(); i++) {
                int nbr = adjList.get(node).get(i);
                if (visited[nbr] == -1) {
                    visited[nbr] = 1;
                    parent[nbr] = node;
                    queue.addLast(nbr);
                } else {
                    if (nbr != parent[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


}
