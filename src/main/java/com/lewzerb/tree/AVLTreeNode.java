package com.lewzerb.tree;

public class AVLTreeNode {
    private int value;
    private AVLTreeNode parent;
    private AVLTreeNode left;
    private AVLTreeNode right;

    public AVLTreeNode() {
    }

    public AVLTreeNode(int value, AVLTreeNode parent) {
        this.value = value;
        this.parent = parent;
    }

    public AVLTreeNode(int value) {
        this(value, null);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AVLTreeNode getParent() {
        return parent;
    }

    public void setParent(AVLTreeNode parent) {
        this.parent = parent;
    }

    public AVLTreeNode getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode left) {
        this.left = left;
    }

    public AVLTreeNode getRight() {
        return right;
    }

    public void setRight(AVLTreeNode right) {
        this.right = right;
    }

    public static int height(AVLTreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        if (treeNode.getLeft() == null && treeNode.getRight() == null) {
            return 1;
        }

        return 1 + Math.max(height(treeNode.getLeft()), height(treeNode.getRight()));
    }

    public static AVLTreeNode singleRotateLeft(AVLTreeNode k2) {
        AVLTreeNode k1 = k2.getLeft();

        k1.setParent(k2.getParent());
        k2.setParent(k1);

        k2.setLeft(k1.getRight());
        k1.setRight(k2);

        return k1;
    }

    public static AVLTreeNode singleRotateRight(AVLTreeNode k2) {
        AVLTreeNode k1 = k2.getRight();

        k1.setParent(k2.getParent());
        k2.setParent(k1);

        k2.setRight(k1.getLeft());
        k1.setLeft(k2);

        return k1;
    }

    public static AVLTreeNode doubleRotateRightLeft(AVLTreeNode k3) {
        AVLTreeNode k1 = singleRotateRight(k3.getLeft());
        refresh(k1, k1.getParent());
        return singleRotateLeft(k3);
    }

    public static AVLTreeNode doubleRotateLeftRight(AVLTreeNode k3) {
        AVLTreeNode k1 = singleRotateLeft(k3.getRight());
        refresh(k1, k1.getParent());
        return singleRotateRight(k3);
    }

    public static AVLTreeNode insert(AVLTreeNode current, int newVal) {

        AVLTreeNode newNode = new AVLTreeNode(newVal);

        AVLTreeNode parent = current.getParent();
        AVLTreeNode left = current.getLeft();
        AVLTreeNode right = current.getRight();

        if(newVal < current.getValue()){
            if(left == null){
                current.setLeft(newNode);
                newNode.setParent(current);
            } else {
                insert(left, newVal);
                if(height(left) - height(right) == 2){
                    if(newVal < left.getValue()){
                        current = singleRotateLeft(current);
                    } else if(newVal > left.getValue()){
                        current = doubleRotateRightLeft(current);
                    } else {
                        System.out.println("++" + newVal);
                    }
                    refresh(current, parent);
                }
            }
        } else if(newVal > current.getValue()){

            if(right == null){
                current.setRight(newNode);
                newNode.setParent(current);
            } else {
                insert(right, newVal);
                if(height(right) - height(left) == 2){
                    if(newVal > right.getValue()){
                        current = singleRotateRight(current);
                    } else if(newVal < right.getValue()){
                        current = doubleRotateLeftRight(current);
                    } else {
                        System.out.println("++" + newVal);
                    }
                    refresh(current, parent);
                }
            }
        }


        return current;
    }

    public AVLTreeNode delete(AVLTreeNode current, int deleteVal){

        AVLTreeNode parent = current.getParent();
        AVLTreeNode left = current.getLeft();
        AVLTreeNode right = current.getRight();

        if(current.getValue() == deleteVal){
            if (left == null && right == null){
                return null;
            } else if(left == null){
                if(parent != null){
                    parent.setRight(current.getRight());
                    return parent.getRight();
                }
            } if(right == null){
                if(parent != null){
                    parent.setLeft(current.getLeft());
                    return parent.getLeft();
                }
            }
        }

        // Un-implemented

        return current;
    }

    public AVLTreeNode insert(int newVal) {
        return AVLTreeNode.insert(this, newVal);
    }

    public AVLTreeNode delete(int deleteVal){
        return null;
    }

    private static void refresh(AVLTreeNode current, AVLTreeNode parent) {
        if(parent !=null){
            if(current.getValue() < parent.getValue()){
                parent.setLeft(current);
            }else if(current.getValue() > parent.getValue()){
                parent.setRight(current);
            }
        }
    }
}
