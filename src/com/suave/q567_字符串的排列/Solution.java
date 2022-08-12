package com.suave.q567_字符串的排列;
//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
// 换句话说，s1 的排列之一是 s2 的 子串 。
//
//
//
// 示例 1：
//
//
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
//
//
// 示例 2：
//
//
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= s1.length, s2.length <= 10⁴
// s1 和 s2 仅包含小写字母
//
//
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 736 👎 0

import java.util.Arrays;

/**
 * @author shunxin.jin
 * @date 2022/8/12 11:02
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
//        int left = 0, right = s1.length() - 1;
//        char[] s1Chars = s1.toCharArray();
//        Arrays.sort(s1Chars);
//        char[] s2Chars = new char[s1.length()];
//        while (right < s2.length()) {
//            if (s1.indexOf(s2.charAt(left)) < 0 || s1.indexOf(s2.charAt(right)) < 0) {
//                left++;
//                right++;
//                continue;
//            }
//            s2.getChars(left, right + 1, s2Chars, 0);
//            Arrays.sort(s2Chars);
//            if (Arrays.equals(s1Chars, s2Chars)){
//                return true;
//            }
//            left++;
//            right++;
//        }
//        return false;
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("a", "b"));
    }
}
