package com.suave.q961_在长度2N的数组中找出重复N次的元素;
//给你一个整数数组 nums ，该数组具有以下属性：
//
//
//
//
// nums.length == 2 * n.
// nums 包含 n + 1 个 不同的 元素
// nums 中恰有一个元素重复 n 次
//
//
// 找出并返回重复了 n 次的那个元素。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,3]
//输出：3
//
//
// 示例 2：
//
//
//输入：nums = [2,1,2,5,3,2]
//输出：2
//
//
// 示例 3：
//
//
//输入：nums = [5,1,5,2,5,3,5,4]
//输出：5
//
//
//
//
//
//
// 提示：
//
//
// 2 <= n <= 5000
// nums.length == 2 * n
// 0 <= nums[i] <= 10⁴
// nums 由 n + 1 个 不同的 元素组成，且其中一个元素恰好重复 n 次
//
// Related Topics 数组 哈希表 👍 129 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * @author shunxin.jin
 * @date 2022/5/21 10:20
 */
public class Solution {

    public int repeatedNTimes(int[] nums) {
        // hashmap实现
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == nums.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

}
