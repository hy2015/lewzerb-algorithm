package com.lewzerb.leetcode.s0101_0200;

import com.lewzerb.leetcode.TreeNode;

public class Leetcode0112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return sum == root.val;
        }else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
