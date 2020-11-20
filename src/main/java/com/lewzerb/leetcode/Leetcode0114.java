package com.lewzerb.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode0114 {

    List<TreeNode> list = new ArrayList<>();

    public void flatten2(TreeNode root) {
        preorder(root);
        TreeNode iter = root;

        for(int i=1; i<list.size(); i++){
            iter.right = list.get(i);
            iter.left = null;
            iter = iter.right;
        }
    }

    private void preorder(TreeNode root){
        if(root == null) return;
        list.add(root);
        preorder(root.left);
        preorder(root.right);
    }


    public void flatten(TreeNode root) {
        TreeNode cur = root;

        while (cur != null){
            if(cur.left != null){
                TreeNode nxt = cur.left;
                TreeNode pre = nxt;
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = nxt;
            }

            cur = cur.right;
        }
    }
}
