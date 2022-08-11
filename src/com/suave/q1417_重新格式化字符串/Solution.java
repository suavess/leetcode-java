package com.suave.q1417_重新格式化字符串;
//给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
//
// 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
//
// 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
//
//
//
// 示例 1：
//
// 输入：s = "a0b1c2"
//输出："0a1b2c"
//解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
//
//
// 示例 2：
//
// 输入：s = "leetcode"
//输出：""
//解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
//
//
// 示例 3：
//
// 输入：s = "1229857369"
//输出：""
//解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
//
//
// 示例 4：
//
// 输入：s = "covid2019"
//输出："c2o0v1i9d"
//
//
// 示例 5：
//
// 输入：s = "ab123"
//输出："1a2b3"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 500
// s 仅由小写英文字母和/或数字组成。
//
//
// Related Topics 字符串 👍 24 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author suave
 * @date 2022-07-09 23:01
 */
public class Solution {
    public String reformat(String s) {
//        List<Character> nums = new ArrayList<>();
//        List<Character> strs = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
//                // 数字
//                nums.add(s.charAt(i));
//            } else {
//                strs.add(s.charAt(i));
//            }
//        }
//        if (nums.size() - strs.size() > 1 || nums.size() - strs.size() < -1) {
//            return "";
//        }
//        StringBuilder result = new StringBuilder();
//        if (nums.size() > strs.size()) {
//            for (int i = 0; i < nums.size(); i++) {
//                result.append(nums.get(i));
//                if (i < strs.size()) {
//                    result.append(strs.get(i));
//                }
//            }
//        } else {
//            for (int i = 0; i < strs.size(); i++) {
//                result.append(strs.get(i));
//                if (i < nums.size()) {
//                    result.append(nums.get(i));
//                }
//            }
//        }
//        return result.toString();
        char[] arr = s.toCharArray();
        String reformat = reformat(arr);
        if (!reformat.equals("")) {
            return reformat;
        }
        if (isNum(arr[0])) {
            // 第一个为数字,找一个字母替换一下
            for (int i = 1; i < arr.length; i++) {
                if (!isNum(arr[i])) {
                    char tmp = arr[0];
                    arr[0] = arr[i];
                    arr[i] = tmp;
                }
            }
        } else {
            // 第一个为字母,找一个数字替换一下
            for (int i = 1; i < arr.length; i++) {
                if (isNum(arr[i])) {
                    char tmp = arr[0];
                    arr[0] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        return reformat(arr);
    }

    private boolean isNum(char character) {
        return character >= '0' && character <= '9';
    }

    private String reformat(char[] arr){
        boolean lastIsNum = isNum(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (lastIsNum) {
                // 前一个字符是数字
                if (isNum(arr[i])) {
                    // 需要找一个字母进行替换
                    for (int j = i + 1; j < arr.length; j++) {
                        if (!isNum(arr[j])){
                            char tmp = arr[j];
                            arr[j] = arr[i];
                            arr[i] = tmp;
                        }
                    }
                    if (isNum(arr[i])){
                        // 替换后还是数字,说明后面没有字母了
                        return "";
                    }
                }
                lastIsNum = false;
            } else {
                // 前一个字符是在字母
                if (!isNum(arr[i])) {
                    // 需要找一个数字进行替换
                    for (int j = i + 1; j < arr.length; j++) {
                        if (isNum(arr[j])){
                            char tmp = arr[j];
                            arr[j] = arr[i];
                            arr[i] = tmp;
                        }
                    }
                    if (!isNum(arr[i])){
                        // 替换后还是字母,说明后面没有数字了
                        return "";
                    }
                }
                lastIsNum = true;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reformat("2019covid"));
    }
}
