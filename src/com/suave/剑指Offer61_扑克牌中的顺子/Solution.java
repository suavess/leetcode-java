package com.suave.剑指Offer61_扑克牌中的顺子;
//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。
//
//
//
// 示例 1:
//
//
//输入: [1,2,3,4,5]
//输出: True
//
//
//
// 示例 2:
//
//
//输入: [0,0,1,2,5]
//输出: True
//
//
//
// 限制：
//
// 数组长度为 5
//
// 数组的数取值为 [0, 13] .
//
// Related Topics 数组 排序 👍 261 👎 0

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author suave
 * @date 2022-08-09 23:36
 */
public class Solution {
    public boolean isStraight(int[] nums) {
//        Arrays.sort(nums);
//        int zeroCount = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                zeroCount++;
//            }
//        }
//        for (int i = zeroCount + 1; i < nums.length; i++) {
//            int diff = nums[i] - nums[i - 1];
//            if (diff == 1) {
//                continue;
//            }
//            if (diff < 1) {
//                return false;
//            }
//            if (diff - 1 > zeroCount) {
//                return false;
//            }
//            zeroCount -= (diff - 1);
//        }
//        if (zeroCount < 0) {
//            return false;
//        }
//        return true;
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num)) {
                return false;
            }
            repeat.add(num);
        }
        return max - min < 5;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isStraight(new int[]{11, 8, 12, 8, 10}));
    }
}
