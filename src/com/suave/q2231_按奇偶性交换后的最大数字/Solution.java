package com.suave.q2231_按奇偶性交换后的最大数字;
//给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。
//
// 返回交换 任意 次之后 num 的 最大 可能值。
//
//
//
// 示例 1：
//
// 输入：num = 1234
//输出：3412
//解释：交换数字 3 和数字 1 ，结果得到 3214 。
//交换数字 2 和数字 4 ，结果得到 3412 。
//注意，可能存在其他交换序列，但是可以证明 3412 是最大可能值。
//注意，不能交换数字 4 和数字 1 ，因为它们奇偶性不同。
//
//
// 示例 2：
//
// 输入：num = 65875
//输出：87655
//解释：交换数字 8 和数字 6 ，结果得到 85675 。
//交换数字 5 和数字 7 ，结果得到 87655 。
//注意，可能存在其他交换序列，但是可以证明 87655 是最大可能值。
//
//
//
//
// 提示：
//
//
// 1 <= num <= 10⁹
//
//
// Related Topics 排序 堆（优先队列） 👍 16 👎 0

/**
 * @author suave
 * @date 2022-08-14 22:30
 */
public class Solution {
    public int largestInteger(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int max = chars[i];
            int maxIndex = i;
            int tmp = chars[i] % 2;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] % 2 == tmp && chars[j] > max) {
                    maxIndex = j;
                    max = chars[j];
                }
            }
            if (maxIndex != i) {
                // 交换位置
                char charTmp = chars[i];
                chars[i] = chars[maxIndex];
                chars[maxIndex] = charTmp;
            }
        }
        return new Integer(new String(chars));
    }
}
