package com.lewzerb.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode0077 {

    public static void main(String[] args) {
        Leetcode0077 leetcode0077 = new Leetcode0077();
        leetcode0077.combine(4, 2).forEach(System.out::println);
    }


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();


        dfs(res, path, n,1, k);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> path, int n, int begin, int k){
        if(path.size() + n - begin + 1 < k){
            return;
        }

        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        path.addLast(begin);
        dfs(res, path, n, begin + 1, k);
        path.removeLast();
        dfs(res, path, n, begin + 1, k);
    }
}
