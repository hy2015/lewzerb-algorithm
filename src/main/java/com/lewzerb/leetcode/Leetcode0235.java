package com.lewzerb.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode0235 {

    private Map<Integer, TreeNode[]> treeNodeMap = new HashMap<>();
    private List<TreeNode[]> paths = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        preOrderTraversal(root);
    }

    private TreeNode unionFind(TreeNode p, TreeNode q){
        TreeNode[] pVector = treeNodeMap.get(p.val);
        TreeNode[] qVector = treeNodeMap.get(q.val);

        if(pVector[1] == q) return p;
        if(qVector[1] == p) return q;
    }

    private void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left!=null){
            TreeNode[] vector = {root.left, root};
            paths.add(vector);
            treeNodeMap.put(root.left.val, vector);
        }
        if(root.right!=null){
            TreeNode[] vector = {root.right, root};
            paths.add(vector);
            treeNodeMap.put(root.right.val, vector);
        }
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    class UnionFindTreeNode{
        List<TreeNode> ancestors;
    }

}
