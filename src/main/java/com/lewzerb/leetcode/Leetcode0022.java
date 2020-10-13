package com.lewzerb.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode0022 {

    public static void main(String[] args) {
        Leetcode0022 leetcode0022 = new Leetcode0022();

        List<String> res = leetcode0022.generateParenthesis(3);
        res.forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
       List<String> res = new ArrayList<>();
       dfs(res, n, n, new StringBuilder());
       return res;
    }

    private void dfs(List<String> res, int nL, int nR, StringBuilder builder){
        if(nL == 0 && nR == 0){
            res.add(builder.toString());
            return;
        }

        if(nL > nR){
            return;
        }

        if(nL > 0){
            dfs(res, nL - 1, nR, builder.append("("));
            builder.deleteCharAt(builder.length() - 1);
        }

        if(nR > 0){
            dfs(res, nL, nR - 1, builder.append(")"));
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    private boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
            }else {
                if(stack.isEmpty()) return false;
                Character pop = stack.pop();
                if(pop != '(') return false;
            }
        }
        return stack.isEmpty();
    }
}
