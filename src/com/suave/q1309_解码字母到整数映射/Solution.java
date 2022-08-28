package com.suave.q1309_解码字母到整数映射;
//给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
//
//
// 字符（'a' - 'i'）分别用（'1' - '9'）表示。
// 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
//
//
// 返回映射之后形成的新字符串。
//
// 题目数据保证映射始终唯一。
//
//
//
// 示例 1：
//
//
//输入：s = "10#11#12"
//输出："jkab"
//解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
//
//
// 示例 2：
//
//
//输入：s = "1326#"
//输出："acz"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s[i] 只包含数字（'0'-'9'）和 '#' 字符。
// s 是映射始终存在的有效字符串。
//
//
// Related Topics 字符串 👍 65 👎 0

/**
 * @author suave
 * @date 2022-08-28 20:45
 */
public class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' || s.charAt(i) == '2') {
                // 判断i+2是否为井号
                if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                    //为井号
                    int limit = (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0';
                    sb.append((char) ('a' + limit - 1));
                    i += 2;
                    continue;
                }
            }
            sb.append((char) ('a' + s.charAt(i) - '0' - 1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().freqAlphabets("1326#"));
    }
}
