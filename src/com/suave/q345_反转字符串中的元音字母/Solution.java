package com.suave.q345_反转字符串中的元音字母;
//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
//
//
//
// 示例 1：
//
//
//输入：s = "hello"
//输出："holle"
//
//
// 示例 2：
//
//
//输入：s = "leetcode"
//输出："leotcede"
//
//
//
// 提示：
//
//
// 1 <= s.length <= 3 * 10⁵
// s 由 可打印的 ASCII 字符组成
//
//
// Related Topics 双指针 字符串 👍 260 👎 0

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author suave
 * @date 2022-08-09 23:19
 */
public class Solution {
    public String reverseVowels(String s) {
        String vowel = "aeiouAEIOU";
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            if (vowel.indexOf(chars[i]) >= 0 && vowel.indexOf(chars[j]) >= 0) {
                // 都是元音字母,交换位置
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
                continue;
            }
            if (vowel.indexOf(chars[i]) < 0){
                i++;
            }
            if (vowel.indexOf(chars[j]) < 0){
                j--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("leetcode"));
    }
}
