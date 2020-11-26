package com.lewzerb.leetcode.s0001_0100;

import java.util.ArrayList;
import java.util.List;

public class Leetcode0054 {


    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 0},
            {4, 5, 6, 10},
            {7, 8, 9, 20}
        };

        Leetcode0054 leetcode0054 = new Leetcode0054();
        for (Integer i : leetcode0054.spiralOrder(matrix)) {
            System.out.print(i + " ");
        }
    }

    enum Direct{
        UP, DOWN, RIGHT, LEFT
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length==0 || matrix[0].length == 0) return res;
        int steps = 0;
        int x = 0, y = 0, xEdge=matrix[0].length-1, yEdge=matrix.length-1;
        Direct direct = Direct.RIGHT;
        int circle = 0;

        while (steps < matrix[0].length * matrix.length){
            res.add(matrix[y][x]);

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

        return res;
    }
}
