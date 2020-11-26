package com.lewzerb.leetcode.s0501_0600;

import com.lewzerb.leetcode.TreeNode;

public class Leetcode0530 {

    TreeNode pre;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);

        if(pre != null){
            min = Math.min(min,root.val - pre.val);
        }
        pre = root;

        inOrder(root.right);
    }
}
