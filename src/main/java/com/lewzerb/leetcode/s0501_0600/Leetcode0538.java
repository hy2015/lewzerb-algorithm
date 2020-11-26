package com.lewzerb.leetcode.s0501_0600;

import com.lewzerb.leetcode.TreeNode;

public class Leetcode0538 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(-4);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        root.left = n1;
        root.right = n4;

        n1.left = n2;
        n1.right = n3;

        Leetcode0538 leetcode0538 = new Leetcode0538();

        leetcode0538.inOrder(root);
        System.out.println("----------");
        TreeNode convertBST = leetcode0538.convertBST(root);
        leetcode0538.inOrder(convertBST);
    }

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);

        return root;
    }



    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.right);
        System.out.print(root.val + " ");
        inOrder(root.left);
    }


}
