package com.lewzerb.leetcode.s0901_1000;

public class Leetcode0925 {

    public static void main(String[] args) {
        String[][] tests = {
            {"alex", "aaleex"},
            {"saeed", "ssaaedd"},
            {"leelee", "lleeelee"},
            {"laiden", "laiden"},
            {"a", "aaaaaaaaaaaaaaaaa"}
        };
        Leetcode0925 leetcode0925 = new Leetcode0925();
        for(String[] test: tests){
            System.out.println(leetcode0925.isLongPressedName(test[0], test[1]));
        }
    }

    public boolean isLongPressedName(String name, String typed) {
        int i=0,j=0;
        char[] nameChars = name.toCharArray();
        char[] typedChars = typed.toCharArray();

        if(nameChars.length > typedChars.length) return false;
        while (i< nameChars.length && j< typedChars.length){
            if(nameChars[i] == typedChars[j]){
                i++;
                j++;
            }else if(j>0 && typedChars[j] == typedChars[j-1]){
                j++;
            }else {
                return false;
            }
        }


        while (j < typedChars.length){
            if(typedChars[j] != typedChars[j-1]){
                return false;
            }
            j++;
        }
        return i == nameChars.length;
    }

    /*public boolean isLongPressedName(String name, String typed) {

        boolean[][] dp = new boolean[name.length()+1][typed.length()+1];

        dp[0][0] = true;

        for(int i=1; i<=name.length(); i++){
            for(int j=1; j<=typed.length(); j++){
                if(name.charAt(i-1) == typed.charAt(j-1)){
                    if(j > 1 && typed.charAt(j-1) == typed.charAt(j-2)){
                        dp[i][j] = dp[i-1][j-1] || dp[i-1][j-2] || dp[i][j-2];
                    }else {
                        dp[i][j] = dp[i-1][j-1];
                    }
                }else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[name.length()][typed.length()];
    }*/
}
