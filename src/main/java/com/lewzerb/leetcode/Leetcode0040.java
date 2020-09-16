package com.lewzerb.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Leetcode0040 {

    public static void main(String[] args) {
//        int[] candidates = {10,1,2,7,6,1,5};
//        int target = 8;
        int[] candidates = {2, 2, 2};
        int target = 2;

        Leetcode0040 leetcode0040 = new Leetcode0040();
        List<List<Integer>> combinationSum = leetcode0040.combinationSum2(candidates, target);

        combinationSum.forEach(System.out::println);
    }

    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用一次。
     *
     * 说明：
     *
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     *
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     * 示例 2:
     *
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 所求解集为:
     * [
     *   [1,2,2],
     *   [5]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     **/

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);
        backtrackSum2(candidates, 0, target, path, res);

        return res;
    }


    public void backtrackSum2(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> res){

        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=begin; i<candidates.length; i++){
            if(target - candidates[i]< 0){
                break;
            }
            path.addLast(candidates[i]);
            backtrackSum2(candidates, i + 1, target - candidates[i], path, res);
            path.removeLast();


            while(i+1 < candidates.length && candidates[i] == candidates[i+1]){
                i++;
            }

        }
    }

}
