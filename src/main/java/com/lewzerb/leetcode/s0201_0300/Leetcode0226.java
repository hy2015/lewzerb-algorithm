package com.lewzerb.leetcode.s0201_0300;

import com.lewzerb.leetcode.TreeNode;

public class Leetcode0226 {

    public TreeNode invertTree(TreeNode root) {
        if(root==null)return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
