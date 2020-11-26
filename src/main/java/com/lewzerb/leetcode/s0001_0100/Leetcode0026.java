package com.lewzerb.leetcode.s0001_0100;

import java.util.Arrays;

public class Leetcode0026 {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int idx = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] != nums[i]){
                idx++;
                nums[idx] = nums[i];
            }
        }
        return idx + 1;
    }
}
