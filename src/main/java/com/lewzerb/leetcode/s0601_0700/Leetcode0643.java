package com.lewzerb.leetcode.s0601_0700;

public class Leetcode0643 {
    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;

        for(int i=0; i<k; i++){
            sum += nums[i];
        }

        int maxSum = sum;

        for(int i=k; i<nums.length; i++){
            sum = sum + nums[i] - nums[i-k];
            maxSum = Math.max(maxSum, sum);
        }

        return 1.0 * maxSum / k;
    }
}
