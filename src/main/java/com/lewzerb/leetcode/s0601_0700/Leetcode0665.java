package com.lewzerb.leetcode.s0601_0700;

public class Leetcode0665 {
    public boolean checkPossibility(int[] nums) {
        if(nums.length <= 1) return true;

        int countDesc = 0;
        int pre = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i] < pre) {
                countDesc++;
            }else {
                pre = nums[i];
            }

            if(countDesc > 1) return false;
        }

        return true;
    }
}
