package com.suave.q1658_将x减到0的最小操作数;
//给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为
// k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k
//为 0 。
//
// 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
//
//
//
// 示例 1：
//
//
//输入：sequence = "ababc", word = "ab"
//输出：2
//解释："abab" 是 "ababc" 的子字符串。
//
//
// 示例 2：
//
//
//输入：sequence = "ababc", word = "ba"
//输出：1
//解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
//
//
// 示例 3：
//
//
//输入：sequence = "ababc", word = "ac"
//输出：0
//解释："ac" 不是 "ababc" 的子字符串。
//
//
//
//
// 提示：
//
//
// 1 <= sequence.length <= 100
// 1 <= word.length <= 100
// sequence 和 word 都只包含小写英文字母。
//
//
// Related Topics 字符串 字符串匹配 👍 21 👎 0

/**
 * @author suave
 * @date 2022-07-15 21:16
 */
public class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < x) {
            return -1;
        }
        if (nums[0] > x && nums[nums.length - 1] > x) {
            return -1;
        }
        int res = nums.length;
        sum = 0;
        int left = 0, right = nums.length - 1;
        // 先只加右边
        while (sum < x) {
            sum += nums[right--];
        }
        if (sum == x) {
            res = nums.length - 1 - right;
        }
        while (right < nums.length - 1) {
            // 逐渐减少右边
            sum -= nums[++right];
            while (sum < x) {
                // 循环加左边
                sum += nums[left];
                if (sum == x) {
                    res = Math.min(res, left + nums.length - right);
                } else if (sum > x) {
                    // 大于了说明不能直接加这个值,回滚一下
                    sum -= nums[left];
                    break;
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{5, 2, 3, 1, 1}, 5));
    }
}
