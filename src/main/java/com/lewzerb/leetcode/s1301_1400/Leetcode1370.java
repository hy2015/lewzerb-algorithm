package com.lewzerb.leetcode.s1301_1400;

public class Leetcode1370 {

    public static void main(String[] args) {
        String[][] tests = {
            {"aaaabbbbcccc","abccbaabccba"},
            {"rat","art"},
            {"leetcode","cdelotee"},
            {"ggggggg","ggggggg"},
            {"spo","ops"}
        };

        Leetcode1370 leetcode1370 = new Leetcode1370();

        for(String[] test: tests){
            System.out.println(leetcode1370.sortString(test[0]) + ":" + leetcode1370.sortString(test[0]).equals(test[1]));
        }
    }

    public String sortString(String s) {
        if(s == null || s.length() == 0) return s;

        int[] arr = new int[26];

        for(char c : s.toCharArray()){
            arr[c - 'a']++;
        }

        char[] res = new char[s.length()];
        int idx =0;
        while (idx < s.length()){

            for(int i=0; i<26; i++){
                if(arr[i]!=0){
                    res[idx++] = (char)(i+'a');
                    arr[i]--;
                }
            }
            for(int i=25; i>=0; i--){
                if(arr[i]!=0){
                    res[idx++] = (char)(i+'a');
                    arr[i]--;
                }
            }
        }

        return new String(res);
    }
}
