package com.lewzerb.leetcode;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Leetcode0140 {

    public static void main(String[] args) {
//        String s = "catsanddog";
//        List<String> wordDict = Arrays.asList("cat","cats","and","sand","dog");
//        String s = "aaaaaaa";
//        List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa")//
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        Leetcode0140 leetcode0140 = new Leetcode0140();
        long start = System.currentTimeMillis();
        List<String> w = leetcode0140.wordBreak(s, wordDict);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
        w.forEach(System.out::println);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        dfs(res, path, s, wordDict);
        List<String> ans = new ArrayList<>();

        for(List<String> re : res){
            ans.add(String.join(" ", re));
        }
        return ans;
    }

    private void dfs(List<List<String>> res, Deque<String> path, String s, List<String> wordDict){
        if(s.equals("")){
            res.add(new ArrayList<>(path));
            return;
        }

        for(String word: wordDict){
            if(s.startsWith(word)){
                path.addLast(word);
                int n = word.length();
                dfs(res, path, s.substring(n), wordDict);
                path.removeLast();
            }
        }
    }
}
