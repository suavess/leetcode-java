package com.suave.q2413_最小偶倍数;
//给你一个正整数 n ，返回 2 和 n 的最小公倍数（正整数）。
//
//
//
// 示例 1：
//
// 输入：n = 5
//输出：10
//解释：5 和 2 的最小公倍数是 10 。
//
//
// 示例 2：
//
// 输入：n = 6
//输出：6
//解释：6 和 2 的最小公倍数是 6 。注意数字会是它自身的倍数。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 150
//
//
// Related Topics 数学 数论
// 👍 56 👎 0

/**
 * @author Suave
 * @since 2023/04/21 21:26
 */
public class Solution {
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }
}
