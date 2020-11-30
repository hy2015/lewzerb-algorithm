package com.lewzerb.leetcode.s0101_0200;

public class Leetcode0171 {
    public int titleToNumber(String s) {
        int n = 0;

        for(char c: s.toCharArray()){
            n = (c - 'A' + 1) + n * 26;
        }

        return n;
    }
}
