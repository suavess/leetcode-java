package com.suave.面试题01_02_判定是否互为字符重排;
//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//
// 示例 1：
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true
//
//
// 示例 2：
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
//
//
// 说明：
//
//
// 0 <= len(s1) <= 100
// 0 <= len(s2) <= 100
//
//
// Related Topics 哈希表 字符串 排序 👍 132 👎 0

import java.util.Arrays;

/**
 * @author shunxin.jin
 * @date 2022/9/27 22:02
 */
public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        // 排序
//        int length = s1.length();
//        char[] chars1 = s1.toCharArray();
//        char[] chars2 = s2.toCharArray();
//        Arrays.sort(chars1);
//        Arrays.sort(chars2);
//        for (int i = 0; i < length; i++) {
//            if (chars1[i] != chars2[i]) {
//                return false;
//            }
//        }
//        return true;
        // 哈希表
        int[] bucket = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            bucket[s1.charAt(i)]++;
            bucket[s2.charAt(i)]--;
        }
        for (int i : bucket) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
