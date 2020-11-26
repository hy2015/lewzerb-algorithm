package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0038 {

    public static void main(String[] args) {
        Leetcode0038 leetcode0038 = new Leetcode0038();
        String say = leetcode0038.countAndSay(30);
        System.out.println(say);
    }

    public String countAndSay(int n) {

        String[] dp = new String[n + 1];
        dp[1] = "1";

        for(int i=2; i<=n; i++){
            char preC = '0';
            int count = 0;

            StringBuilder builder = new StringBuilder();
            for(char c: dp[i-1].toCharArray()){
                if(c != preC){
                    if(count > 0){
                        builder.append(count).append(preC);
                    }
                    count = 0;
                    preC = c;
                }
                count++;
            }
            if(count > 0){
                builder.append(count).append(preC);
            }
            dp[i] = builder.toString();
        }

        return dp[n];
    }
}
