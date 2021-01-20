package com.lewzerb.leetcode.s0601_0700;

import java.util.Arrays;

public class Leetcode0628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[len-1] * nums[0] * nums[1], nums[len-1] * nums[len-2] * nums[len-3]);
    }
}
