package com.suave.q1578_使绳子变成彩色的最短时间;
//Alice 把 n 个气球排列在一根绳子上。给你一个下标从 0 开始的字符串 colors ，其中 colors[i] 是第 i 个气球的颜色。
//
// Alice 想要把绳子装扮成 彩色 ，且她不希望两个连续的气球涂着相同的颜色，所以她喊来 Bob 帮忙。Bob 可以从绳子上移除一些气球使绳子变成 彩色
//。给你一个下标从 0 开始的整数数组 neededTime ，其中 neededTime[i] 是 Bob 从绳子上移除第 i 个气球需要的时间（以秒为单位）。
//
//
// 返回 Bob 使绳子变成 彩色 需要的 最少时间 。
//
//
//
// 示例 1：
//
//
//输入：colors = "abaac", neededTime = [1,2,3,4,5]
//输出：3
//解释：在上图中，'a' 是蓝色，'b' 是红色且 'c' 是绿色。
//Bob 可以移除下标 2 的蓝色气球。这将花费 3 秒。
//移除后，不存在两个连续的气球涂着相同的颜色。总时间 = 3 。
//
// 示例 2：
//
//
//输入：colors = "abc", neededTime = [1,2,3]
//输出：0
//解释：绳子已经是彩色的，Bob 不需要从绳子上移除任何气球。
//
//
// 示例 3：
//
//
//输入：colors = "aabaa", neededTime = [1,2,3,4,1]
//输出：2
//解释：Bob 会移除下标 0 和下标 4 处的气球。这两个气球各需要 1 秒来移除。
//移除后，不存在两个连续的气球涂着相同的颜色。总时间 = 1 + 1 = 2 。
//
//
//
//
// 提示：
//
//
// n == colors.length == neededTime.length
// 1 <= n <= 10⁵
// 1 <= neededTime[i] <= 10⁴
// colors 仅由小写英文字母组成
//
//
// Related Topics 贪心 数组 字符串 动态规划 👍 60 👎 0

import java.util.Arrays;

/**
 * @author shunxin.jin
 * @date 2022/7/15 15:24
 */
public class Solution {
    public int minCost(String colors, int[] neededTime) {
        // 动态规划
//        char[] chars = colors.toCharArray();
//        // dp数组表示i个气球装扮成彩色的最小时间
//        int[] dp = new int[chars.length];
//        // 初始化dp数组
//        dp[0] = 0;
//        int max = neededTime[0];
//        for (int i = 1; i < chars.length; i++) {
//            if (chars[i] != chars[i - 1]) {
//                max = neededTime[i];
//                dp[i] = dp[i - 1];
//                continue;
//            }
//            if (max > neededTime[i]) {
//                dp[i] = dp[i - 1] + neededTime[i];
//            } else {
//                dp[i] = dp[i - 1] + max;
//                max = neededTime[i];
//            }
//        }
//        System.out.println(Arrays.toString(dp));
//        return dp[chars.length - 1];
        // 动态规划滚动数组优化
        char[] chars = colors.toCharArray();
        int a, b = 0;
        int max = neededTime[0];
        for (int i = 1; i < chars.length; i++) {
            a = b;
            if (chars[i] != chars[i - 1]) {
                max = neededTime[i];
                continue;
            }
            if (max > neededTime[i]) {
                b = a + neededTime[i];
            } else {
                b = a + max;
                max = neededTime[i];
            }
        }
        return b;
    }

    public static void main(String[] args) {
        new Solution().minCost("aaabbbabbbb", new int[]{3,5,10,7,5,3,5,5,4,8,1});
    }
}
