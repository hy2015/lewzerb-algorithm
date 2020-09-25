package com.lewzerb.leetcode;

public class Leetcode0014 {

    public static void main(String[] args) {
        String[] test = new String[]{"cflower","flow","flight"};
        Leetcode0014 leetcode0014 = new Leetcode0014();
        System.out.println(leetcode0014.longestCommonPrefix(test));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null) return "";
        int p = 0;
        out: while (true){
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
