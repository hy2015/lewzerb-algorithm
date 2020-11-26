package com.lewzerb.leetcode.s0001_0100;


public class Leetcode0059 {
    
    enum Direct{
        UP, DOWN, RIGHT, LEFT
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int steps = 0;
        int x = 0, y = 0, xEdge=matrix[0].length-1, yEdge=matrix.length-1;
        Direct direct = Direct.RIGHT;
        int circle = 0;

        while (steps < matrix[0].length * matrix.length){
            matrix[y][x] = steps+1;

            if(x==xEdge-circle && direct.equals(Direct.RIGHT)){
                direct = Direct.DOWN;
            }

            if(y==yEdge-circle && direct.equals(Direct.DOWN)){
                direct = Direct.LEFT;
            }

            if(x==circle && direct.equals(Direct.LEFT)){
                direct = Direct.UP;
                circle++;
            }

            if(y==circle && direct.equals(Direct.UP)){
                direct = Direct.RIGHT;
            }

            switch (direct){
                case RIGHT:
                    x++;
                    break;
                case DOWN:
                    y++;
                    break;
                case LEFT:
                    x--;
                    break;
                case UP:
                    y--;
                    break;
            }
            steps++;
        }
        return matrix;
    }

}
