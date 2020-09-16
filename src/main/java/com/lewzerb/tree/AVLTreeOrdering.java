package com.lewzerb.tree;

public class AVLTreeOrdering {

    public static void main(String[] args) {
        AVLTreeNode root = new AVLTreeNode(1);

        AVLTreeNode avlTreeNode = root
            .insert(11)
            .insert(7)
            .insert(5)
            .insert(6)
            .insert(2)
            .insert(4)
            .insert(3)
            .insert(20)
            .insert(13)
            .insert(15)
            .insert(14)
            .insert(9)
            .insert(19)
            .insert(16)
            .insert(8)
            .insert(12)
            ;

        System.out.println("Pre-Ordering...");
        preOrder(avlTreeNode);
        System.out.println();
        System.out.println("In-Ordering...");
        inOrder(avlTreeNode);
        System.out.println();
        System.out.println("Post-Ordering...");
        postOrder(avlTreeNode);
        System.out.println();

    }



    public static void preOrder(AVLTreeNode treeNode){
        if(treeNode == null) return;
        System.out.print(treeNode.getValue()+"->");
        preOrder(treeNode.getLeft());
        preOrder(treeNode.getRight());
    }

    public static void inOrder(AVLTreeNode treeNode){
        if(treeNode == null) return;
        inOrder(treeNode.getLeft());
        System.out.print(treeNode.getValue()+"->");
        inOrder(treeNode.getRight());
    }

    public static void postOrder(AVLTreeNode treeNode){
        if(treeNode == null) return;
        postOrder(treeNode.getLeft());
        postOrder(treeNode.getRight());
        System.out.print(treeNode.getValue()+"->");
    }
}
