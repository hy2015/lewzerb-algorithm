package com.lewzerb.leetcode.s0101_0200;

public class Leetcode0190 {

    public static void main(String[] args) {
        int[] tests = {
            43261596,
            -3
        };
        Leetcode0190 leetcode0190 = new Leetcode0190();

        for (int test : tests) {
            System.out.println(leetcode0190.reverseBits(test));
        }
    }

    public int reverseBits2(int n) {
        int res = 0;
        int cnt = 0;
        while (cnt<32){
            res = (res << 1) | (n & 1);
            n >>>=  1;
            cnt++;
        }
        return res;
    }

    public int reverseBits(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
}
