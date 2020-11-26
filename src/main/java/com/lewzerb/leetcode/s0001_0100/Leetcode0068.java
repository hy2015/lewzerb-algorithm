package com.lewzerb.leetcode.s0001_0100;

import java.util.ArrayList;
import java.util.List;

public class Leetcode0068 {

    // ["This    is    an","example  of text","justification.  "]
    private String fillSpace(int n){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<n; i++){
            builder.append(" ");
        }
        return builder.toString();
    }

    private String fullFillLine(String[] words, int begin, int end, int maxWidth, boolean lastLine){
        StringBuilder builder = new StringBuilder();

        int wordsSizeSum = 0;
        int wordsCount = end - begin + 1;
        for(int i=begin; i<=end; i++){
            wordsSizeSum += words[i].length();
        }

        int space = maxWidth - wordsSizeSum - wordsCount + 1;
        int spaceAvg = wordsCount == 1? space: space / (wordsCount - 1);
        int spaceExt = wordsCount == 1? 0 : space % (wordsCount -1);

        for(int i=begin; i<end; i++){
            if(lastLine){
                builder.append(words[i]).append(" ");
            }else {
                int idx = i - begin;
                int ext = idx < spaceExt ? 1 : 0;
                builder.append(words[i]).append(fillSpace(1 + spaceAvg + ext));
            }
        }
        builder.append(words[end]);
        builder.append(fillSpace(maxWidth - builder.length()));
        return builder.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int count = 0;
        int begin = 0;
        for(int i=0; i<words.length; i++){
            count += words[i].length() + 1;
            if(i == words.length - 1 || count + words[i+1].length() > maxWidth){
                res.add(fullFillLine(words, begin, i, maxWidth,i == words.length -1));
                begin = i + 1;
                count = 0;
            }
        }
        return res;
    }
}
