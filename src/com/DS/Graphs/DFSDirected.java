package com.DS.Graphs;

import javafx.beans.binding.When;

import java.util.List;

public class DFSDirected {

/*  Arrival Time - When we start DFS call
  Departure Time - When DFS stack call started
  */
    private static boolean dfs(int i, List<List<Integer>> adjList, int[] visited, int[] parent) {

        visited[i] = 1; //set visited to 1
        for( Integer neighbor : adjList.get(i)){ //Loop through all neighbors and for each neighbor run the code
            if(visited[neighbor] == 0 ) //If the neighbor is not visited before
            {
                parent[neighbor] = i; //Set startnode to Parent, going down the tree
                if(dfs(neighbor, adjList, visited, parent)) return true; //recursive call
            }
            else if(neighbor != parent[i]){
                return true; // this is back edge
            }
        }
        return false;
    }

/*

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

*/



}
