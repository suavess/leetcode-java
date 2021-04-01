package com.suave.q53_最大子序和;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//
//
// 示例 1：
//
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：1
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：0
//
//
// 示例 4：
//
//
//输入：nums = [-1]
//输出：-1
//
//
// 示例 5：
//
//
//输入：nums = [-100000]
//输出：-100000
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// -105 <= nums[i] <= 105
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
// Related Topics 数组 分治算法 动态规划
// 👍 3068 👎 0

import java.util.Arrays;

/**
 * @author shunxin.jin
 * @date 2021/3/30 4:36 下午
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        // 最后返回结果
        int res = nums[0];
        // 当前相加的最大值
        int num = 0;
        for (int i : nums) {
            if (num > 0) {
                // 当前值大于0时就继续加
                num += i;
            } else {
                // 否则就舍弃
                num = i;
            }
            res = Math.max(res, num);
        }
        return res;
    }
}
