package com.suave.q7_整数反转;

//给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
//
//
// 示例 1：
//
//
//输入：x = 123
//输出：321
//
//
// 示例 2：
//
//
//输入：x = -123
//输出：-321
//
//
// 示例 3：
//
//
//输入：x = 120
//输出：21
//
//
// 示例 4：
//
//
//输入：x = 0
//输出：0
//
//
//
//
// 提示：
//
//
// -231 <= x <= 231 - 1
//
// Related Topics 数学
// 👍 2580 👎 0

/**
 * @author Suave
 * @author 2021/3/9 10:37 下午
 */
public class Solution {
    public int reverse(int x) {
        if (x > 0) {
            StringBuilder reverse = new StringBuilder(String.valueOf(x)).reverse();
            return Integer.parseInt(reverse.toString());
        }
        StringBuilder reverse = new StringBuilder(String.valueOf(x).substring(1)).reverse();
        return -Integer.parseInt(reverse.toString());
    }
}
