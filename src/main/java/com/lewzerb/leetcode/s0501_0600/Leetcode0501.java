package com.lewzerb.leetcode.s0501_0600;

import com.lewzerb.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode0501 {

    public static void main(String[] args) {
        Leetcode0501 leetcode0501 = new Leetcode0501();

        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(-1);

//        TreeNode root = new TreeNode(4);
//        TreeNode n1 = new TreeNode(2);
//        TreeNode n2 = new TreeNode(3);
//        TreeNode n3 = new TreeNode(6);
//        TreeNode n4 = new TreeNode(5);
//        TreeNode n5 = new TreeNode(1);

        root.left = n1;
        root.right = n3;

        n1.left = n5;
        n1.right = n2;

        n3.left = n4;

        System.out.println(Arrays.toString(leetcode0501.findMode(root)));
    }


    int maxCount = 0;
    int count = 0;
    List<Integer> ansList = new ArrayList<>();
    int preVal;

    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];

        morrisInOrder(root);

        int[] ans = new int[ansList.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    private void morrisInOrder(TreeNode root){
        TreeNode cur = root;
        TreeNode pre;

        while (cur != null){
            //左孩子为空，输出，更新当前节点为右孩子
            if(cur.left == null){
                counter(cur.val);
                cur = cur.right;
            } else {
                for(pre = cur.left; pre.right != null && pre.right != cur; pre = pre.right);

                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }else {
                    pre.right = null;
                    counter(cur.val);
                    cur = cur.right;
                }

            }
        }
    }

    private void counter(int val){
        if(val != preVal){
            preVal = val;
            count = 0;
        }
        count++;
        if(count > maxCount){
            maxCount = count;
            ansList.clear();
            ansList.add(val);
        }else if(count == maxCount){
            ansList.add(val);
        }
    }


}
