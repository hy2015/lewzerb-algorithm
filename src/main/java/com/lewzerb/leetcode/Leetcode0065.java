package com.lewzerb.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode0065 {

    public static void main(String[] args) {
        Object[][] tests = {
            {".e1", false},
            {"1 4", false},
            {"0", true},
            {" 0.1 ", true},
            {"e9", false},
            {".1", true},
            {".", false},
            {"3.", true},
            {"3. ", true},
            {"+.8", true},
            {"+.", false}
        };
        Leetcode0065 leetcode0065 = new Leetcode0065();
        for(Object[] test : tests){
            String s = (String) test[0];
            boolean r = (boolean) test[1];
            System.out.println(leetcode0065.isNumber(s) == r);
        }
    }

    public boolean isNumber(String s){
        int[][] dfa = {
            {0, 1, 2, 3, -1, -1},
            {-1, -1, 2, 3, -1, -1},
            {8, -1, 2, 4, 5, -1},
            {-1, -1, 4, -1, -1, -1},
            {8, -1, 4, -1, 5, -1},
            {-1, 6, 7, -1, -1, -1},
            {-1, -1, 7, -1, -1, -1},
            {8, -1, 7, -1, -1, -1},
            {8, -1, -1, -1, -1, -1}
        };


        int status = 0;
        for(char c : s.toCharArray()){
            int idx = getCursor(c);
            int cur = dfa[status][idx];
            if(cur == -1){
                return false;
            }
            status = cur;
        }
        return status == 2 || status == 4 || status == 7 || status == 8;
    }

    enum NumberStatus {
        START(0), SIGNED(1), IN_DIGIT(2), ZERO_DECIMAL(3), IN_DECIMAL(4), START_EXPONENT(5), SIGNED_EXPONENT(6), IN_EXPONENT(7), END(8), ERROR(-1);
        int value;

        NumberStatus(int value){
            this.value = value;
        }
    }

    public boolean isNumber2(String s) {
        Map<NumberStatus, NumberStatus[]> numberStatusMap = new HashMap<>();
        numberStatusMap.put(NumberStatus.START,
            new NumberStatus[]{NumberStatus.START, NumberStatus.SIGNED, NumberStatus.IN_DIGIT, NumberStatus.ZERO_DECIMAL, NumberStatus.ERROR, NumberStatus.ERROR});
        numberStatusMap.put(NumberStatus.SIGNED,
            new NumberStatus[]{NumberStatus.ERROR, NumberStatus.ERROR, NumberStatus.IN_DIGIT, NumberStatus.ZERO_DECIMAL, NumberStatus.ERROR, NumberStatus.ERROR});
        numberStatusMap.put(NumberStatus.IN_DIGIT,
            new NumberStatus[]{NumberStatus.END, NumberStatus.ERROR, NumberStatus.IN_DIGIT, NumberStatus.IN_DECIMAL, NumberStatus.START_EXPONENT, NumberStatus.ERROR});
        numberStatusMap.put(NumberStatus.ZERO_DECIMAL,
            new NumberStatus[]{NumberStatus.ERROR, NumberStatus.ERROR, NumberStatus.IN_DECIMAL, NumberStatus.ERROR, NumberStatus.ERROR, NumberStatus.ERROR});
        numberStatusMap.put(NumberStatus.IN_DECIMAL,
            new NumberStatus[]{NumberStatus.END, NumberStatus.ERROR, NumberStatus.IN_DECIMAL, NumberStatus.ERROR, NumberStatus.START_EXPONENT, NumberStatus.ERROR});
        numberStatusMap.put(NumberStatus.START_EXPONENT,
            new NumberStatus[]{NumberStatus.ERROR, NumberStatus.SIGNED_EXPONENT, NumberStatus.IN_EXPONENT, NumberStatus.ERROR, NumberStatus.ERROR, NumberStatus.ERROR});
        numberStatusMap.put(NumberStatus.SIGNED_EXPONENT,
            new NumberStatus[]{NumberStatus.ERROR, NumberStatus.ERROR, NumberStatus.IN_EXPONENT, NumberStatus.ERROR, NumberStatus.ERROR, NumberStatus.ERROR});
        numberStatusMap.put(NumberStatus.IN_EXPONENT,
            new NumberStatus[]{NumberStatus.END, NumberStatus.ERROR, NumberStatus.IN_EXPONENT, NumberStatus.ERROR, NumberStatus.ERROR, NumberStatus.ERROR});
        numberStatusMap.put(NumberStatus.END,
            new NumberStatus[]{NumberStatus.END, NumberStatus.ERROR, NumberStatus.ERROR, NumberStatus.ERROR, NumberStatus.ERROR, NumberStatus.ERROR});

        NumberStatus cur = NumberStatus.START;

        for(char c : s.toCharArray()){
            int idx = getCursor(c);
            NumberStatus next = numberStatusMap.get(cur)[idx];
            if(next.equals(NumberStatus.ERROR)){
                return false;
            }
            cur = next;
        }

        Set<NumberStatus> isNumberSet = new HashSet<>();
        isNumberSet.add(NumberStatus.IN_DIGIT);
        isNumberSet.add(NumberStatus.IN_EXPONENT);
        isNumberSet.add(NumberStatus.IN_DECIMAL);
        isNumberSet.add(NumberStatus.END);
        if(isNumberSet.contains(cur)){
            return true;
        }else {
            return false;
        }
    }


    private int getCursor(char c){
        if(c == ' '){
            return 0;
        }
        if(c == '+' || c == '-') {
            return 1;
        }
        if(c >= '0' && c<= '9'){
            return 2;
        }
        if(c == '.'){
            return 3;
        }
        if(c == 'e'){
            return 4;
        }
        return 5;
    }


}
