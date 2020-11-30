package com.lewzerb.leetcode.s0101_0200;

import java.util.Arrays;

public class Leetcode0169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
