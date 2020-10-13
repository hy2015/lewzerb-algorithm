package com.lewzerb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode0018 {

    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int[] nums = {0, 0, 0, 0};
//        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int[] nums = {-1,0,1,2,-1,-4};
        Leetcode0018 leetcode0018 = new Leetcode0018();
        List<List<Integer>> lists = leetcode0018.fourSum(nums, -1);
        System.out.println(lists.size());
        lists.forEach(System.out::println);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-3; i++){
            if(i>0){
                while( nums[i] == nums[i-1] && i<nums.length-3) i++;
            }
            for(int j=i+1; j<nums.length-2; j++){
                if(j>i+1){
                    while( nums[j] == nums[j-1] && j<nums.length-2) j++;
                }
                int l=j+1, r=nums.length-1;

                while (l != r){
                    // Min
                    int min = nums[i] + nums[j] + nums[l] + nums[l+1];
                    if(target < min){
                        break;
                    }

                    // Max
                    int max = nums[i] + nums[j] + nums[r] + nums[r-1];
                    if(target > max){
                        break;
                    }

                    int sum = nums[i] + nums[j] + nums[l] + nums[r];

                    if(sum > target){
                        r--;
                        while (l != r && nums[r] == nums[r+1]) r--;
                    }else if(sum < target){
                        l++;
                        while (l != r && nums[l] == nums[l-1]) l++;
                    }else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        r--;
                        while (l < r && nums[r] == nums[r+1]) r--;
                        l++;
                        while (l < r && nums[l] == nums[l-1]) l++;
                        if(l >= r)break;
                    }
                }
            }
        }
        return res;
    }
}
