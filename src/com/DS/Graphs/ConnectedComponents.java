package com.DS.Graphs;


import java.util.*;

public class ConnectedComponents {

    public static void main(String[] args){
        List<Integer> edges1 = new LinkedList<>();
        edges1.add(0);
        edges1.add(1);
        List<Integer> edges2 = new LinkedList<>();
        edges2.add(1);
        edges2.add(2);

        List<Integer> edges3 = new LinkedList<>();
        edges3.add(3);
        edges3.add(4);

        //root = [1,2,3,4,5,6,7]
        List<List<Integer>> edgesLists = new LinkedList<>();
        edgesLists.add(edges1);
        edgesLists.add(edges2);
        edgesLists.add(edges3);
        System.out.println(edgesLists);
        //#323 Leetcode Connected Graph
        System.out.println(number_of_connected_components(5, edgesLists));
    }
    static int number_of_connected_components(int n, List<List<Integer>> edgesList){
        List<List<Integer>> adjList = new LinkedList<>();
        int connectedComponents=0;
        for(int i=0; i< n; i++){
            adjList.add(i, new ArrayList<>());
        }
        for (List<Integer> edge : edgesList){
            adjList.get(edge.get(0)).add(edge.get(1));
            adjList.get(edge.get(1)).add(edge.get(0));
        }
        int[] visited = new int[n];
        for (int i=0; i< n; i++){
            if(visited[i] == 0){
                connectedComponents++;
                bfs(i, adjList, visited);
//                dfs(i, adjList, visited);
            }
        }

        System.out.println("Adjacent List: " + adjList);
        return connectedComponents;
    }



    private static void bfs(int vertex, List<List<Integer>> adjList, int[] visitedCount) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visitedCount[vertex]=1;

        while(!queue.isEmpty()){
            Integer val = queue.remove();
                for(Integer nbr : adjList.get(val)){
                    if(visitedCount[nbr] ==0){
                        visitedCount[nbr] =1;
                        queue.add(nbr);
                }
            }
        }
    }

    private static void dfs(int i, List<List<Integer>> adjList, int[] visited) {
        visited[i] = 1;
        for (Integer nbr : adjList.get(i)){
            if(visited[nbr] == 0){
                dfs(nbr, adjList, visited);
            }
        }
    }


}
