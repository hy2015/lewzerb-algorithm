package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0072 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if (n == 0) {
            return m;
        }
        if(m == 0){
            return n;
        }

        int[][] op = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            op[i][0] = i;
        }
        for (int j = 0; j<=n; j++){
            op[0][j] = j;
        }

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(chars1[i-1] == chars2[j-1]){
                    op[i][j] = op[i-1][j-1];
                }else {
                    op[i][j] = 1 + Math.min(op[i-1][j-1],Math.min(op[i-1][j], op[i][j-1]));
                }
            }
        }
        return op[m][n];
    }
}
