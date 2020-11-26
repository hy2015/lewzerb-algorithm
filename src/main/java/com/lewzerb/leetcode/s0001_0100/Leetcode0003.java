package com.lewzerb.leetcode.s0001_0100;

import java.util.HashMap;
import java.util.Map;

public class Leetcode0003 {

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "aab";
        String s5 = "dvdf";
        String s6 = "aabaab!bb";

        Leetcode0003 leetcode0003 = new Leetcode0003();
        System.out.println(leetcode0003.lengthOfLongestSubstring(s5) == 3);
        System.out.println(leetcode0003.lengthOfLongestSubstring(s6) == 3);
        System.out.println(leetcode0003.lengthOfLongestSubstring(s1) == 3);
        System.out.println(leetcode0003.lengthOfLongestSubstring(s2) == 1);
        System.out.println(leetcode0003.lengthOfLongestSubstring(s3) == 3);
        System.out.println(leetcode0003.lengthOfLongestSubstring(s4) == 2);
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3 
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

}
