package com.lewzerb.leetcode.s0101_0200;

public class Leetcode0136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num: nums){
            res ^= num;
        }
        return res;
    }
}
