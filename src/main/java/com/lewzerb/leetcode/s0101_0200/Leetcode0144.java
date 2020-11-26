package com.lewzerb.leetcode.s0101_0200;

import com.lewzerb.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Leetcode0144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(res, root);
        return res;
    }

    private void preorder(List<Integer> res, TreeNode root){
        if(root == null){
            return;
        }
        res.add(root.val);
        preorder(res, root.left);
        preorder(res, root.right);
    }
}
