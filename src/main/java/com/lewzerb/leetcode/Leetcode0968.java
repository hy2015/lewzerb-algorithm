package com.lewzerb.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode0968 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        root.left = n1;
        n1.left = n2;
        n1.right = n3;

        Leetcode0968 leetcode0968 = new Leetcode0968();
        System.out.println(leetcode0968.minCameraCover(root));
    }



    public int minCameraCover(TreeNode root) {
        int[] arr = dfs(root);
        return arr[1];
    }

    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{Integer.MAX_VALUE/2, 0, 0};
        }
        int[] leftArr = dfs(root.left);
        int[] rightArr = dfs(root.right);

        int[] arr = new int[3];
        arr[0] = leftArr[2] + rightArr[2] + 1;
        arr[1] = Math.min(arr[0], Math.min(leftArr[0] + rightArr[1], leftArr[1] + rightArr[0]));
        arr[2] = Math.min(arr[0], leftArr[1] + rightArr[1]);
        return arr;
    }

}
