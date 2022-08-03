package com.suave.q899_有序队列;
//给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
//
// 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
//
//
//
// 示例 1：
//
//
//输入：s = "cba", k = 1
//输出："acb"
//解释：
//在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
//在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
//
//
// 示例 2：
//
//
//输入：s = "baaca", k = 3
//输出："aaabc"
//解释：
//在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
//在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
//
//
//
//
// 提示：
//
//
// 1 <= k <= S.length <= 1000
// s 只由小写字母组成。
//
//
// Related Topics 数学 字符串 排序 👍 147 👎 0

import java.util.Arrays;

/**
 * @author suave
 * @date 2022-08-03 22:27
 */
public class Solution {
    public String orderlyQueue(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (k == 1) {
            // 最小值
            char[] min = Arrays.copyOf(chars, length);
            // 全部循环一遍,判断最小值
            for (int i = 0; i < length - 1; i++) {
                char[] tmp = new char[length];
                System.arraycopy(chars, 1, tmp, 0, length - 1);
                tmp[length - 1] = chars[0];
                for (int j = 0; j < length; j++) {
                    if (tmp[j] == min[j]) {
                        continue;
                    }
                    if (tmp[j] < min[j]) {
                        min = tmp;
                    }
                    break;
                }
                chars = tmp;
            }
            return new String(min);
        } else {
            // k > 1时,就可以实现全排序
            Arrays.sort(chars);
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        new Solution().orderlyQueue("nhtq", 1);
    }
}
