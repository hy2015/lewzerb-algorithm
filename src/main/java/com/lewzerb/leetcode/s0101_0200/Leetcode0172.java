package com.lewzerb.leetcode.s0101_0200;

public class Leetcode0172 {
    public int trailingZeroes(int n) {
        int zeroCount = 0;

        while (n != 0){
            n = n / 5;
            zeroCount += n;
        }

        return zeroCount;
    }
}
