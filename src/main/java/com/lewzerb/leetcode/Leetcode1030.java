package com.lewzerb.leetcode;

import java.util.Arrays;

public class Leetcode1030 {

    public static void main(String[] args) {
        int[][] tests = {
            {2, 3, 1, 2}
        };

        Leetcode1030 leetcode1030 = new Leetcode1030();
        for(int[] test: tests){
            int[][] cells = leetcode1030.allCellsDistOrder(test[0], test[1], test[2], test[3]);
            for (int[] cell : cells) {
                System.out.println(Arrays.toString(cell));
            }
        }
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R*C][2];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                res[i*C+j] = new int[]{i, j};
            }
        }
        Arrays.sort(res, (m1, m2) -> Math.abs(m1[0] - r0) + Math.abs(m1[1] - c0) -
                        Math.abs(m2[0] - r0) - Math.abs(m2[1] - c0));
        return res;
    }
}
