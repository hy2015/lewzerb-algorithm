package com.lewzerb.leetcode.s0101_0200;

import com.lewzerb.leetcode.TreeNode;

public class Leetcode0104 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
