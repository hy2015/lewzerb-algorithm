package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0037 {

    /**
     * 输入：
     * [
     * [".",".","9","7","4","8",".",".","."],
     * ["7",".",".",".",".",".",".",".","."],
     * [".","2",".","1",".","9",".",".","."],
     * [".",".","7",".",".",".","2","4","."],
     * [".","6","4",".","1",".","5","9","."],
     * [".","9","8",".",".",".","3",".","."],
     * [".",".",".","8",".","3",".","2","."],
     * [".",".",".",".",".",".",".",".","6"],
     * [".",".",".","2","7","5","9",".","."]]
     * 预期：
     * [
     * ["5","1","9","7","4","8","6","3","2"],
     * ["7","8","3","6","5","2","4","1","9"],
     * ["4","2","6","1","3","9","8","7","5"],
     * ["3","5","7","9","8","6","2","4","1"],
     * ["2","6","4","3","1","7","5","9","8"],
     * ["1","9","8","5","2","4","3","6","7"],
     * ["9","7","5","8","6","3","1","2","4"],
     * ["8","3","2","4","9","1","7","5","6"],
     * ["6","4","1","2","7","5","9","8","3"]
     * ]
     * @param args
     */

    public static void main(String[] args) {
       /* char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };*/

        char[][] board = {
            {'.','.','9','7','4','8','.','.','.'},
            {'7','.','.','.','.','.','.','.','.'},
            {'.','2','.','1','.','9','.','.','.'},
            {'.','.','7','.','.','.','2','4','.'},
            {'.','6','4','.','1','.','5','9','.'},
            {'.','9','8','.','.','.','3','.','.'},
            {'.','.','.','8','.','3','.','2','.'},
            {'.','.','.','.','.','.','.','.','6'},
            {'.','.','.','2','7','5','9','.','.'}
        };

        Leetcode0037 leetcode0037 = new Leetcode0037();
        leetcode0037.solveSudoku(board);

        for(char[] slice: board){
            String join = String.join(" ", new String(slice).split(""));
            System.out.println("["+join+"]");
        }
    }


    short[] rows = new short[9];
    short[] cols = new short[9];
    short[][] cells = new short[3][3];

    public void solveSudoku(char[][] board) {

        int count = 0;

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                count += (board[i][j] == '.') ? 1 : 0;
                if(board[i][j] == '.')continue;
                int n = board[i][j] - '1';
                rows[i] |= (1 << n);
                cols[j] |= (1 << n);
                cells[i/3][j/3] |= (1 << n);
            }
        }
        dfs(board, count);
    }

    public boolean dfs(char[][] board, int count){
        if(count == 0)return true;

        int[] next = getNext(board);
        int candidates = getCandidates(next[0], next[1]);

        for(int n=0; n<9; n++){
            int bitTest = candidates & 1;
            candidates = candidates >> 1;
            if(bitTest != 1) continue;

            fillNum(next[0], next[1], n, true);
            board[next[0]][next[1]] = Character.forDigit(1+n, 10);
            if(dfs(board, count - 1)) return true;
            board[next[0]][next[1]] = '.';
            fillNum(next[0], next[1], n, false);
        }
        return false;
    }

    public void fillNum(int x, int y, int n, boolean fillFlag){
        if(fillFlag){
            rows[x] |= 1 << n;
            cols[y] |= 1 << n;
            cells[x/3][y/3] |= 1 << n;
        }else {
            rows[x] &= ~(1 << n);
            cols[y] &= ~(1 << n);
            cells[x/3][y/3] &= ~(1 << n);
        }
    }

    public int[] getNext(char[][] board){
        int minCount = 10;
        int[] ret = new int[2];
        for(int i=0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.')continue;
                int candidates = getCandidates(i, j);
                int count = countCandidates(candidates);
                if(count >= minCount)continue;
                minCount = count;
                ret[0] = i;
                ret[1] = j;
            }
        }
        return ret;
    }

    public int getCandidates(int x, int y){
        return ~(rows[x] | cols[y] | cells[x/3][y/3]);
    }

    public int countCandidates(int cur){
        int count = 0;
        for(int i=0; i<9; i++){
            count += cur & 1;
            cur = cur >> 1;
        }
        return count;
    }

}
