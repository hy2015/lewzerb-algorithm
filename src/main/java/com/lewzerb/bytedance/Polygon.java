package com.lewzerb.bytedance;

public class Polygon {

    public static void main(String[] args) {
        double[][] polygon = {
            {2, 1}, {2, 4},
            {4, 4}, {4, 8},
            {10, 8}, {10, 1}
        };

        int k = 8;

        System.out.println(getPerimeter(polygon));
    }

    public static double[][] getNPartialPoint(double[][] polygon, int k){
        double len = getPerimeter(polygon) / k;
        return null;
    }


    public static double getPerimeter(double[][] points){
        double perimeter = 0;
        for(int i = 0; i < points.length; i++){
            double[] start = points[i];
            double[] end;
            if(i==points.length - 1){
                end = points[0];
            }else {
                end = points[i+1];
            }
            perimeter += calculateLength(start, end);
        }
        return perimeter;
    }

    public static double calculateLength(double[] start, double[] end){
        if(start.length != 2 || end.length != 2) return 0;

        if(start[0] == end[0]) {
            return Math.abs(end[1] - start[1]);
        }else {
            return Math.abs(end[0] - start[0]);
        }
    }

}
