package com.lewzerb.leetcode.s0001_0100;

import java.util.Arrays;

public class Leetcode0066 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] newDigits = new int[n +1];
        int sum = digits[n - 1] + 1;
        int carry = sum / 10;
        newDigits[n] = sum % 10;
        for(int i=n-2; i>=0 ; i--){
            newDigits[i+1] = carry + digits[i];
            carry = newDigits[i+1] / 10;
            newDigits[i+1] %= 10;
        }
        newDigits[0] = carry;
        if(newDigits[0] > 0){
            return newDigits;
        }else {
            return Arrays.copyOfRange(newDigits, 1, newDigits.length);
        }
    }
}
