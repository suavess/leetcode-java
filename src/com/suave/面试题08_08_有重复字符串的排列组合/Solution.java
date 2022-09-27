package com.suave.面试题08_08_有重复字符串的排列组合;
//有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
//
// 示例1:
//
//  输入：S = "qqe"
// 输出：["eqq","qeq","qqe"]
//
//
// 示例2:
//
//  输入：S = "ab"
// 输出：["ab", "ba"]
//
//
// 提示:
//
//
// 字符都是英文字母。
// 字符串长度在[1, 9]之间。
//
//
// Related Topics 字符串 回溯 👍 69 👎 0

import java.util.*;

/**
 * @author suave
 * @date 2022-07-18 22:09
 */
public class Solution {
    public String[] permutation(String S) {
        Set<String> set = new HashSet<>();
        char[] chars = S.toCharArray();
        boolean[] visited = new boolean[chars.length];
        dfs(set, new StringBuilder(), visited, chars);
        String[] result = new String[set.size()];
        int index = 0;
        for (String s : set) {
            result[index++] = s;
        }
        return result;
    }

    private void dfs(Set<String> result, StringBuilder sb, boolean[] visit, char[] chars){
        if (sb.length() == chars.length){
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!visit[i]) {
                // 未遍历过
                sb.append(chars[i]);
                visit[i] = true;
                dfs(result, sb, visit, chars);
                visit[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().permutation("qqe")));
    }
}
