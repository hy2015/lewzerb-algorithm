package com.lewzerb.leetcode.s0101_0200;

import com.lewzerb.leetcode.TreeNode;

public class Leetcode0124 {

    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSub(root);
        return maxPathSum;
    }

    private int maxSub(TreeNode root){
        if(root == null) return 0;
        int leftMax = Math.max(maxSub(root.left), 0);
        int rightMax = Math.max(maxSub(root.right), 0);

        int curMax = root.val + leftMax + rightMax;
        maxPathSum = Math.max(curMax, maxPathSum);
        return root.val + Math.max(leftMax, rightMax);
    }
}
