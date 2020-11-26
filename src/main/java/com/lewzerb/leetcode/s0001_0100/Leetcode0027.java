package com.lewzerb.leetcode.s0001_0100;

import java.util.Arrays;

public class Leetcode0027 {

    public static void main(String[] args) {
        int[] nums = {2};
        int val = 3;
        Leetcode0027 leetcode0027 = new Leetcode0027();
        int idx = leetcode0027.removeElement(nums, val);
        System.out.println(idx);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, idx)));
    }

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length -1;
        int count = 0;

        while (left <= right){
            if(nums[left] != val){
                left++;
                continue;
            }
            if(nums[right] == val){
                right--;
                continue;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            count++;
        }

        return nums.length - count - 1;
    }
}
