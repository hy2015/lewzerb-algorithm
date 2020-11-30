package com.lewzerb.tree;

public class BTreeNode {
    private String value;
    private BTreeNode left;
    private BTreeNode right;

    public BTreeNode() {
    }

    public BTreeNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BTreeNode getLeft() {
        return left;
    }

    public void setLeft(BTreeNode left) {
        this.left = left;
    }

    public BTreeNode getRight() {
        return right;
    }

    public void setRight(BTreeNode right) {
        this.right = right;
    }

    public static int height(BTreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        if(treeNode.getLeft() == null && treeNode.getRight() == null){
            return 1;
        }

        return 1 + Math.max(height(treeNode.getLeft()), height(treeNode.getRight()));
    }

    public static void singleRotateLeft(BTreeNode k2){
        BTreeNode k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
    }

    public static void singleRotateRight(BTreeNode k2){
        BTreeNode k1 = k2.getRight();
        k2.setRight(k1.getLeft());
        k1.setLeft(k2);
    }

    public static void doubleRotateRightLeft(BTreeNode k3){
        singleRotateRight(k3.getLeft());
        singleRotateLeft(k3);
    }

    public static void doubleRotateLeftRight(BTreeNode k3){
        singleRotateLeft(k3.getRight());
        singleRotateRight(k3);
    }

    public static BTreeNode insert(BTreeNode node, String newVal){
        if(node == null){
            return new BTreeNode(newVal);
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
        BTreeNode.insert(this, newVal);
    }
}
