package com.lewzerb.leetcode.s0201_0300;

import com.lewzerb.leetcode.TreeNode;

public class Leetcode0222 {

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
