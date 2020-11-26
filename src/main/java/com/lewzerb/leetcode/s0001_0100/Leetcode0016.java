package com.lewzerb.leetcode.s0001_0100;

import java.util.Arrays;

public class Leetcode0016 {


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];


        for(int i=0; i<nums.length-2; i++){
            int l=i+1, r=nums.length-1;

            while (l != r){
                // Min
                int min = nums[i] + nums[l] + nums[l+1];
                if(target < min){
                    if(Math.abs(closest - target) > Math.abs(min - target))
                        closest = min;
                    break;
                }

                // Max
                int max = nums[i] + nums[r] + nums[r-1];
                if(target > max){
                    if(Math.abs(closest - target) > Math.abs(max - target))
                        closest = max;
                    break;
                }

                int sum = nums[i] + nums[l] + nums[r];

                if(Math.abs(closest - target) > Math.abs(sum - target)){
                    closest = sum;
                }

                if(sum > target){
                    r--;
                    while (l != r && nums[r] == nums[r+1]) r--;
                }else if(sum < target){
                    l++;
                    while (l != r && nums[l] == nums[l-1]) l++;
                } else {
                    return target;
                }
            }
        }
        return closest;
    }
}
