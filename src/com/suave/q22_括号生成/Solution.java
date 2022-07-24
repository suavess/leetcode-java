package com.suave.q22_括号生成;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
//
// Related Topics 字符串 动态规划 回溯 👍 2768 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @author suave
 * @date 2022-07-24 20:13
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, new char[2 * n], n, n);
        return result;
    }

    private void dfs(List<String> result, char[] chars, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(new String(chars));
            return;
        }
        if (left > 0) {
            chars[chars.length - left - right] = '(';
            dfs(result, chars, left - 1, right);
        }
        if (right > left) {
            chars[chars.length - left - right] = ')';
            dfs(result, chars, left, right - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }

}
