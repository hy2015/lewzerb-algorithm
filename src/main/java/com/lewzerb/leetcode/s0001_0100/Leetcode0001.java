package com.lewzerb.leetcode.s0001_0100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode0001 {

    public static void main(String[] args) {
        int[] test = {3, 2, 4};
        int target = 6;
        Leetcode0001 leetcode0001 = new Leetcode0001();
        int[] twoSum = leetcode0001.twoSum(test, target);
        System.out.println(Arrays.toString(twoSum));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(numsMap.containsKey(complement)){
                return new int[]{numsMap.get(complement), i};
            }
            numsMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution!");
    }
}
