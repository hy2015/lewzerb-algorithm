package com.lewzerb.leetcode.s0001_0100;

import com.lewzerb.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Leetcode0099 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);

        root.left = n1;
        n1.right = n2;

        Leetcode0099 leetcode0099 = new Leetcode0099();
        leetcode0099.recoverTree(root);
        System.out.println("=====");
    }

    List<Integer> list = new ArrayList<>();
    int index = 0;

    public void recoverTree(TreeNode root) {
        inorder(root);
        list.sort(Integer::compareTo);
        inorderAndSwap(root);
    }

    private void inorderAndSwap(TreeNode root){
        if(root==null)return;
        inorderAndSwap(root.left);
        Integer val = list.get(index);
        if(val != root.val){
            root.val = val;
        }
        index++;
        inorderAndSwap(root.right);
    }

    private void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
