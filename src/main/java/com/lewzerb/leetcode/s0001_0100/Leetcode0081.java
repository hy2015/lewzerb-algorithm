package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0081 {
    public boolean search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target) return true;
            if (nums[left] == nums[mid]){
                left++;
                continue;
            }

            if(nums[left] < nums[mid]){
                if(nums[mid] > target && target >= nums[left]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
