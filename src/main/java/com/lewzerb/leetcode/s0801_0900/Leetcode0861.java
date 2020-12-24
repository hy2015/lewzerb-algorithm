package com.lewzerb.leetcode.s0801_0900;

public class Leetcode0861 {

    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int res = m * (1 << (n - 1));

        for (int j = 1; j < n; j++) {
            int k = 0;
            for (int[] c : A) {
                k += c[0] == 1 ? c[j] : 1 - c[j];
            }
            k = Math.max(k, m - k);

            res += k * (1 << n - j - 1);
        }
        return res;
    }
}
