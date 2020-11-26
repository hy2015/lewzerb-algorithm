package com.lewzerb.leetcode.s0001_0100;

import java.util.ArrayList;
import java.util.List;

public class Leetcode0046 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Leetcode0046 leetcode0046 = new Leetcode0046();
        List<List<Integer>> permute = leetcode0046.permute(nums);
        permute.forEach(System.out::println);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrace(res, path, 0, nums);
        return res;
    }

    private void backtrace(List<List<Integer>> res, List<Integer> path, int start, int[] nums){
        if(start == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=start; i<nums.length; i++){
            path.add(nums[i]);
            swap(nums, start, i);
            backtrace(res, path, start + 1, nums);
            path.remove(path.size() - 1);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j){
        if(i == j) return;

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
