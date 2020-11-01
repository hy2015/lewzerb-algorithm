package com.lewzerb.leetcode;

public class Leetcode0062 {

    public static void main(String[] args) {
        Leetcode0062 leetcode0062 = new Leetcode0062();
        System.out.println(leetcode0062.uniquePaths(10, 10));
    }

    public int uniquePaths(int m, int n) {
        int tmp;
        if(m<n){
            tmp = n;
            n = m;
            m = tmp;
        }

        long c1=1, c2=1;
        for(int i=1; i<=n-1; i++){
            c1 *= i;
            c2 *=(m+n-i-1);
        }
        return (int) (c2/c1);
    }
}
