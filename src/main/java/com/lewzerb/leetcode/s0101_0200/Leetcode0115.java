package com.lewzerb.leetcode.s0101_0200;

public class Leetcode0115 {


    public static void main(String[] args) {
        String[][] tests = {
            {"rabbbit", "rabbit"},
            {"babgbag", "bag"}
        };
        Leetcode0115 leetcode0115 = new Leetcode0115();
        for(String[] test: tests){
            System.out.println(leetcode0115.numDistinct(test[0], test[1]));
        }
    }

    /* 递归需要记录中间结果，防止超时
    nt count = 0;

    public int numDistinct(String s, String t) {
        dfs(s.toCharArray(), t.toCharArray(), 0, 0);
        return count;
    }

    private void dfs(char[] sc, char[] tc, int begin, int index){
        if(sc.length - begin < tc.length - index) return;
        for(int i=begin; i<sc.length; i++){
            if(sc[i] == tc[index]){
                if(index == tc.length - 1){
                    count++;
                    continue;
                }
                dfs(sc, tc, i+1, index+1);
            }
        }
    }
    */

    public int numDistinct(String s, String t){
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[][] dp = new int[sc.length+1][tc.length+1];
        for(int i=0; i<=sc.length; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<=sc.length; i++){
            for(int j=1; j<=tc.length; j++){
                if(sc[i-1] == tc[j-1]){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[sc.length][tc.length];
    }
}
