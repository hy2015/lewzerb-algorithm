package com.lewzerb.leetcode.s0001_0100;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Leetcode0073 {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> zeroList = new ArrayList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    zeroList.add(new int[]{i, j});
                }
            }
        }

        if(zeroList.size() == 0) return;

        for(int[] axis : zeroList){
            int i = axis[0], j = axis[1];
            for(int k=0; k<m; k++){
                matrix[k][j] = 0;
            }
            for(int k=0; k<n; k++){
                matrix[i][k] = 0;
            }
        }
    }
}
