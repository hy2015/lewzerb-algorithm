package com.lewzerb.leetcode.s0701_0800;

import com.lewzerb.leetcode.TreeNode;

public class Leetcode0701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        insert(root, val);
        return root;
    }

    private void insert(TreeNode root, int val){
        if(val > root.val){
            if(root.right == null){
                root.right = new TreeNode(val);
            }else {
                insert(root.right, val);
            }
        }
        if(val < root.val){
            if(root.left == null){
                root.left = new TreeNode(val);
            }else {
                insert(root.left,  val);
            }
        }
    }
}
