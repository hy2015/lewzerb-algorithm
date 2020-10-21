package com.lewzerb.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode0043 {

    public static void main(String[] args) {
        Leetcode0043 leetcode0043 = new Leetcode0043();

        System.out.println(leetcode0043.multiply("896686", "8261335908"));
        System.out.println(leetcode0043.multiply("2925", "4787"));
        System.out.println(leetcode0043.multiply("999", "999"));
//        System.out.println(leetcode0043.multiply("1234", "4321"));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int[] res = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';

            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';

                res[i + j + 1] += n1 * n2;
            }
        }

        for (int i = num1.length() + num2.length() - 1; i > 0; i--) {
            res[i - 1] += res[i] / 10;
            res[i] %= 10;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0)
                continue;
            builder.append(res[i]);
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }


    /*public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int[] res = new int[num1.length() + num2.length()];

        for(int i=num1.length() - 1; i>=0; i--){
            int n1 = num1.charAt(i) - '0';

            for(int j=num2.length() - 1; j>=0; j--){
                int n2 = num2.charAt(j) - '0';

                int sum = (res[i+j+1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<res.length; i++){
            if(i==0 && res[i] == 0)continue;
            builder.append(res[i]);
        }

        return builder.length() == 0 ? "0": builder.toString();
    }*/

    /*public String multiply(String num1, String num2) {
        int[][] sum = new int[num2.length()][num1.length()+num2.length()];

        int carry = 0;
        for(int i=0; i<num2.length(); i++){
            for(int j=0; j<num1.length(); j++){
                char a = num2.charAt(i);
                char b = num1.charAt(j);

                int res = (a - '0') * (b - '0');
                sum[i][i+j] += res / 10;

                carry = sum[i][i+j] / 10;
                if(carry >=1) {
                    sum[i][i+j-1] += carry;
                    sum[i][i+j] %= 10;
                }

                sum[i][i+j+1] += res % 10;
            }
        }


        int c2;
        int high = 0;
        int low = 0;
        StringBuilder builder = new StringBuilder();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int j=0; j<num1.length()+num2.length(); j++){
            int tmp = 0;
            for(int i=0; i<num2.length(); i++){
                tmp += sum[i][j];
            }
            high = tmp / 10 + low;
            low = tmp % 10;

            c2 = high / 10;

            Deque<Integer> last = new ArrayDeque<>();
            while (c2 >= 1){
                int pre = deque.removeLast();
                pre += c2;

                last.addFirst(pre % 10);
                c2 = pre / 10;
            }
            if(last.size() > 0){
                for(Integer i: last){
                    deque.addLast(i);
                }
            }

            deque.addLast(high % 10);
        }
        deque.addLast(low);

        boolean first = true;
        for(Integer bit : deque){
            if(first && bit == 0) continue;
            first = false;
            builder.append(bit);
        }
        return builder.length() == 0 ? "0": builder.toString();
    }*/
}
