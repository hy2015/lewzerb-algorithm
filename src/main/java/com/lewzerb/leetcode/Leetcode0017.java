package com.lewzerb.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode0017 {

    public static void main(String[] args) {
        Leetcode0017 leetcode0017 = new Leetcode0017();
        List<String> words = leetcode0017.letterCombinations("23");
        words.forEach(System.out::println);
    }

    char[][] phoneLetter = {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        StringBuilder builder = new StringBuilder();
        backtrack(res, digits, 0, builder);
        return res;
    }

    private void backtrack(List<String> res, String digits, int index, StringBuilder builder){
        if(digits.length() == index){
            res.add(builder.toString());
        }else {
            for (char letter : phoneLetter[digits.charAt(index) - '2']) {
                builder.append(letter);
                backtrack(res, digits, index + 1, builder);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }

}
