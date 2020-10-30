package com.lewzerb.leetcode;

public class Leetcode0075 {
    /*public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }

        int idx = 0;

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < count[j]; i++) {
                nums[idx++] = j;
            }
        }
    }*/

    public void sortColors(int[] nums){
        int left = 0, right = nums.length - 1;
        for(int i=0; i<=right; i++){
            while (i <= right && nums[i] == 2){
                int tmp = nums[right];
                nums[right] = nums[i];
                nums[i] = tmp;
                right--;
            }
            if(nums[i] == 0){
                int tmp = nums[left];
                nums[left] = nums[i];
                nums[i] = tmp;
                left++;
            }
        }
    }
}
