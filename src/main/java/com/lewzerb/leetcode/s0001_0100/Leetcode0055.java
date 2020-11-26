package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0055 {

    public static void main(String[] args) {
        int[] nums = {3,2,2,0,4};
        Leetcode0055 leetcode0055 = new Leetcode0055();
        System.out.println(leetcode0055.canJump(nums));
    }

   /* public boolean canJump(int[] nums) {
        int maxJump = 0;

        for(int i=0; i<nums.length; i++){
            if(i <= maxJump){
                maxJump = Math.max(maxJump, i+nums[i]);
                if(maxJump >= nums.length -1){
                    return true;
                }
            }

        }
        return false;
    }*/

    public boolean canJump(int[] nums) {
        int k = 0;
        for(int i = 0; i<nums.length; i++){
            if(i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}
