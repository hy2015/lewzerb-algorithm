package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0064 {

    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 5},
            {3, 2, 1}
        };
        Leetcode0064 leetcode0064 = new Leetcode0064();
        System.out.println(leetcode0064.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for(int i=1; i< m; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int j=1; j< n; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for(int i=1; i< m; i++){
            for(int j=1; j< n; j++){
                dp[i][j] = grid[i][j]+ Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}
