package com.suave.q1025_除数博弈;
//爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
//
// 最初，黑板上有一个数字 n 。在每个玩家的回合，玩家需要执行以下操作：
//
//
// 选出任一 x，满足 0 < x < n 且 n % x == 0 。
// 用 n - x 替换黑板上的数字 n 。
//
//
// 如果玩家无法执行这些操作，就会输掉游戏。
//
// 只有在爱丽丝在游戏中取得胜利时才返回 true 。假设两个玩家都以最佳状态参与游戏。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：n = 2
//输出：true
//解释：爱丽丝选择 1，鲍勃无法进行操作。
//
//
// 示例 2：
//
//
//输入：n = 3
//输出：false
//解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 1000
//
//
// Related Topics 脑筋急转弯 数学 动态规划 博弈 👍 360 👎 0

/**
 * @author suave
 * @date 2022-07-02 17:58
 */
public class Solution {
    public boolean divisorGame(int n) {
        // 偶数必胜
//        return n % 2 == 0;
        if (n == 1) {
            return false;
        }
        // 初始化一个dp数组
        boolean[] dp = new boolean[n];
        dp[0] = false;
        dp[1] = true;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if ((i + 1) % j == 0) {
                    dp[i] = dp[i] || !dp[i - j];
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divisorGame(9));
    }
}
