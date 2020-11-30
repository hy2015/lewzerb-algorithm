package com.lewzerb.tree;

public class TreeOrdering {

    public static void main(String[] args) {
        BTreeNode root = sampleTree();
        System.out.println(BTreeNode.height(root));

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);

    }

    private static BTreeNode sampleTree() {
        BTreeNode root = new BTreeNode("G");

        BTreeNode a = new BTreeNode("A");
        BTreeNode d = new BTreeNode("D");
        BTreeNode e = new BTreeNode("E");
        BTreeNode f = new BTreeNode("F");
        BTreeNode h = new BTreeNode("H");
        BTreeNode m = new BTreeNode("M");
        BTreeNode z = new BTreeNode("Z");

        root.setLeft(d);
        root.setRight(m);

        d.setLeft(a);
        d.setRight(f);

        f.setLeft(e);

        m.setLeft(h);
        m.setRight(z);

        return root;
    }

    public static void preOrder(BTreeNode treeNode){
        if(treeNode == null) return;
        System.out.print(treeNode.getValue());
        preOrder(treeNode.getLeft());
        preOrder(treeNode.getRight());
    }

    public static void inOrder(BTreeNode treeNode){
        if(treeNode == null) return;
        inOrder(treeNode.getLeft());
        System.out.print(treeNode.getValue());
        inOrder(treeNode.getRight());
    }

    public static void postOrder(BTreeNode treeNode){
        if(treeNode == null) return;
        postOrder(treeNode.getLeft());
        postOrder(treeNode.getRight());
        System.out.print(treeNode.getValue());
    }
}
