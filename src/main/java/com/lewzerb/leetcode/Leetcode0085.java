package com.lewzerb.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode0085 {
   /* public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)return 0;
        int maxArea = 0;

        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){

                if(matrix[i][j] == '1'){
                    dp[i][j] = j == 0 ? 1 : dp[i][j-1] + 1;

                    int width = dp[i][j];
                    for(int k=i; k>=0; k--){
                        width = Math.min(width, dp[k][j]);
                        maxArea = Math.max(maxArea, width * (i - k + 1));
                    }
                }

            }
        }
        return maxArea;
    }*/


    public int maximalRectangle(char[][] matrix){
        if(matrix.length == 0)return 0;
        int maxArea = 0;

        int[] dp = new int[matrix[0].length];

        for(int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '1' ?  dp[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(dp));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights){
        int len = heights.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return heights[0];
        }

        int area = 0;
        int[] newHeights = new int[len+2];
        for(int i=0; i<len; i++){
            newHeights[i+1] = heights[i];
        }
        len+=2;
        heights = newHeights;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);

        for(int i=1; i<len; i++){
            while (heights[stack.peekLast()] > heights[i]){
                int height = heights[stack.removeLast()];
                int width = i - stack.peekLast() - 1;
                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }
        return area;
    }
}
