package com.lewzerb.leetcode.s0001_0100;

import java.util.HashMap;
import java.util.Map;

public class Leetcode0008 {

    public static void main(String[] args) {
        Object[][] strInts = {
            {"42", 42},
            {"    -42", -42},
            {"4193 with words", 4193},
            {"words and 987", 0},
            {"-91283472332", -2147483648},
            {"+1", 1},
            {"2147483648", Integer.MAX_VALUE},
            {"9223372036854775808", Integer.MAX_VALUE},
        };


        Leetcode0008 leetcode0008 = new Leetcode0008();

        for (Object[] strInt : strInts){
            String str = (String) strInt[0];
            int num = (int) strInt[1];
            System.out.println((leetcode0008.myAtoi(str) == num) + ":" + leetcode0008.myAtoi(str));
        }
    }

    enum State{
        START, SIGNED, IN_NUM, END
    }

    public int myAtoi(String str){
        long res = 0;
        int signed = 1;
        Map<State, State[]> table = new HashMap<>();
        table.put(State.START, new State[]{State.START, State.SIGNED, State.IN_NUM, State.END});
        table.put(State.SIGNED, new State[]{State.END, State.END, State.IN_NUM, State.END});
        table.put(State.IN_NUM, new State[]{State.END, State.END, State.IN_NUM, State.END});
        table.put(State.END, new State[]{State.END, State.END, State.END, State.END});

        State state = State.START;
        for (char c : str.toCharArray()){
            state = table.get(state)[getCol(c)];
            switch (state){
                case IN_NUM:
                    res = res * 10 + (c - '0');
                    res = signed == 1 ? Math.min(res, Integer.MAX_VALUE) : Math.min(res, - (long)Integer.MIN_VALUE);
                    break;
                case SIGNED:
                    signed = c == '+' ? 1 : -1;
                    break;
            }
        }
        return (int) res * signed;
    }

    private int getCol(char c){
        if(c == ' '){
            return 0;
        }
        if(c == '+' || c == '-'){
            return 1;
        }
        if(Character.isDigit(c)){
            return 2;
        }
        return 3;
    }


}
