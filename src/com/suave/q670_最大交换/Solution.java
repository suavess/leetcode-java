package com.suave.q670_最大交换;
//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
//
// 示例 1 :
//
//
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
//
//
// 示例 2 :
//
//
//输入: 9973
//输出: 9973
//解释: 不需要交换。
//
//
// 注意:
//
//
// 给定数字的范围是 [0, 10⁸]
//
//
// Related Topics 贪心 数学 👍 358 👎 0

/**
 * @author suave
 * @date 2022-09-13 23:10
 */
public class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == '9') {
                continue;
            }
            char max = chars[i];
            int maxIndex = i;
            for (int j = chars.length - 1; j > i; j--) {
                if (chars[j] > max) {
                    max = chars[j];
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                char tmp = chars[maxIndex];
                chars[maxIndex] = chars[i];
                chars[i] = tmp;
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSwap(98368));
    }
}
