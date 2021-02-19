package com.lewzerb.leetcode.s0701_0800;

public class Leetcode0724 {

    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] before = new int[len];
        int[] after = new int[len];

        for(int i=1; i<len; i++){
            before[i] = before[i-1] + nums[i-1];
        }

        for(int j=len-2; j>=0; j--){
            after[j] = after[j+1] + nums[j+1];
        }

        for(int k=0; k<len; k++){
            if(before[k] == after[k]) return k;
        }
        return -1;
    }
}
