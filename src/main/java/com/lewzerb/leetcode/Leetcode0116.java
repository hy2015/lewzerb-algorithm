package com.lewzerb.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Leetcode0116 {

    public Node connect(Node root) {
        if(root == null) return root;

        Queue<Node> queue = new ConcurrentLinkedDeque<>();
        Node dummy = new Node(0);

        queue.add(root);
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            dummy.next = poll;
            dummy = poll;

            queue.add(poll.left);
            queue.add(poll.right);
        }
        return root;
    }
}
