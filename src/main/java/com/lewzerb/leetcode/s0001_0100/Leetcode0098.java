package com.lewzerb.leetcode.s0001_0100;

import com.lewzerb.leetcode.TreeNode;

public class Leetcode0098 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(15);
        TreeNode n3 = new TreeNode(11);
        TreeNode n4 = new TreeNode(20);

        root.right = n1;

        Leetcode0098 leetcode0098 = new Leetcode0098();
        System.out.println(leetcode0098.isValidBST(root));
    }

    Integer pre = null;

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean left = isValidBST(root.left);
        if(!left) return false;
        if(pre != null && root.val <= pre){
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }


}
