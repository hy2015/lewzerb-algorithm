package com.lewzerb.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode0103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        boolean flag = true;
        while (!queue.isEmpty()){
            List<Integer> path = new ArrayList<>();
            int queueSize = queue.size();
            for(int i=0; i<queueSize; i++){
                TreeNode node = null;
                node = queue.remove(queueSize-1-i);
                path.add(node.val);

                if(flag){
                    if(node.left!=null){
                        queue.add(node.left);
                    }
                    if(node.right!=null){
                        queue.add(node.right);
                    }
                }else {
                    if(node.right!=null){
                        queue.add(node.right);
                    }
                    if(node.left!=null){
                        queue.add(node.left);
                    }
                }

            }
            flag=!flag;
            res.add(path);
        }
        return res;
    }
}
