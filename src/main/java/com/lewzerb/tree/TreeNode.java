package com.lewzerb.tree;

public class TreeNode {
    private String value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static int height(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        if(treeNode.getLeft() == null && treeNode.getRight() == null){
            return 1;
        }

        return 1 + Math.max(height(treeNode.getLeft()), height(treeNode.getRight()));
    }

    public static void singleRotateLeft(TreeNode k2){
        TreeNode k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
    }

    public static void singleRotateRight(TreeNode k2){
        TreeNode k1 = k2.getRight();
        k2.setRight(k1.getLeft());
        k1.setLeft(k2);
    }

    public static void doubleRotateRightLeft(TreeNode k3){
        singleRotateRight(k3.getLeft());
        singleRotateLeft(k3);
    }

    public static void doubleRotateLeftRight(TreeNode k3){
        singleRotateLeft(k3.getRight());
        singleRotateRight(k3);
    }

    public static TreeNode insert(TreeNode node, String newVal){
        if(node == null){
            return new TreeNode(newVal);
        }

        int compareTo = newVal.compareTo(node.getValue());
        if(compareTo < 0){
            node.setLeft(insert(node.getLeft(), newVal));

            if(height(node.getLeft()) - height(node.getRight()) == 2){
                if(newVal.compareTo(node.getLeft().getValue()) < 0){
                    singleRotateLeft(node);
                }else {
                    doubleRotateLeftRight(node);
                }
            }
        } else if(compareTo > 0){
            node.setRight(insert(node.getRight(), newVal));

            if(height(node.getRight()) - height(node.getLeft()) == 2){
                if(newVal.compareTo(node.getRight().getValue()) > 0){
                    singleRotateRight(node);
                }else {
                    doubleRotateRightLeft(node);
                }
            }
        } else {
            System.out.println("Duplicated value");
        }
        return node;
    }

    public void insert(String newVal){
        TreeNode.insert(this, newVal);
    }
}
