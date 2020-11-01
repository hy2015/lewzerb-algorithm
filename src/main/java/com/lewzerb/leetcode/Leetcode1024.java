package com.lewzerb.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode1024 {

    public static void main(String[] args) {
        int[][][] clipsGroup = {
                {{8,10},{17,39},{18,19},{8,16},{13,35},{33,39},{11,19},{18,35}},
                {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}},
                {{3,12},{7,14},{9,14},{12,15},{0,9},{4,14},{2,7},{1,11}}
        };
        int[] Ts = {20, 10, 10};
//        int[][] clips = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
//        int[][] clips = {{3,12},{7,14},{9,14},{12,15},{0,9},{4,14},{2,7},{1,11}};

        Leetcode1024 leetcode1024 = new Leetcode1024();
        for (int i=0; i<clipsGroup.length; i++) {
            int[][] clips = clipsGroup[i];
            int T = Ts[i];
            System.out.println(leetcode1024.videoStitching(clips, T));
        }

    }

    /*public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, Comparator.comparingInt(v -> v[0]));

        int lastMax = clips[0][0];
        int begin = lastMax;

        if(begin > 0){
            return -1;
        }
        int curMax = Integer.MIN_VALUE;
        int beginIndex = 0;
        int count = 0;


        for(int i=0; i<clips.length;){
            int[] clip = clips[i];
            int L = clip[0], R = clip[1];

            if(lastMax >= L){
                curMax = Math.max(R, curMax);

                if(curMax - begin >= T || i == clips.length - 1) {
                    count++;
                    break;
                }
                i++;
            }else {
                if(i == beginIndex){
                    count = -1;
                    break;
                }
                lastMax = curMax;
                beginIndex = i;
                count++;
            }
        }
        if(curMax - begin < T){
            return -1;
        }else {
            return count;
        }
    }*/

    public int videoStitching(int[][] clips, int T){
        int[] maxR = new int[T];

        int last = 0, count = 0, pre = 0;
        for(int[] clip : clips){
            if(clip[0] < T){
                maxR[clip[0]] = Math.max(maxR[clip[0]], clip[1]);
            }
        }

        for(int i=0; i<T; i++){
            last = Math.max(last, maxR[i]);
            if(i == last){
                return -1;
            }
            if(i == pre){
                count++;
                pre = last;
            }
        }
        return count;
    }
}
