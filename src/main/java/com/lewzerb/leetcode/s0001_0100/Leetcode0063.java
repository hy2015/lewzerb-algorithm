package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0063 {

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        Leetcode0063 leetcode0063 = new Leetcode0063();
        System.out.println(leetcode0063.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<=m; ++i){
            if(obstacleGrid[i-1][0] == 0){
                dp[i][1] = 1;
            }else {
                break;
            }

        }
        for(int j=1; j<=n; ++j){
            if(obstacleGrid[0][j-1] == 0){
                dp[1][j] = 1;
            }else {
                break;
            }
        }

        for(int i=2; i<=m; ++i){
            for(int j=2; j<=n; ++j){
                if(obstacleGrid[i-1][j-1] == 1){
                    dp[i][j] = 0;
                }else {
                    int up = obstacleGrid[i-2][j-1] == 1 ? 0: dp[i-1][j];
                    int left = obstacleGrid[i-1][j-2] == 1 ? 0: dp[i][j-1];
                    dp[i][j] = up + left;
                }

            }
        }
        return dp[m][n];
    }
}
