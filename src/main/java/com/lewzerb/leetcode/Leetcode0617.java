package com.lewzerb.leetcode;

public class Leetcode0617 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t1_1 = new TreeNode(3);
        TreeNode t1_2 = new TreeNode(2);
        TreeNode t1_3 = new TreeNode(5);

        t1.left = t1_1;
        t1.right = t1_2;
        t1_1.left = t1_3;

        TreeNode t2 = new TreeNode(2);
        TreeNode t2_1 = new TreeNode(1);
        TreeNode t2_2 = new TreeNode(3);
        TreeNode t2_3 = new TreeNode(4);
        TreeNode t2_4 = new TreeNode(7);

        t2.left = t2_1;
        t2.right = t2_2;
        t2_1.right = t2_3;
        t2_2.right = t2_4;

        Leetcode0617 leetcode0617 = new Leetcode0617();
        TreeNode merged = leetcode0617.mergeTrees(t1, t2);
        leetcode0617.preOrder(merged);
    }


    public void preOrder(TreeNode root){
        if(root==null)return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);

        return merged;
    }

}
