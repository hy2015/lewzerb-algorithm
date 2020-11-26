package com.lewzerb.leetcode.s0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode0090 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Leetcode0090 leetcode0090 = new Leetcode0090();
        List<List<Integer>> subsets = leetcode0090.subsetsWithDup(nums);
        subsets.forEach(System.out::println);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);

        dfs(res, path, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int begin){
        res.add(new ArrayList<>(path));

        for(int i=begin; i<nums.length; i++){
            if(i>begin && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            dfs(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
