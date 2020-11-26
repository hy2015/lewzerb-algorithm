package com.lewzerb.leetcode.s0101_0200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Leetcode0127 {

    public static void main(String[] args) {
//        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
//        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dog");
        String beginWord = "hot", endWord = "dog";
        Leetcode0127 leetcode0127 = new Leetcode0127();

        System.out.println(leetcode0127.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }

        int minPath = Integer.MAX_VALUE;
        List<List<String>> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        dfs(res, path, beginWord, endWord, wordList);

        for(List<String> re: res){
            minPath = Math.min(minPath, re.size());
        }
        return minPath == Integer.MAX_VALUE ? 0:  minPath+1;
    }

    private void dfs(List<List<String>> res, Deque<String> path, String beginWord, String endWord, List<String> wordList){
        if(wordList.size() == 0){
            return;
        }
        for(String word: getNextWords(beginWord, wordList)){
            if(word.equals(endWord)){
                path.addLast(word);
                res.add(new ArrayList<>(path));
                path.removeLast();
                continue;
            }
            path.addLast(word);
            List<String> newWordList = new ArrayList<>(wordList);
            newWordList.remove(word);
            dfs(res, path, word, endWord, newWordList);
            path.removeLast();
        }
    }

    private List<String> getNextWords(String beginWord, List<String> wordList){
        List<String> nextWords = new ArrayList<>();
        for(String word: wordList){
            if(beginWord.length() != word.length()){
                continue;
            }
            int diffCount = 0;
            for(int i=0; i<beginWord.length(); i++){
                if(word.charAt(i) != beginWord.charAt(i)){
                    diffCount++;
                }
            }
            if(diffCount == 1){
                nextWords.add(word);
            }
        }
        return nextWords;
    }

}
