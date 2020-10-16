package com.lewzerb.leetcode;

public class Leetcode0035 {

    public int searchInsert(int[] nums, int target) {

        int l = 0, r = nums.length -1;
        while (l<=r){
            int m = (l + r) / 2;
            if(nums[m] < target){
                l = m + 1;
            }else if(nums[m] > target){
                r = m - 1;
            }else {
                return m;
            }
        }
        return l;
    }

}
