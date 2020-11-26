package com.lewzerb.leetcode.s0001_0100;

import java.util.Arrays;

public class Leetcode0048 {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        Leetcode0048 leetcode0048 = new Leetcode0048();
        leetcode0048.rotate(matrix);
        for(int[] m: matrix){
            System.out.println(Arrays.toString(m));
        }
    }

    public void rotate(int[][] matrix) {

        int l = matrix.length;

        for(int i=0; i<l / 2; i++){
            for(int j=i; j<l - i - 1; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[l-j-1][i];
                matrix[l-j-1][i] = matrix[l-i-1][l-j-1];
                matrix[l-i-1][l-j-1] = matrix[j][l-i-1];
                matrix[j][l-i-1] = tmp;
            }
        }
    }
}
