package com.lewzerb.tree;

public class BalanceBinaryTreeTest {

    public static void main(String[] args) {
        AVLTreeNode root = new AVLTreeNode(1);

        AVLTreeNode avlTreeNode = root.insert(2)
                .insert(3)
                .insert(4)
                .insert(5)
                .insert(6)
                .insert(7);

        System.out.println(avlTreeNode);
    }
}
