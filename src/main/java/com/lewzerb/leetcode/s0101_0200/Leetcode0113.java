package com.lewzerb.leetcode.s0101_0200;

import com.lewzerb.leetcode.TreeNode;
import java.util.*;

public class Leetcode0113 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(11);
        TreeNode n4 = new TreeNode(13);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(2);
        TreeNode n8 = new TreeNode(5);
        TreeNode n9 = new TreeNode(1);

        root.left = n1;
        root.right = n2;

        n1.left = n3;

        n3.left = n6;
        n3.right = n7;

        n2.left = n4;
        n2.right = n5;

        n5.left = n8;
        n5.right = n9;

        Leetcode0113 leetcode0113 = new Leetcode0113();

        List<List<Integer>> res = leetcode0113.pathSum(root, 22);
        res.forEach(list -> System.out.println(Arrays.toString(list.toArray())));
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(sum, root);
        return res;
    }

    private void dfs(int sum, TreeNode root){
        if(root == null){
            return;
        }

        path.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        dfs(sum, root.left);
        dfs(sum, root.right);
        path.remove(path.size() - 1);
    }


}
