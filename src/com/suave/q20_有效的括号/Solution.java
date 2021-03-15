package com.suave.q20_有效的括号;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2235 👎 0

import java.util.Stack;

/**
 * @author Suave
 * @author 2021/3/15 10:25 下午
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        String[] split = s.split("");
        for (String value : split) {
            if ("[".equals(value) || "(".equals(value) || "{".equals(value)) {
                stack.push(value);
            } else {
                if (stack.size() == 0){
                    return false;
                }
                String pop = stack.pop();
                if ("]".equals(value) && "[".equals(pop)) {
                    continue;
                }
                if ("}".equals(value) && "{".equals(pop)) {
                    continue;
                }
                if (")".equals(value) && "(".equals(pop)) {
                    continue;
                }
                return false;
            }
        }
        return stack.size() <= 0;
    }

    public static void main(String[] args) {
        new Solution().isValid("]");
    }
}
