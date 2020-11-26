package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0053 {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Leetcode0053 leetcode0053 = new Leetcode0053();
        System.out.println(leetcode0053.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = 0;

        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }
        return max;
    }
}
