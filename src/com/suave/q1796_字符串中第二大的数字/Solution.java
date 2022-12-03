package com.suave.q1796_字符串中第二大的数字;
//给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
//
// 混合字符串 由小写英文字母和数字组成。
//
//
//
// 示例 1：
//
//
//输入：s = "dfa12321afd"
//输出：2
//解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
//
//
// 示例 2：
//
//
//输入：s = "abc1111"
//输出：-1
//解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 500
// s 只包含小写英文字母和（或）数字。
//
//
// Related Topics 哈希表 字符串
// 👍 40 👎 0

/**
 * @author suave
 * @date 2022-12-03 19:45
 */
public class Solution {
    public int secondHighest(String s) {
        int res = -1, max = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int tmp = s.charAt(i) - '0';
                if (tmp == max) {
                    continue;
                }
                if (tmp > max) {
                    res = max;
                    max = tmp;
                } else if (tmp > res) {
                    res = tmp;
                }
            }
        }
        return res;
    }
}
