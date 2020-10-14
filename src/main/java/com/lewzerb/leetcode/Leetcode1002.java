package com.lewzerb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode1002 {

    public static void main(String[] args) {
        String[] A = {"cool","lock","cook"};
//        String[] A = {"bella","label","roller"};
        Leetcode1002 leetcode1002 = new Leetcode1002();

        List<String> commonChars = leetcode1002.commonChars(A);
        commonChars.forEach(System.out::println);
    }

    /*public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if(A.length == 1){
            for(Character c : A[0].toCharArray()){
                res.add(c + "");
            }
            return res;
        }

        HashMap<String, Integer> map = new HashMap<>();

        for(Character c : A[0].toCharArray()){
            boolean has = true;

            for (int i = 1; i < A.length; i++) {
                String key = c + "" + i;
                map.putIfAbsent(key, -1);
                int idx = A[i].indexOf(c + "", map.get(key) + 1);
                if (idx > map.get(key)) {
                    map.put(key, idx);
                }else {
                    has = false;
                    break;
                }
            }
            if(has){
                res.add(c + "");
            }
        }
        return res;
    }*/
    public List<String> commonChars(String[] A){
        List<String> res = new ArrayList<>();
        int[] alpha = new int[26];
        Arrays.fill(alpha, Integer.MAX_VALUE);

        for(String word: A){
            int[] beta = new int[26];
            for(char c : word.toCharArray()){
                beta[c - 'a']++;
            }

            for(int i=0; i<26; i++){
                alpha[i] = Math.min(alpha[i], beta[i]);
            }
        }

        for(int i=0; i<26; i++){
            for(int j=0; j<alpha[i]; j++){
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
    }
}
