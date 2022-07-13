package com.suave.q2295_替换数组中的元素;
//给你一个下标从 0 开始的数组 nums ，它包含 n 个 互不相同 的正整数。请你对这个数组执行 m 个操作，在第 i 个操作中，你需要将数字
//operations[i][0] 替换成 operations[i][1] 。
//
// 题目保证在第 i 个操作中：
//
//
// operations[i][0] 在 nums 中存在。
// operations[i][1] 在 nums 中不存在。
//
//
// 请你返回执行完所有操作后的数组。
//
//
//
// 示例 1：
//
// 输入：nums = [1,2,4,6], operations = [[1,3],[4,7],[6,1]]
//输出：[3,2,7,1]
//解释：我们对 nums 执行以下操作：
//- 将数字 1 替换为 3 。nums 变为 [3,2,4,6] 。
//- 将数字 4 替换为 7 。nums 变为 [3,2,7,6] 。
//- 将数字 6 替换为 1 。nums 变为 [3,2,7,1] 。
//返回最终数组 [3,2,7,1] 。
//
//
// 示例 2：
//
// 输入：nums = [1,2], operations = [[1,3],[2,1],[3,2]]
//输出：[2,1]
//解释：我们对 nums 执行以下操作：
//- 将数字 1 替换为 3 。nums 变为 [3,2] 。
//- 将数字 2 替换为 1 。nums 变为 [3,1] 。
//- 将数字 3 替换为 2 。nums 变为 [2,1] 。
//返回最终数组 [2,1] 。
//
//
//
//
// 提示：
//
//
// n == nums.length
// m == operations.length
// 1 <= n, m <= 10⁵
// nums 中所有数字 互不相同 。
// operations[i].length == 2
// 1 <= nums[i], operations[i][0], operations[i][1] <= 10⁶
// 在执行第 i 个操作时，operations[i][0] 在 nums 中存在。
// 在执行第 i 个操作时，operations[i][1] 在 nums 中不存在。
//
//
// Related Topics 数组 哈希表 模拟 👍 12 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author shunxin.jin
 * @date 2022/7/13 10:45
 */
public class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
//        Map<Integer, Integer> map = new HashMap<>();
//        Set<Integer> useSet = new HashSet<>();
//        for (int i = 0; i < operations.length; i++) {
//            if (useSet.contains(i)) {
//                continue;
//            }
//            int oldVal = operations[i][0];
//            int newVal = operations[i][1];
//            for (int j = i + 1; j < operations.length; j++) {
//                if (operations[j][0] == newVal) {
//                    newVal = operations[j][1];
//                    useSet.add(j);
//                }
//            }
//            map.put(oldVal, newVal);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = map.getOrDefault(nums[i], nums[i]);
//        }
//        return nums;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int[] operation : operations) {
            Integer index = map.get(operation[0]);
            if (index != null) {
                nums[index] = operation[1];
                map.put(operation[1], index);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Solution().arrayChange(
                                new int[]{1, 2, 4, 6}, new int[][]{new int[]{1, 3}, new int[]{4, 7}, new int[]{6, 1}}
                        )
                )
        );
    }
}
