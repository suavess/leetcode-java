package com.suave.q698_划分为k个相等的子集;
//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
//
//
//
// 示例 1：
//
//
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
//
// 示例 2:
//
//
//输入: nums = [1,2,3,4], k = 3
//输出: false
//
//
//
// 提示：
//
//
// 1 <= k <= len(nums) <= 16
// 0 < nums[i] < 10000
// 每个元素的频率在 [1,4] 范围内
//
//
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 777 👎 0

import java.util.Arrays;

/**
 * @author shunxin.jin
 * @date 2022/9/20 18:46
 */
public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int avg = sum / k;
        int[] bucket = new int[k];
        Arrays.fill(bucket, avg);
        Arrays.sort(nums);
        return setValue(bucket, nums, nums.length - 1);
    }

    private boolean setValue(int[] bucket, int[] nums, int index) {
        if (index < 0) {
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == nums[index] || bucket[i] >= nums[0] + nums[index]) {
                bucket[i] -= nums[index];
                if (setValue(bucket, nums, index - 1)) {
                    return true;
                }
                bucket[i] += nums[index];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4));
    }
}
