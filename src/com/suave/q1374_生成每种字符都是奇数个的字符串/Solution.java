package com.suave.q1374_生成每种字符都是奇数个的字符串;
//给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
//
// 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
//
//
//
// 示例 1：
//
// 输入：n = 4
//输出："pppz"
//解释："pppz" 是一个满足题目要求的字符串，因为 'p' 出现 3 次，且 'z' 出现 1 次。当然，还有很多其他字符串也满足题目要求，比如：
//"ohhh" 和 "love"。
//
//
// 示例 2：
//
// 输入：n = 2
//输出："xy"
//解释："xy" 是一个满足题目要求的字符串，因为 'x' 和 'y' 各出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ag" 和 "ur"。
//
//
//
// 示例 3：
//
// 输入：n = 7
//输出："holasss"
//
//
//
//
// 提示：
//
//
// 1 <= n <= 500
//
//
// Related Topics 字符串 👍 58 👎 0

/**
 * @author suave
 * @date 2022-08-01 21:24
 */
public class Solution {
    public String generateTheString(int n) {
        char[] chars = new char[n];
        if (n % 2 == 0) {
            // 偶数,返回1一个字母和n-1个其他字母即可
            for (int i = 0; i < n - 1; i++) {
                chars[i] = 'a';
            }
            chars[n - 1] = 'b';
        } else {
            // 奇数,全返回同一个字母即可
            for (int i = 0; i < n; i++) {
                chars[i] = 'a';
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateTheString(53));
    }
}
