package com.suave.剑指OfferII032_有效的变位词;
//给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
//
// 注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。
//
//
//
// 示例 1:
//
//
//输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
//
//输入: s = "rat", t = "car"
//输出: false
//
// 示例 3:
//
//
//输入: s = "a", t = "a"
//输出: false
//
//
//
// 提示:
//
//
// 1 <= s.length, t.length <= 5 * 10⁴
// s and t 仅包含小写字母
//
//
//
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
//
//
//
//
// 注意：本题与主站 242 题相似（字母异位词定义不同）：https://leetcode-cn.com/problems/valid-anagram/
//
// Related Topics 哈希表 字符串 排序 👍 24 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author suave
 * @date 2022-07-10 19:19
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        // 哈希表
//        if (s.length() != t.length()) {
//            return false;
//        }
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
//        }
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            if (entry.getValue() != 0) {
//                return false;
//            }
//        }
//        return !s.equals(t);
        // 排序
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
    }
}
