package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0058 {
    public int lengthOfLastWord(String s) {
        if(s == null) return 0;

        int count = 0;
        char[] chars = s.trim().toCharArray();
        for(int i=chars.length -1; i>=0; i--){
            if(chars[i] != ' '){
                count++;
            }else {
                break;
            }
        }
        return count;
    }
}
