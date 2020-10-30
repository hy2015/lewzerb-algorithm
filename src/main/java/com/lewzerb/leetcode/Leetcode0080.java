package com.lewzerb.leetcode;

public class Leetcode0080 {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        int pre = Integer.MAX_VALUE;
        int preCount = 0;

        for(int num: nums){

            if(num != pre){
                nums[idx++] = num;
                pre = num;
                preCount = 1;
            }else{
                if(preCount <= 1){
                    nums[idx++] = num;
                    preCount++;
                }
            }
        }
        return idx;
    }
}
