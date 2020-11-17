package com.lewzerb.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode0105 {



    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        Leetcode0105 leetcode0105 = new Leetcode0105();
        TreeNode root = leetcode0105.buildTree(preorder, inorder);
        System.out.println(root);
    }

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        buildMap(preorder, inorder);
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pBegin, int pEnd, int[] inorder, int iBegin, int iEnd){
        if(pBegin > pEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pBegin]);
        if(pBegin == pEnd){
            return root;
        }

        int i = indexMap.get(preorder[pBegin]);
        int len = i - iBegin;
        root.left = buildTree(preorder, pBegin + 1, pBegin + len, inorder, iBegin, i - 1);
        root.right = buildTree(preorder, pBegin + len + 1, pEnd, inorder, i + 1, iEnd);

        return root;
    }

    private void buildMap(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
    }
}
