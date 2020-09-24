package com.lewzerb.leetcode;

import java.sql.Struct;

public class Leetcode0404 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root.left, true) + dfs(root.right, false);
    }

    public int dfs(TreeNode treeNode, boolean isLeft){
        if(treeNode == null){
            return 0;
        }
        if(isLeft){
            if(treeNode.left == null && treeNode.right == null){
                return treeNode.val;
            }

        } else {
            if(treeNode.left == null && treeNode.right == null){
                return 0;
            }

        }
        return dfs(treeNode.left, true) + dfs(treeNode.right, false);
    }
}
