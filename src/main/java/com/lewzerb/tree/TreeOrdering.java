package com.lewzerb.tree;

public class TreeOrdering {

    public static void main(String[] args) {
        TreeNode root = sampleTree();
        System.out.println(TreeNode.height(root));

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);

    }

    private static TreeNode sampleTree() {
        TreeNode root = new TreeNode("G");

        TreeNode a = new TreeNode("A");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");
        TreeNode h = new TreeNode("H");
        TreeNode m = new TreeNode("M");
        TreeNode z = new TreeNode("Z");

        root.setLeft(d);
        root.setRight(m);

        d.setLeft(a);
        d.setRight(f);

        f.setLeft(e);

        m.setLeft(h);
        m.setRight(z);

        return root;
    }

    public static void preOrder(TreeNode treeNode){
        if(treeNode == null) return;
        System.out.print(treeNode.getValue());
        preOrder(treeNode.getLeft());
        preOrder(treeNode.getRight());
    }

    public static void inOrder(TreeNode treeNode){
        if(treeNode == null) return;
        inOrder(treeNode.getLeft());
        System.out.print(treeNode.getValue());
        inOrder(treeNode.getRight());
    }

    public static void postOrder(TreeNode treeNode){
        if(treeNode == null) return;
        postOrder(treeNode.getLeft());
        postOrder(treeNode.getRight());
        System.out.print(treeNode.getValue());
    }
}
