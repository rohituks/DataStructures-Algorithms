package com.DS.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsGraphValidTree {


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
        System.out.println(isValidTree(5, edgesLists));
    }

    static boolean isValidTree(int n, List<List<Integer>> edgesList){
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
        int[] parent = new int[n];
        for (int i=0; i< n; i++){
            if(visited[i] == 0){
                connectedComponents++;
                if(connectedComponents >1){
                    return false; //To check if the graph is connected
                }
                //BFS Cross edge
//                if(!bfs(i, adjList, visited, parent)){// To check if the graph has cycle
//                    System.out.println("disconnected graph");
//                    return false;
//                }
                //DFS Back edge
                if(!dfs(i, adjList, visited, parent)){// To check if the graph has cycle
                    System.out.println("disconnected graph");
                    return false;
                }
            }
        }
        System.out.println("Adjacent List: " + adjList);
        return true;
    }



    private static boolean bfs(int vertex, List<List<Integer>> adjList, int[] visitedCount, int[] parent) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visitedCount[vertex]=1;

        while(!queue.isEmpty()){
            Integer val = queue.remove();
            for(Integer nbr : adjList.get(val)){
                if(visitedCount[nbr] ==0){ // Tree edge is created conceptually
                    visitedCount[nbr] =1; //node is visiting neighbor
                    parent[nbr] = val; // Parent array is set as node.
                    queue.add(nbr);
                }
                else if(nbr != parent[val]){ //else neighbour has been visited
                    return true;// true : cross edge doesnt exist between child and parent
                }
            }
        }
    return false;// false: Cycle exists
    }

    private static boolean dfs(int i, List<List<Integer>> adjList, int[] visited, int[] parent) {
        visited[i] = 1;
        for (Integer nbr : adjList.get(i)){
            if(visited[nbr] == 0){
                parent[nbr] = i;
                if(dfs(nbr, adjList, visited, parent)) return true;
            }
            else if(nbr != parent[i]){
                return true; // Back edge
            }

        }
        return false;//cycle not found
    }


}
