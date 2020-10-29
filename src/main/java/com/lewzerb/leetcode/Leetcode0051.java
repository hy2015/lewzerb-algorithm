package com.lewzerb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode0051 {

    public static void main(String[] args) {
        int a = 2;
        System.out.println(a & -a);
    }

    /*public List<List<String>> solveNQueens(int n){
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();

        int[] queens = new int[n];

        List<List<String>> ans = new ArrayList<>();

        solve(ans, n, 0, queens, columns, diagonals1, diagonals2);
        return ans;
    }

    private void solve(List<List<String>> ans, int n, int row, int[] queens, Set<Integer> columns,
        Set<Integer> diagonals1, Set<Integer> diagonals2){
        if(row == n){
            ans.add(genQueens(queens));
            return;
        }

        for(int i=0; i<n; i++){
            if(columns.contains(i)){
                continue;
            }
            int d1 = i + row;
            if(diagonals1.contains(d1)){
                continue;
            }
            int d2 = i - row;
            if(diagonals2.contains(d2)){
                continue;
            }

            queens[row] = i;
            columns.add(i);
            diagonals1.add(d1);
            diagonals2.add(d2);
            solve(ans, n, row + 1, queens, columns, diagonals1, diagonals2);
            queens[row] = -1;
            columns.remove(i);
            diagonals1.remove(d1);
            diagonals2.remove(d2);
        }
    }*/

    public List<List<String>> solveNQueens(int n){
        int[] queens = new int[n];
        List<List<String>> ans = new ArrayList<>();
        solve(ans, n, 0, queens, 0, 0, 0);
        return ans;
    }

    private void solve(List<List<String>> ans, int n, int row, int[] queens, int columns,
        int diagonals1, int diagonals2){
        if(row == n){
            ans.add(genQueens(queens));
            return;
        }
        int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
        while (availablePositions != 0){
            int position = availablePositions & (- availablePositions);
            availablePositions = availablePositions & (availablePositions - 1);
            int column = Integer.bitCount(position - 1);
            queens[row] = column;
            solve(ans,  n, row + 1, queens,columns | position,
                (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
            queens[row] = -1;
        }
    }


    private List<String> genQueens(int[] queens){
        int n = queens.length;
        List<String> ans = new ArrayList<>();
        for (int queen : queens) {
            char[] q = new char[n];
            Arrays.fill(q, '.');
            q[queen] = 'Q';
            ans.add(new String(q));
        }
        return ans;
    }
}
