package com.suave.q442_数组中重复的数据;
//给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次
//的整数，并以数组形式返回。
//
// 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间（不包括存储输出所需的空间）的算法解决此问题。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[2,3]
//
//
// 示例 2：
//
//
//输入：nums = [1,1,2]
//输出：[1]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[]
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 10⁵
// 1 <= nums[i] <= n
// nums 中的每个元素出现 一次 或 两次
//
//
// Related Topics 数组 哈希表
// 👍 788 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @author Suave
 * @since 2024/09/03 21:32
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // List<Integer> res = new ArrayList<>();
        // Arrays.sort(nums);
        // for (int i = 0; i < nums.length - 1; i++) {
        //     if (nums[i] == nums[i + 1]) {
        //         res.add(nums[i]);
        //         i++;
        //     }
        // }
        // return res;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] - 1 != i) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
