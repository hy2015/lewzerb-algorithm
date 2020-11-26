package com.lewzerb.leetcode.s0101_0200;

import com.lewzerb.leetcode.Node;
import java.util.HashMap;
import java.util.Map;

public class Leetcode0117 {

    public Node connect(Node root) {
        bfs(root);
        return root;
    }

    public void bfs(Node root){
        if(root == null) return;

        Node cur = root;
        while (cur != null){
            Node dummy = new Node(0);
            Node pre = dummy;
            while (cur!=null){
                if(cur.left != null){
                    pre.next = cur.left;
                    pre = pre.next;
                }

                if(cur.right != null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
    }

    /*private Map<Integer, Node> map = new HashMap<>();

    public Node connect(Node root) {
        dfs(root, 0);
        return root;
    }

    private void dfs(Node node, int layer){
        if(node == null) return;

        dfs(node.left, layer + 1);
        Node cur = map.get(layer);
        if (cur != null) {
            cur.next = node;
        }
        node.next = null;
        map.put(layer, node);

        dfs(node.right, layer + 1);
    }*/
}
