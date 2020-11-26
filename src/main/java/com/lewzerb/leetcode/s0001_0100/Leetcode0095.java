package com.lewzerb.leetcode.s0001_0100;

import com.lewzerb.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Leetcode0095 {

    public static void main(String[] args) {
        Leetcode0095 leetcode0095 = new Leetcode0095();
        List<TreeNode> treeNodes = leetcode0095.generateTrees(3);
        System.out.println(treeNodes.size());
    }

    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int begin, int end){
        List<TreeNode> res = new ArrayList<>();
        for(int i=begin; i<=end; i++){

            List<TreeNode> lefts = dfs(begin, i - 1);
            List<TreeNode> rights = dfs(i + 1, end);

            if(!lefts.isEmpty() && !rights.isEmpty()){
                for(TreeNode left: lefts){
                    for(TreeNode right: rights){
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }else if(!lefts.isEmpty()){
                for(TreeNode left: lefts){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    res.add(root);
                }
            }else if(!rights.isEmpty()){
                for(TreeNode right: rights){
                    TreeNode root = new TreeNode(i);
                    root.right = right;
                    res.add(root);
                }
            }else {
                TreeNode root = new TreeNode(i);
                res.add(root);
            }
        }
        return res;
    }
}
