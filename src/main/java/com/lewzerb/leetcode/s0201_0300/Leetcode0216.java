package com.lewzerb.leetcode.s0201_0300;

import java.util.ArrayList;
import java.util.List;

public class Leetcode0216 {

    public static void main(String[] args) {
        Leetcode0216 leetcode0216 = new Leetcode0216();
        List<List<Integer>> combinationSum = leetcode0216.combinationSum3(4, 11);

        combinationSum.forEach(System.out::println);
    }

    /**
     * 找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。
     *
     * 说明：
     *
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1:
     *
     * 输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     * 示例 2:
     *
     * 输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     **/


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();


        backtrackSum3( 1, k, n, new ArrayList<>(), res);

        return res;
    }


    public void backtrackSum3( int begin, int count, int target, List<Integer> path, List<List<Integer>> res){

        if(target == 0 && count == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=begin; i<=9; i++){
            if(target - i < 0){
                break;
            }
            path.add(i);
            backtrackSum3(i + 1,  count - 1, target - i, path, res);
            path.remove(path.size() - 1);

        }
    }

}
