package com.lewzerb.leetcode.s0101_0200;

import java.util.Arrays;

public class Leetcode0164 {
    public int maximumGap(int[] nums) {
        if(nums.length <= 1) return 0;
        Arrays.sort(nums);

        int pre = nums[0];
        int maxGap = 0;
        for(int i=1;i<nums.length; i++){
            maxGap = Math.max(maxGap, nums[i]-pre);
            pre = nums[i];
        }
        return maxGap;
    }
}
