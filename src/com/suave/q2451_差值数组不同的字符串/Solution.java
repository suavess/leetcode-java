package com.suave.q2451_差值数组不同的字符串;
//给你一个字符串数组 words ，每一个字符串长度都相同，令所有字符串的长度都为 n 。
//
// 每个字符串 words[i] 可以被转化为一个长度为 n - 1 的 差值整数数组 difference[i] ，其中对于 0 <= j <= n - 2
// 有 difference[i][j] = words[i][j+1] - words[i][j] 。注意两个字母的差值定义为它们在字母表中 位置 之差，也就是
//说 'a' 的位置是 0 ，'b' 的位置是 1 ，'z' 的位置是 25 。
//
//
// 比方说，字符串 "acb" 的差值整数数组是 [2 - 0, 1 - 2] = [2, -1] 。
//
//
// words 中所有字符串 除了一个字符串以外 ，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
//
// 请你返回 words中 差值整数数组 不同的字符串。
//
//
//
// 示例 1：
//
//
//输入：words = ["adc","wzy","abc"]
//输出："abc"
//解释：
//- "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
//- "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
//- "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
//不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
//
//
// 示例 2：
//
//
//输入：words = ["aaa","bob","ccc","ddd"]
//输出："bob"
//解释：除了 "bob" 的差值整数数组是 [13, -13] 以外，其他字符串的差值整数数组都是 [0, 0] 。
//
//
//
//
// 提示：
//
//
// 3 <= words.length <= 100
// n == words[i].length
// 2 <= n <= 20
// words[i] 只含有小写英文字母。
//
//
// Related Topics 数组 哈希表 字符串
// 👍 59 👎 0

import java.util.Arrays;

/**
 * @author Suave
 * @since 2023/05/25 22:03
 */
public class Solution {
    public String oddString(String[] words) {
        int n = words[0].length();
        int[] compare = get(n, words[0]);
        for (int i = 1; i < words.length; i++) {
            int[] tmp = get(n, words[i]);
            if (!Arrays.equals(compare, tmp)) {
                if (i > 1) {
                    return words[i];
                }
                 for (int j = 0; j < n - 1; j++) {
                     if (compare[j] != words[2].charAt(j + 1) - words[2].charAt(j)) {
                         return words[0];
                     }
                }
                 return words[i];
            }
        }
        return words[words.length - 1];
    }

    private int[] get(int n, String word) {
        int[] compare = new int[n];
        for (int j = 0; j < n - 1; j++) {
            compare[j] = word.charAt(j + 1) - word.charAt(j);
        }
        return compare;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().oddString(new String[]{"adc","wzy","abc"}));
    }
}
