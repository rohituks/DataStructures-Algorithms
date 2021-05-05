package com.DS.Graphs;

import java.util.*;

public class isGraphBipartite {
//Leetcode 785


    public static void main(String[] args){
        List<Integer> edges1 = new LinkedList<>();
        edges1.addAll(Arrays.asList(1,3));
        List<Integer> edges2 = new LinkedList<>();
        edges2.addAll(Arrays.asList(0,2));

        List<Integer> edges3 = new LinkedList<>();
        edges3.addAll(Arrays.asList(1,3));

        List<Integer> edges4 = new LinkedList<>();
        edges4.addAll(Arrays.asList(0,2));


        //root = [1,2,3,4,5,6,7]
        List<List<Integer>> edgesLists = new LinkedList<>();
        edgesLists.addAll(Arrays.asList(edges1,edges2,edges3,edges4));
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
        int[] distance = new int[n];
        for (int i=0; i< n; i++){
            if(visited[i] == 0){
                //BFS Cross edge
/*                if(!bfs(i, adjList, visited, distance)){// To check if the graph has cycle
                    System.out.println("Is it Bipartite graph?");
                    return false;
                }*/
                //DFS Back edge
                if(!dfs(i, adjList, visited, parent, distance)){// To check if the graph has cycle
                    System.out.println("Is it Bipartite graph?");
                    return false;
                }
            }
        }
        System.out.println("Adjacent List: " + adjList);
        return true;
    }



    private static boolean bfs(int vertex, List<List<Integer>> adjList, int[] visitedCount, int[] color) {
        visitedCount[vertex]=1;
        color[vertex] =0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);

        while(!queue.isEmpty()){
            Integer val = queue.poll();
            for(Integer neighbor : adjList.get(val)){
                color[neighbor] = 1 + color[val];
                if(visitedCount[neighbor] ==0){ // Tree edge is created conceptually
                    visitedCount[neighbor] =1; //node is visiting neighbor
                    queue.add(neighbor);
                }
                else if(color[neighbor] == color[val]) {
                    return false; // cross edges is on the same level
                }
                }
            }
        return true; // false: yes its bipartite
    }

    private static boolean dfs(int i, List<List<Integer>> adjList, int[] visited, int[] parent, int[] color) {
        visited[i] = 1;
        for (Integer nbr : adjList.get(i)){
            if(visited[nbr] == 0){
                color[nbr] = 1 - color[i];
                parent[nbr] = i;
                if(dfs(nbr, adjList, visited, parent, color)) return true;
            }
            else if (nbr != parent[i]){
                if (color[nbr] == color[i]) return true;// Back edge
            }

        }
        return false;//cycle not found
    }


}


