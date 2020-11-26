package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0091 {

    public static void main(String[] args) {
        Object[][] tests = {
            {"12", 2},
            {"226", 3},
            {"0", 0},
            {"1123", 5},
            {"2101", 1},
            {"101", 1},
            {"10", 1},
            {"1", 1}
        };
        Leetcode0091 leetcode0091 = new Leetcode0091();
        for(Object[] test : tests){
            String s = (String) test[0];
            int i = (int) test[1];
            System.out.println((leetcode0091.numDecodings(s) == i) + "\t" + leetcode0091.numDecodings(s));
        }
    }

    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        if(s.length() == 1) return 1;

        for(int i=2; i<=s.length(); i++){
            int pre = s.charAt(i - 2) - '0';
            int cur = s.charAt(i - 1) - '0';
            if((cur+pre == 0) ||
                (cur == 0 && pre > 2)){
                return 0;
            }else if(pre == 0 || cur == 0){
                dp[i] = cur== 0?dp[i-2]:dp[i-1];
            }else {
                int con = pre * 10 + cur;
                dp[i] = con>26?dp[i-1]:dp[i-1]+dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
