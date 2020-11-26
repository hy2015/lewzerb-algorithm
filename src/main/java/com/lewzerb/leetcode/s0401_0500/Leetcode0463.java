package com.lewzerb.leetcode.s0401_0500;

public class Leetcode0463 {
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int  perimeter = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    int up = i == 0 ? 1 : (1-grid[i-1][j]);
                    int right = j == n -1 ? 1 : (1-grid[i][j+1]);
                    int down = i == m - 1 ? 1 : (1-grid[i+1][j]);
                    int left = j == 0 ? 1 : (1-grid[i][j-1]);
                    perimeter += up + right + down + left;
                }
            }
        }
        return perimeter;
    }
}
