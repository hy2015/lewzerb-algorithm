package com.lewzerb.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode0094 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        root.right = n1;
        n1.left = n2;

        Leetcode0094 leetcode0094 = new Leetcode0094();
        List<Integer> inorderTraversal = leetcode0094.inorderTraversal(root);
        inorderTraversal.forEach(System.out::println);
    }


    static class MarkedTreeNode {
        TreeNode node;
        boolean isMarked = false;

        public MarkedTreeNode(TreeNode node, boolean isMarked) {
            this.node = node;
            this.isMarked = isMarked;
        }
    }

    /**
     * recursive implementation
     * @param root
     * @return
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if(root == null){
//            return new ArrayList<>();
//        }
//        List<Integer> res = new ArrayList<>(inorderTraversal(root.left));
//        res.add(root.val);
//        res.addAll(inorderTraversal(root.right));
//
//        return res;
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<MarkedTreeNode> stack = new Stack<>();
        stack.push(new MarkedTreeNode(root, false));

        while(!stack.isEmpty()){
            MarkedTreeNode top = stack.pop();

            if(!top.isMarked){
                if(top.node.right!=null)stack.push(new MarkedTreeNode(top.node.right, false));
                stack.push(new MarkedTreeNode(top.node, true));
                if(top.node.left!=null)stack.push(new MarkedTreeNode(top.node.left, false));
            }else{
                res.add(top.node.val);
            }
        }
        return res;
    }
}
