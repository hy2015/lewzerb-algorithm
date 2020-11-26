package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0045 {
   /* public int jump(int[] nums) {
        int maxPosition = 0;
        int count = 0;
        int end = 0;

        for(int i=0; i<nums.length-1; i++){
            maxPosition = Math.max(i+nums[i], maxPosition);

            if(i==end){
                end = maxPosition;
                count++;
            }
        }
        return count;
    }*/

    public int jump(int[] nums) {
        if(nums.length < 2){
            return 0;
        }

        int curMax = nums[0];
        int preMax = nums[0];

        int steps = 1;
        for(int i=1; i<nums.length; i++){
            if(i > curMax){
                steps++;
                curMax = preMax;
            }
            int max = nums[i] + i;
            if (preMax < max) {
                preMax = max;
            }
        }
        return steps;
    }
}
