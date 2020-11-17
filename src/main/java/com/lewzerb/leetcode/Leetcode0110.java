package com.lewzerb.leetcode;

public class Leetcode0110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(maxHeight(root.left) - maxHeight(root.right)) > 1){
            return false;
        }else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int maxHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }
}
