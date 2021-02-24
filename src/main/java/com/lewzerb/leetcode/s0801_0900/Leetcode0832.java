package com.lewzerb.leetcode.s0801_0900;

public class Leetcode0832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] B = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                B[i][m-j-1] = 1 - A[i][j];
            }
        }

        return B;
    }
}
