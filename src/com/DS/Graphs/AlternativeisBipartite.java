package com.DS.Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

        public class AlternativeisBipartite {

            // A bipartite is a graph where it has two subsets/groups of nodes and edges are between the nodes of different subsets
            // If the an edge is between the node that belong to the  same group then its not a bipartite graph.
            // odd cycles of graph are bad.
            // We mark the nodes in the same subset as same color - see the color array
            public boolean isBipartite(int[][] graph) {

                // Build the adjacency map
                Map<Integer, Set<Integer>> map = getAdjacencyMap(graph);

                int[] visited = new int[graph.length];
                int[] color = new int[graph.length];
                int[] parent = new int[graph.length];

                Arrays.fill(visited, -1);
                Arrays.fill(parent, -1);
                Arrays.fill(color, -1);

                // Loop through the nodes and traverse
                for (int i = 0; i < graph.length; i++) {
                    if (visited[i] == -1) {
                        color[i] = 0;
                        boolean isBipartite = dfs(i, map, visited, color, parent);
                        if (!isBipartite)
                            return false;
                    }
                }
                return true;

            }

            public boolean dfs(int src, Map<Integer, Set<Integer>> map, int[] visited, int[] color, int[] parent) {
                visited[src] = 1;
                Set<Integer> neighbors = map.get(src);
                for (Integer neighbor : neighbors) {
                    if (visited[neighbor] == -1) {
                        parent[neighbor] = src;
                        color[neighbor] = 1 - color[src];
                        dfs(neighbor, map, visited, color, parent);
                    } else {
                        if (parent[src] != neighbor)
                            if (color[neighbor] == color[src])
                                return false;
                    }


                }
                return true;
            }

            public Map<Integer, Set<Integer>> getAdjacencyMap(int[][] edges) {
                Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
                int nodes = edges.length;

                for (int i = 0; i < nodes; i++) {
                    map.put(i, new HashSet<Integer>());

                }
                for (int i = 0; i < edges.length; i++) {
                    Set<Integer> edgesList = map.get(i);
                    for (int j = 0; j < edges[i].length; j++) {
                        edgesList.add(edges[i][j]);
                    }
                    map.put(i, edgesList);
                }
                return map;
                // This is for printing the list
		/*for(int i=0; i<edges.length; i++) {
			Set<Integer> edgesList = map.get(i);
			System.out.print(i + "->");
			for(int j=0; j<edges[i].length; j++) {
				System.out.print(edges[i][j] + " ");
			}
			System.out.println();
		}*/
            }

            public static void main(String[] args) {
                // TODO Auto-generated method stub
                AlternativeisBipartite gb = new AlternativeisBipartite();
                //System.out.println(gb.isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}));

                //System.out.println(gb.isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));

                //System.out.println(gb.isBipartite(new int[][]{{1},{0,3},{3},{1,2}}));

                System.out.println(gb.isBipartite(new int[][]{{2, 3, 5, 6, 7, 8, 9}, {2, 3, 4, 5, 6, 7, 8, 9}, {0, 1, 3, 4, 5, 6, 7, 8, 9}, {0, 1, 2, 4, 5, 6, 7, 8, 9}, {1, 2, 3, 6, 9}, {0, 1, 2, 3, 7, 8, 9}, {0, 1, 2, 3, 4, 7, 8, 9},
                        {0, 1, 2, 3, 5, 6, 8, 9}, {0, 1, 2, 3, 5, 6, 7}, {0, 1, 2, 3, 4, 5, 6, 7}}));


            }

        }