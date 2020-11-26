package com.lewzerb.leetcode.s1301_1400;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Leetcode1365 {
    /*public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counts = new int[nums.length];

        int[] copyNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        for(int i=0; i<copyNums.length; i++){
            counts[i] = binSearchIndex(nums, copyNums[i]);
        }

        return counts;
    }

    private int binSearchIndex(int[] nums, int target){
        int l = 0, r = nums.length -1;
        while (l <= r){
            int m = (l + r) / 2;
            if(nums[m] >= target){
                r = m - 1;
            }else {
                l = m + 1;
            }
        }
        return l;
    }*/
    public int[] smallerNumbersThanCurrent(int[] nums){
        int[] counts = new int[101];
        int[] res = new int[nums.length];
        for (int num : nums) {
            counts[num]++;
        }
        int pre = 0;
        for(int i=0; i<= 100; i++){
            if(counts[i] == 0) continue;
            int tmp = counts[i];
            counts[i] = pre;
            pre += tmp;
        }

        for(int i=0; i<nums.length; i++){
            res[i] = counts[nums[i]];
        }
        return res;
    }
}
