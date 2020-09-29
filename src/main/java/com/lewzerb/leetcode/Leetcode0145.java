package com.lewzerb.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Leetcode0145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = root;
        while (temp!=null || !stack.isEmpty()){
            if(temp != null){
                stack.push(temp);
                list.addFirst(temp.val);
                temp = temp.right;
            }else {
                TreeNode node = stack.pop();
                temp = node.left;
            }
        }
        return list;
    }
}
