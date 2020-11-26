package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0041 {

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        Leetcode0041 leetcode0041 = new Leetcode0041();
        System.out.println(leetcode0041.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int nplus1 = nums.length + 1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] <= 0){
                nums[i] = nplus1;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(Math.abs(nums[i]) < nplus1){
                nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        return nplus1;
    }
}
