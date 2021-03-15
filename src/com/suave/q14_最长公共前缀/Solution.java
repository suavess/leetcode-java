package com.suave.q14_最长公共前缀;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 0 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串
// 👍 1504 👎 0

/**
 * @author Suave
 * @author 2021/3/15 7:19 下午
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String small = strs[0];
        for (String str : strs) {
            if (str.length() < small.length()) {
                small = str;
            }
        }
        for (int length = small.length(); length > 0; length--) {
            boolean flag = true;
            for (String str : strs) {
                if (!str.startsWith(small.substring(0, length))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return small.substring(0, length);
            }
        }
        return "";
    }
}
