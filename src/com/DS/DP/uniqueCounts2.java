package com.DS.DP;

public class uniqueCounts2 {

    //Leetcode https://leetcode.com/problems/unique-paths-ii/solution/
    /*
    f(i,j) = f(i-1,j) + f(i, j-1);
    DAG - no cycles in the grid
    Unique subproblems -> m*n. Need to solve in Topological sort way.
    Boundary problems are Base case

     */

    public static void main(String[] args){
        int[][] grid = {{0,0,0}, {0,1,0}, {0,0,0}};
        uniqueCounts2 uniqueCounts = new uniqueCounts2();
        System.out.println(uniqueCounts.countPaths(grid));
//        System.out.println(uniqueCounts(5,5));
    }

    public  int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;


        int[][] table = new int[m][n]; //This cache which we are using to store grid(final solution), For each vertices in the graph.


        //First cell in the Grid as Base condition, If there is obstacle in the first cell itself, so we cannot start
        if (grid[0][0] == 1) {
            return 0;
        } else
            table[0][0] = 1;

        // Top row
        for (int col = 1; col <= n - 1; col++) {
            if (grid[0][col] == 1) {// If there is obstacle in the row, then other column values are unreachable therefore breakout
                break;
            }
            table[0][col] = 1;
        }
        //Top Column
        for (int row = 1; row <= m - 1; row++) {
            if (grid[row][0] == 1) { // If there is obstacle in the column, then other column values are unreachable therefor breakout
                break;
            }
            table[row][0] = 1;
        }

        //Recursive
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) { //If there is obstacle in my cell
                    table[i][j] = 0;
                } else {
                    table[i][j] = table[i - 1][j] + table[i][j - 1]; //Addition of my left ce
                }
            }
        }
        return table[m - 1][n - 1];//Last move
        // }


    /*Time Complexity   O(mn), Space Complexity O(mn) -> Optimized SC O(2n) = O(n)

        C(m+n-2, m-1),  C(m+n-2,n-1) = C(m+n-2,m-1)
        For m=5, n=5, number of unique paths would be -
            C(8,4) = C(8,4) =(8x7x6x5)/(4x3x2x1) = 70
     */
    }
}
