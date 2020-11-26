package com.lewzerb.leetcode.s0001_0100;

public class Leetcode0044 {

    /**
     * 给定一个字符串(s) 和一个字符模式(p) ，实现一个支持'?'和'*'的通配符匹配。
     *
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     * 两个字符串完全匹配才算匹配成功。
     *
     * 说明:
     *
     * s可能为空，且只包含从a-z的小写字母。
     * p可能为空，且只包含从a-z的小写字母，以及字符?和*。
     * 示例1:
     *
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * 示例2:
     *
     * 输入:
     * s = "aa"
     * p = "*"
     * 输出: true
     * 解释:'*' 可以匹配任意字符串。
     * 示例3:
     *
     * 输入:
     * s = "cb"
     * p = "?a"
     * 输出: false
     * 解释:'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
     * 示例4:
     *
     * 输入:
     * s = "adceb"
     * p = "*a*b"
     * 输出: true
     * 解释:第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
     * 示例5:
     *
     * 输入:
     * s = "acdcb"
     * p = "a*c?b"
     * 输出: false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/wildcard-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        String[][] tests = {
            {"aaa", "*"},
            {"cb", "?a"},
            {"adceb", "*a*b"},
            {"acdcb", "a*c?b"}
        };
        Leetcode0044 leetcode0044 = new Leetcode0044();
        for(String[] test: tests){
            System.out.println(leetcode0044.isMatch(test[0], test[1]));
        }
    }

    public boolean isMatch(String s, String p) {
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();

        boolean[][] dp = new boolean[sc.length+1][pc.length+1];
        dp[0][0] = true;

        for(int i=1; i<=pc.length; i++){
            if(pc[i-1] == '*'){
                dp[0][i] = true;
            }else {
                break;
            }
        }

        for(int i=1; i<=sc.length; i++){
            for(int j=1; j<=pc.length; j++){
                if(pc[j-1] == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else if(pc[j-1] == '?' || sc[i-1] == pc[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[sc.length][pc.length];
    }
}
