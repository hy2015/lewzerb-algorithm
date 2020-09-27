package com.lewzerb.leetcode;

public class Leetcode0014 {

    public static void main(String[] args) {
        String[][] tests = new String[][]{
                {"flower","flow","flight"},
                {},
                {""},
                {"cflower","flow","flight"},
                {"c","c"}
        };
        Leetcode0014 leetcode0014 = new Leetcode0014();
        for(String[] test: tests){
            System.out.println(leetcode0014.longestCommonPrefix(test));
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        int p = 0;
        out: while (true){
            if(p >= strs[0].length()) break ;
            char cur = strs[0].charAt(p);
            for(int i=1; i<strs.length; i++){
                if(p >= strs[i].length()){
                    break out;
                }else {
                    if(cur != strs[i].charAt(p)){
                        break out;
                    }
                }
            }
            p++;
        }
        return strs[0].substring(0, p);
    }
}
