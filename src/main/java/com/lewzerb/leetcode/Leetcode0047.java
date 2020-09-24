package com.lewzerb.leetcode;

import java.util.*;

public class Leetcode0047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        dfs(path, res, nums,  used,0);
        return res;
    }

    public void dfs(Deque<Integer> path, List<List<Integer>> res, int[] nums, boolean[] used, int count){


        if(count == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i-1] == nums[i] && !used[i-1]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(path, res, nums, used,count + 1);
            used[i] = false;
            path.removeLast();
        }
    }
}
