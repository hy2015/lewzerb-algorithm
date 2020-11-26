package com.lewzerb.leetcode.s0101_0200;

import com.lewzerb.leetcode.TreeNode;
import java.util.Arrays;

public class Leetcode0106 {

    public static void main(String[] args) {
        int[][][] testArrs = {
            {{9,3,15,20,7},{9,15,7,20,3}},
            {{1,2},{2,1}}
        };

        Leetcode0106 leetcode0106 = new Leetcode0106();
        for(int[][] arr : testArrs){
            TreeNode node = leetcode0106.buildTree(arr[0], arr[1]);
            leetcode0106.preOrder(node);
        }
    }

    public void preOrder(TreeNode root){
        if(root==null)return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0)return null;

        int rootVal = postorder[postorder.length - 1];
        int rootIndex = -1;
        TreeNode root = new TreeNode(rootVal);
        if(inorder.length == 1) return root;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inRight = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);

        int[] postLeft = 0 > inLeft.length - 1 ? null: Arrays.copyOfRange(postorder, 0, inLeft.length );
        int[] postRight = Arrays.copyOfRange(postorder, inLeft.length , postorder.length - 1);

        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        return root;
    }
}
