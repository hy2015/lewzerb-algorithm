package com.lewzerb.leetcode.s0101_0200;

public class Leetcode0137 {

    public static void main(String[] args) {
        int[] nums = {2,1,2,1,2,1,4};
        Leetcode0137 leetcode0137 = new Leetcode0137();
        System.out.println(leetcode0137.singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num: nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }

        return ones;
    }
}
