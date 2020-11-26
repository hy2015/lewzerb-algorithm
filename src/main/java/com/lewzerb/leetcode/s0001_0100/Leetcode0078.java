package com.lewzerb.leetcode.s0001_0100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode0078 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Leetcode0078 leetcode0078 = new Leetcode0078();
        List<List<Integer>> subsets = leetcode0078.subsets(nums);
        subsets.forEach(System.out::println);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path  = new ArrayDeque<>();
        dfs(res, path, nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, Deque<Integer> path, int[] nums, int depth){
        if(depth == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        dfs(res, path, nums, depth + 1);
        path.addLast(nums[depth]);
        dfs(res, path, nums, depth + 1);
        path.removeLast();

    }
}
