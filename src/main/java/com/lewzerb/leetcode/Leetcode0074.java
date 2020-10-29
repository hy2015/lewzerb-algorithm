package com.lewzerb.leetcode;

public class Leetcode0074 {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        Leetcode0074 leetcode0074 = new Leetcode0074();
        System.out.println(leetcode0074.searchMatrix(matrix, 30));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int left = 0, right =  matrix[0].length - 1;
        int row = findRow(matrix, target);
        if(row == matrix.length) return false;
        while (left <= right){
            int mid = (left + right) / 2;
            if(matrix[row][mid] < target){
                left = mid + 1;
            }else if(matrix[row][mid] > target){
                right = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }

    private int findRow(int[][] matrix, int target){
        int up = 0, down = matrix.length - 1;
        int n = matrix[0].length - 1;

        while (up <= down){
            int mid = (up + down) / 2;
            if(matrix[mid][n] < target){
                up = mid + 1;
            }else if(matrix[mid][n] > target){
                down = mid - 1;
            }else {
                return mid;
            }
        }
        return up;
    }
}
