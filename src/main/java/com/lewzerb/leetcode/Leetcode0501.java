package com.lewzerb.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode0501 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        count(root);
        int maxCount = -1;
        Set<Integer> maxs = new HashSet<>();
        for(Integer key: map.keySet()){
            if(map.get(key) > maxCount){
                maxCount = map.get(key);
                maxs = new HashSet<>();
                maxs.add(key);
            }
            if(map.get(key) == maxCount){
                maxs.add(key);
            }
        }
        int[] res = new int[maxs.size()];
        int i = 0;
        for (Integer m : maxs.toArray(new Integer[]{})) {
            res[i] = m;
            i++;
        }
        return res;
    }

    private void count(TreeNode root){
        if(root == null) return;
        incr(root.val);
        count(root.left);
        count(root.right);
    }

    private void incr(int val){
        map.putIfAbsent(val, 1);
        map.put(val, map.get(val) + 1);
    }
}
