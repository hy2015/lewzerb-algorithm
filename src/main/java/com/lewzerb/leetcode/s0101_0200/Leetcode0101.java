package com.lewzerb.leetcode.s0101_0200;

import com.lewzerb.leetcode.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode0101 {


    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null) return false;
        if(right == null) return false;
        if(left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }


}
