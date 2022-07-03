package com.suave.q1137_第N个泰波那契数;
//泰波那契序列 Tn 定义如下：
//
// T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
//
// 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
//
//
//
// 示例 1：
//
// 输入：n = 4
//输出：4
//解释：
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
//
//
// 示例 2：
//
// 输入：n = 25
//输出：1389537
//
//
//
//
// 提示：
//
//
// 0 <= n <= 37
// 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
//
//
// Related Topics 记忆化搜索 数学 动态规划 👍 208 👎 0

/**
 * @author suave
 * @date 2022-07-03 13:28
 */
public class Solution {
    public int tribonacci(int n) {
        // 动态规划
//        if (n < 2) {
//            return n;
//        }
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 1;
//        for (int i = 3; i < n + 1; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
//        }
//        return dp[n];
        // 滚动数组优化
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int a = 0, b = 1, c = 1, d = 2;
        for (int i = 4; i < n + 1; i++) {
            a = b;
            b = c;
            c = d;
            d = a + b + c;
        }
        return d;
    }
}
