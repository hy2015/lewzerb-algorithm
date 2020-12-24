package com.lewzerb.leetcode.s0101_0200;

public class Leetcode0191 {
    public int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeight(int i) {
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }
}
