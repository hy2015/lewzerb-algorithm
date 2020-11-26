package com.lewzerb.leetcode.s0401_0500;

public class Leetcode0416 {

    public static void main(String[] args) {
//        int[] nums = {1,2,5};
//        int[] nums = {1,1,1,1};
        int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,99,97};

        long start = System.currentTimeMillis();
        Leetcode0416 leetcode0416 = new Leetcode0416();
        System.out.println(leetcode0416.canPartition(nums));
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
    }

    public boolean canPartition(int[] nums) {
        int sum = 0, maxNum = 0;
        for(int num: nums){
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if((sum & 1) == 1){
            return false;
        }

        int half = sum / 2;
        if(maxNum > half){
            return false;
        }

        boolean[][] dp = new boolean[nums.length][half + 1];

        for(int i=0; i<nums.length; i++){
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for(int i=1; i<nums.length; i++){
            int num = nums[i];
            for(int j=1; j<=half; j++){
                if(j >= num){
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-num];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length - 1][half];
    }

    private boolean dfs(int[] nums, int begin, int sum){

        if(sum == 0){
            return true;
        }
        if(sum < 0){
            return false;
        }

        for(int i = begin; i<nums.length; i++){
            if(dfs(nums, i + 1, sum - nums[i])){
                return true;
            }

        }
        return false;
    }
}
