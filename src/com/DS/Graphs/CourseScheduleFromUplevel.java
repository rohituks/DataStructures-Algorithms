package com.DS.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseScheduleFromUplevel {


    /* DIRECTED GRAPH: FIND A CYCLE: If there is a backedge on DFS that means a cycle.
         How to find backedge in dfs : if visited neignhor has a departure time not set means the node is in same on going DFS
         and is not completed.
         Can use Kahn algo BFS indegree approach too.

    if there is a cycle in the graph means cant complete course. ordering can get from topsort
    create graph(adjacency list course a[i] must be taken before course b[i]. in adj list of a[i] add b[i]
    outerloop
    dfs: set teh arrival and departure time of each node and iterate through unvisited neighbor
    if neighbor is visited that means it can be a cycle and now see if the departure tie is not set for that node that means
    its a back edge to that neighbor.

    Since it's directed we need to check for backedge
    undirected only check if unvisted node is not a direct parent.
    */
    static ArrayList<Integer>[] adjList;
    static int[] visited;
    static int[] arrival;
    static int[] departure;
    static int timestamp = 0;

    public static boolean can_be_completed(int n, List<Integer> a, List<Integer> b) {
        visited = new int[n];
        arrival = new int[n];
        departure = new int[n];
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        Arrays.fill(visited, -1);
        Arrays.fill(arrival, -1);
        Arrays.fill(departure, -1);
        for (int i = 0; i < a.size(); i++) {
            adjList[a.get(i)].add(b.get(i));
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                if (dfs(i)) return false;// cycle found
            }
        }
        return true;
    }

    public static boolean dfs(int s) {// returns true if cycle found
        arrival[s] = timestamp++;
        visited[s] = 1;
        for (int neighbor : adjList[s]) {
            if (visited[neighbor] == -1) {
                if (dfs(neighbor)) {
                    return true;
                }
            } else {
                if (departure[neighbor] == -1) {
                    return true; // cycle found
                }
            }
        }
        departure[s] = timestamp++;
        return false;
    }
}