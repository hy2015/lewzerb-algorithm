package com.lewzerb.leetcode;

import java.util.Arrays;

public class Leetcode0922 {

    public static void main(String[] args) {
        int[] A = {2,3,1,1,4,0,0,4,3,3};
        Leetcode0922 leetcode0922 = new Leetcode0922();
        int[] B = leetcode0922.sortArrayByParityII(A);
        System.out.println(Arrays.toString(B));
    }

    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }


    public int[] sortArrayByParityII2(int[] A) {
        int even = 0, odd = 0;
        int[] B = new int[A.length];
        for (int a : A) {
            if ((a & 1) == 0) {
                B[2 * even] = a;
                even++;
            }else {
                B[2 * odd + 1] = a;
                odd++;
            }
        }
        return B;
    }
}
