package com.lewzerb.leetcode.s0001_0100;

import java.util.ArrayList;
import java.util.List;

public class Leetcode0006 {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     * 示例 1:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     *
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        Leetcode0006 leetcode0006 = new Leetcode0006();
        String test = "LEETCODEISHIRING";
        System.out.println(leetcode0006.convert(test, 3));
//        String test = "AB";
//        System.out.println(leetcode0006.convert(test, 1));
    }

    public String convert(String s, int numRows) {
        if(numRows < 2) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            rows.add(new StringBuilder());
        }

        int i = 0, flag = -1;

        for (char c: s.toCharArray()) {
            rows.get(i).append(c);
            if(i==0 || i==numRows-1) flag=-flag;
            i+=flag;
        }

        StringBuilder builder = new StringBuilder();
        for (StringBuilder row : rows) builder.append(row);
        return builder.toString();
    }
}
