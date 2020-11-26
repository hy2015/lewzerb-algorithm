package com.lewzerb.leetcode.s0201_0300;


import com.lewzerb.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode0235 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(5);

        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;
        n2.right = n6;

        n4.left = n7;
        n4.right = n8;

        Leetcode0235 leetcode0235 = new Leetcode0235();

        TreeNode ancestor = leetcode0235.lowestCommonAncestor(root, root, n4);
        System.out.println(ancestor.val);
    }

    private Map<Integer, TreeNode[]> treeNodeMap = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode[] rootVector = {root, null};
        treeNodeMap.put(root.val, rootVector);
        initVector(root);

        TreeNode[] pVector = treeNodeMap.get(p.val);
        TreeNode[] qVector = treeNodeMap.get(q.val);

        List<TreeNode> paths = new ArrayList<>();
        while (true){
            paths.add(pVector[0]);
            if(pVector[1] == null) break;
            pVector = treeNodeMap.get(pVector[1].val);
        }

        while(true){
            if (paths.contains(qVector[0])) return qVector[1];
            qVector = treeNodeMap.get(qVector[1].val);
        }
    }



    private void initVector(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left!=null){
            TreeNode[] vector = {root.left, root};
            treeNodeMap.put(root.left.val, vector);
            initVector(root.left);
        }
        if(root.right!=null){
            TreeNode[] vector = {root.right, root};
            treeNodeMap.put(root.right.val, vector);
            initVector(root.right);
        }
    }


}
