package com.suave.q520_检测大写字母;
//我们定义，在以下情况时，单词的大写用法是正确的：
//
//
// 全部字母都是大写，比如 "USA" 。
// 单词中所有字母都不是大写，比如 "leetcode" 。
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
//
//
// 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：word = "USA"
//输出：true
//
//
// 示例 2：
//
//
//输入：word = "FlaG"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= word.length <= 100
// word 由小写和大写英文字母组成
//
//
// Related Topics 字符串 👍 206 👎 0

/**
 * @author suave
 * @date 2022-07-10 18:32
 */
public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.charAt(0) <= 'Z') {
            // 首字母为大写,则只有后续都为大写或者后续都为小写才返回true
            boolean allBig = true;
            boolean allSmall = true;
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) <= 'Z') {
                    // 大写
                    allSmall = false;
                    if (!allBig) {
                        return false;
                    }
                } else {
                    // 小写
                    allBig = false;
                    if (!allSmall) {
                        return false;
                    }
                }
            }
            return true;
        }
        // 后续有小写则直接返回
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) <= 'Z') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().detectCapitalUse("ggg"));
    }
}
