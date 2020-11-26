package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0036 {

    public static void main(String[] args) {
        char[][] board = new char[][]
        {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        Leetcode0036 leetcode0036 = new Leetcode0036();
        System.out.println(leetcode0036.isValidSudoku(board));
    }
    
   /* public boolean isValidSudoku(char[][] board) {

        for(int i=0; i<board.length; i++){
            Set<Character> set = new HashSet<>();
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == '.')continue;
                boolean add = set.add(board[i][j]);
                if(!add) return false;
            }
        }

        for(int i=0; i<board[0].length; i++){
            Set<Character> set = new HashSet<>();
            for(int j=0; j<board.length; j++){
                if(board[j][i] == '.')continue;
                boolean add = set.add(board[j][i]);
                if(!add) return false;
            }
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){

                Set<Character> set = new HashSet<>();
                for(int k=0;  k<3; k++){
                    for(int l=0; l<3; l++){
                        if(board[i * 3 + k][j * 3 + l] == '.')continue;
                        boolean add = set.add(board[i * 3 + k][j * 3 + l]);
                        if(!add) return false;
                    }
                }
            }
        }

        return true;
    }*/

    /*public boolean isValidSudoku(char[][] board){
        Set<Integer>[] rows = new HashSet[9];
        Set<Integer>[] cols = new HashSet[9];
        Set<Integer>[] bins = new HashSet[9];

        for(int i=0; i<9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            bins[i] = new HashSet<>();
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    int b = (i / 3) * 3 + j / 3;
                    if(!rows[i].add((int) board[i][j])) return false;
                    if(!cols[j].add((int) board[i][j])) return false;
                    if(!bins[b].add((int) board[i][j])) return false;
                }
            }
        }
        return true;
    }*/

    public boolean isValidSudoku(char[][] board){
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] bins = new boolean[9][9];

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    int n = board[i][j] - '1';
                    int b = (i / 3) * 3 + j / 3;
                    if(rows[i][n]) return false;
                    if(cols[j][n]) return false;
                    if(bins[b][n]) return false;

                    rows[i][n] = true;
                    cols[j][n] = true;
                    bins[b][n] = true;
                }
            }
        }
        return true;
    }
}
