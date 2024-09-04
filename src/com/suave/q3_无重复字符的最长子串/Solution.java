package com.suave.q3_无重复字符的最长子串;
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 10⁴
// s 由英文字母、数字、符号和空格组成
//
//
// Related Topics 哈希表 字符串 滑动窗口 👍 8036 👎 0

import java.util.HashSet;
import java.util.Set;

/**
 * @author shunxin.jin
 * @date 2022/8/23 09:05
 */
public class Solution {

    private Set<Character> set = new HashSet<>();

    public int lengthOfLongestSubstring(String s) {
        // 暴力 超时..
//        for (int i = s.length(); i > 0; i--) {
//            for (int j = 0; j <= s.length() - i; j++) {
//                int len = 0;
//                for (int k = j; k < j + i; k++) {
//                    if (!set.add(s.charAt(k))) {
//                        break;
//                    }
//                    len++;
//                }
//                if (len == i) {
//                    return len;
//                }
//                set.clear();
//            }
//        }
//        return 1;
        // 递归 超时..
//        return findMax(s.toCharArray(), 0, s.length());
        //
        // int res = 0, right = 0;
        // char[] chars = s.toCharArray();
        // for (int i = 0; i < s.length(); i++) {
        //     if (i != 0) {
        //         // 左指针移动时移除前一位数字
        //         set.remove(chars[i - 1]);
        //     }
        //     // 移动右指针
        //     while (right <= s.length() - 1) {
        //         if (!set.add(chars[right])) {
        //             break;
        //         }
        //         right++;
        //     }
        //     res = Math.max(res, right - i);
        //     if (right == s.length() - 1) {
        //         break;
        //     }
        // }
        // return res;
        if (s.isEmpty()) {
            return 0;
        }
        int res = 1;
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int i = 0, j = 0;
        while (j++ < len - 1) {
            int index = s.indexOf(charArray[j], i);
            if (index != j) {
                i = index + 1;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

//    private int findMax(char[] arr, int left, int right) {
//        set.clear();
//        int len = 0;
//        for (int i = left; i < right; i++) {
//            if (!set.add(arr[i])) {
//                break;
//            }
//            len++;
//        }
//        if (len != right - left) {
//            return Math.max(findMax(arr, left + 1, right), findMax(arr, left, right - 1));
//        }
//        return len;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }
}
