package com.suave.q1027_最长等差数列;
//解释：
//最长的等差子序列是 [4,7,10]。
//
//
// 示例 3：
//
//
//输入：nums = [20,1,15,3,10,5,8]
//输出：4
//解释：
//最长的等差子序列是 [20,15,10,5]。
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 1000
// 0 <= nums[i] <= 500
//
//
// Related Topics 数组 哈希表 二分查找 动态规划 👍 199 👎 0

/**
 * @author suave
 * @date 2022-08-01 22:12
 */
public class Solution {
    public int longestArithSeqLength(int[] nums) {
        // dp[i][j] 到第i个数时,以j为公差的最大子序列长度
        // 0 <= nums[i] <= 500 最大差为500,即j为500
        int max = 0;
        int[][] dp = new int[nums.length][500];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 表示nums[i]与nums[j]以差为d构成等差数列
                int d = nums[i] - nums[j];
                // dp[i][d]表示：nums[i]以差为d能与前面的数构成的等差数列的长度
                dp[i][d] = Math.max(dp[i][d], dp[j][d] + 1);
                max = Math.max(max, dp[i][d]);
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestArithSeqLength(new int[]{3, 6, 9, 12}));
    }
}
