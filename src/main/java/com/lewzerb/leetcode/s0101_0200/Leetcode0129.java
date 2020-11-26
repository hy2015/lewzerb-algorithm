package com.lewzerb.leetcode.s0101_0200;

import com.lewzerb.leetcode.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode0129 {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        Leetcode0129 leetcode0129 = new Leetcode0129();
        System.out.println(leetcode0129.sumNumbers(n1));
    }

    public int sumNumbers(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        preOrderSum(res, path, root);

        if(res.size() == 0) return 0;
        int ans = 0;
        for(int num: res){
            ans += num;
        }
        return ans;
    }

    private void preOrderSum(List<Integer> res, Deque<Integer> path, TreeNode root){
        if(root == null){
            return;
        }
        path.addLast(root.val);
        if(root.left == null && root.right == null){
            res.add(convertPathToInt(path));
        }

        if(root.left != null){
            preOrderSum(res, path, root.left);
            path.removeLast();
        }
        if(root.right != null){
            preOrderSum(res, path, root.right);
            path.removeLast();
        }
    }

    private int convertPathToInt(Deque<Integer> path){
        if(path.size() == 0) return 0;
        int sum = 0;
        for(int i : path){
            sum = sum * 10 + i;
        }
        return sum;
    }

    private int helper(TreeNode root, int sum){
        if(root == null) return 0;
        int tmp = sum * 10 + root.val;
        if(root.left == null && root.right == null){
            return tmp;
        }
        return helper(root.left, tmp) + helper(root.right, tmp);
    }
}
