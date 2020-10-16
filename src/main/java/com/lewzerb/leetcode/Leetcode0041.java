package com.lewzerb.leetcode;

public class Leetcode0041 {
    public int firstMissingPositive(int[] nums) {
        int count = 0;
        int left = Integer.MAX_VALUE, right = 0;
        for(int i=0; i<nums[i]; i++){
            if(nums[i] > 0){
                left = Math.min(left, nums[i]);
                right = Math.max(right, nums[i]);
                count++;
            }
        }
        if(left > 1) {
            return 1;
        }else {
            if(right == count) {
                return right + 1;
            }else {
                return 1;
            }

        }
    }
}
