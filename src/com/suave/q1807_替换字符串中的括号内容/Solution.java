package com.suave.q1807_替换字符串中的括号内容;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 给你一个字符串 s ，它包含一些括号对，每个括号中包含一个 非空 的键。
//
//
// 比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。
//
//
// 你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，其中 knowledge[i] = [keyi, valuei] ，表示键
// keyi 对应的值为 valuei 。
//
// 你需要替换 所有 的括号对。当你替换一个括号对，且它包含的键为 keyi 时，你需要：
//
//
// 将 keyi 和括号用对应的值 valuei 替换。
// 如果从 knowledge 中无法得知某个键对应的值，你需要将 keyi 和括号用问号 "?" 替换（不需要引号）。
//
//
// knowledge 中每个键最多只会出现一次。s 中不会有嵌套的括号。
//
// 请你返回替换 所有 括号对后的结果字符串。
//
//
//
// 示例 1：
//
//
// 输入：s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
// 输出："bobistwoyearsold"
// 解释：
// 键 "name" 对应的值为 "bob" ，所以将 "(name)" 替换为 "bob" 。
// 键 "age" 对应的值为 "two" ，所以将 "(age)" 替换为 "two" 。
//
//
// 示例 2：
//
//
// 输入：s = "hi(name)", knowledge = [["a","b"]]
// 输出："hi?"
// 解释：由于不知道键 "name" 对应的值，所以用 "?" 替换 "(name)" 。
//
//
// 示例 3：
//
//
// 输入：s = "(a)(a)(a)aaa", knowledge = [["a","yes"]]
// 输出："yesyesyesaaa"
// 解释：相同的键在 s 中可能会出现多次。
// 键 "a" 对应的值为 "yes" ，所以将所有的 "(a)" 替换为 "yes" 。
// 注意，不在括号里的 "a" 不需要被替换。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// 0 <= knowledge.length <= 10⁵
// knowledge[i].length == 2
// 1 <= keyi.length, valuei.length <= 10
// s 只包含小写英文字母和圆括号 '(' 和 ')' 。
// s 中每一个左圆括号 '(' 都有对应的右圆括号 ')' 。
// s 中每对括号内的键都不会为空。
// s 中不会有嵌套括号对。
// keyi 和 valuei 只包含小写英文字母。
// knowledge 中的 keyi 不会重复。
//
//
// Related Topics 数组 哈希表 字符串
// 👍 64 👎 0

/**
 * @author shunxin.jin
 * @date 2023/1/16 09:40
 */
public class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>(knowledge.size() * 3 / 4 + 1);
        for (List<String> strings : knowledge) {
            map.put(strings.get(0), strings.get(1));
        }
        StringBuilder result = new StringBuilder(s.length());
        StringBuilder tmp = new StringBuilder();
        boolean pull = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 入栈
                pull = true;
            } else if (s.charAt(i) == ')') {
                // 出栈
                String value = map.get(tmp.toString());
                result.append(value == null ? '?' : value);
                pull = false;
                tmp.delete(0, tmp.length());
            } else {
                if (pull) {
                    tmp.append(s.charAt(i));
                } else {
                    result.append(s.charAt(i));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().evaluate("(name)is(age)yearsold", Arrays.asList(Arrays.asList("name", "bob"), Arrays.asList("age", "two"))));
    }
}
