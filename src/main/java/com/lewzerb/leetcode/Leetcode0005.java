package com.lewzerb.leetcode;

public class Leetcode0005 {

    public static void main(String[] args) {
        String[] testStrings = {
            "ac",
            "a",
            "babad",
            "cbbd"
        };
        Leetcode0005 leetcode0005 = new Leetcode0005();
        for(String s: testStrings){
            System.out.println(leetcode0005.longestPalindrome(s));
        }
    }

    /*public String longestPalindrome(String s) {
        int len = s.length();
        char[] sc = s.toCharArray();
        if(len < 2){
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        for(int i=0; i<len; i++) dp[i][i] = true;

        int maxLen = 1;
        int begin = 0;

        for(int j=1; j<len; j++){
            for(int i=0; i<j; i++){
                if (sc[i] != sc[j]){
                    dp[i][j] = false;
                } else {
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }

        }
        return s.substring(begin, begin + maxLen);
    }*/
    public String longestPalindrome(String s) {
        if(s == null) return null;
        char[] sc = new char[s.length() * 2 + 1];
        sc[0] = '#';
        for(int i=0; i<s.length(); i++){
            sc[2*i+1] = s.charAt(i);
            sc[2*i+2] = '#';
        }

        int max = 0;
        int maxi = 0;
        for(int i=1; i<sc.length; i++){
            int count = 0;
            for(int j=1; j<=Math.min(i, sc.length - i - 1); j++){
                if(sc[i-j] == sc[i+j]){
                    count++;
                    if(count > max){
                        max = count;
                        maxi = i;
                    }
                }else {
                    break;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=maxi-max; i<maxi+max; i++){
            if(sc[i] != '#') sb.append(sc[i]);
        }
        return sb.toString();
    }
}
