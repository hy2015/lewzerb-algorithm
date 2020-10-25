package com.lewzerb.leetcode;

public class Leetcode0079 {

    /**
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     *  
     *
     * 示例:
     *
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     *
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String s1 = "ABCCED";
        String s2 = "SEE";
        String s3 = "ABCB";

        Leetcode0079 leetcode0079 = new Leetcode0079();

        System.out.println(leetcode0079.exist(board, s1));
        System.out.println(leetcode0079.exist(board, s2));
        System.out.println(leetcode0079.exist(board, s3));

    }

    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board[0].length; i++){
            for(int j=0; j<board.length; j++){
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int x, int y, int z){
        if(z >= word.length()){
            return true;
        }

        if(x < 0 || x >= board[0].length || y < 0 || y >= board.length){
            return false;
        }
        if(word.charAt(z) != board[y][x]){
            return false;
        }

        board[y][x] += 256;
        boolean result = dfs(board, word, x + 1, y, z + 1) ||
                dfs(board, word, x - 1, y, z + 1) ||
                dfs(board, word, x, y + 1, z + 1) ||
                dfs(board, word, x, y - 1, z + 1);
        board[y][x] -= 256;
        return result;
    }
}
