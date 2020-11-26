package com.lewzerb.leetcode.s0001_0100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Leetcode0039 {

    public static void main(String[] args) {
        int[] candidates = {8,7,4,3};
        int target = 11;

        Leetcode0039 leetcode0039 = new Leetcode0039();
        List<List<Integer>> combinationSum = leetcode0039.combinationSum(candidates, target);

        for(List<Integer> sums: combinationSum){
            System.out.println(sums);
        }
    }

    /**
     * 示例 1：
     *
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * 示例 2：
     *
     * 输入：candidates = [2,3,5], target = 8,
     * 所求解集为：
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     **/

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);
        backtrackSum(candidates, 0, target, path, res);

        return res;
    }


    public void backtrackSum(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> res){

        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=begin; i<candidates.length; i++){
            if(target - candidates[i]< 0){
                break;
            }
            path.addLast(candidates[i]);
            backtrackSum(candidates, i, target - candidates[i], path, res);
            path.removeLast();
        }
    }

}
