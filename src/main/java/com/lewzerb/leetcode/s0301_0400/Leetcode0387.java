package com.lewzerb.leetcode.s0301_0400;

public class Leetcode0387 {
    public int firstUniqChar(String s) {
        char[] cs = s.toCharArray();
        int[] cnt = new  int[26];

        for(char c: cs){
            cnt[c - 'a']++;
        }

        for(int i=0; i<cs.length; i++){
            if(cnt[cs[i] - 'a'] == 1) return i;
        }
        return -1;
    }
}
