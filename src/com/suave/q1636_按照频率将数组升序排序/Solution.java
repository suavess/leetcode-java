package com.suave.q1636_按照频率将数组升序排序;
//给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
//
// 请你返回排序后的数组。
//
//
//
// 示例 1：
//
// 输入：nums = [1,1,2,2,2,3]
//输出：[3,1,1,2,2,2]
//解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
//
//
// 示例 2：
//
// 输入：nums = [2,3,1,3,2]
//输出：[1,3,3,2,2]
//解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
//
//
// 示例 3：
//
// 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
//输出：[5,-1,4,4,-6,-6,1,1,1]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// -100 <= nums[i] <= 100
//
//
// Related Topics 数组 哈希表 排序 👍 117 👎 0

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author suave
 * @date 2022-09-19 21:55
 */
public class Solution {
    public int[] frequencySort(int[] nums) {
        int[] bucket = new int[201];
        for (int num : nums) {
            bucket[num + 100]++;
        }
        int i = 0;
        int[] res = new int[nums.length];
        while (i < nums.length) {
            int minIndex = 0, min = Integer.MAX_VALUE;
            for (int j = 0; j < bucket.length; j++) {
                if (bucket[j] > 0 && bucket[j] <= min) {
                    min = bucket[j];
                    minIndex = j;
                }
            }
            for (int j = 0; j < min; j++) {
                res[i++] = minIndex - 100;
            }
            bucket[minIndex] = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().frequencySort(new int[]{100,-100,100,0,58})));
    }
}
