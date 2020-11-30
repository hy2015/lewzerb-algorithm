package com.lewzerb.tree;

public class PreIn2PostTest {
    public static void main(String[] args) {
        String pre = "GDAFEMHZ";
        String in = "ADEFGHMZ";

        // AEFDHZMG
        // AEFDHZMG

        BTreeNode treeNode = preIn2Post(pre, in, pre.length());

        TreeOrdering.postOrder(treeNode);
        System.out.println();
    }

    public static BTreeNode preIn2Post(String preArr, String inArr, int length){
        if(length == 0)  return null;

        BTreeNode root = new BTreeNode();

        char rootVal = preArr.charAt(0);
        root.setValue(String.valueOf(rootVal));
        int leftLen = 0;

        for(int i=0; i<length; i++){
            if(inArr.charAt(i) == rootVal){
                leftLen = i;
                break;
            }
        }

        root.setLeft(preIn2Post(preArr.substring(1, leftLen + 1), inArr.substring(0, leftLen), leftLen));
        root.setRight(preIn2Post(preArr.substring(leftLen+1), inArr.substring(leftLen+1), length - leftLen - 1));

        return root;
    }
}
