package com.suave.面试题17_10_主要元素;

//数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1
//) 的解决方案。
//
//
//
// 示例 1：
//
//
//输入：[1,2,5,9,5,9,5,5,5]
//输出：5
//
// 示例 2：
//
//
//输入：[3,2]
//输出：-1
//
// 示例 3：
//
//
//输入：[2,2,1,1,1,2,2]
//输出：2
// Related Topics 数组 计数
// 👍 143 👎 0

/**
 * @author shunxin.jin
 * @date 2021/7/9 4:28 下午
 */
public class Solution {
    public int majorityElement(int[] nums) {
        // 先找出最多的那个元素
        int temp = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                temp = num;
            }
            if (temp == num) {
                count++;
            } else {
                count--;
            }
        }
        // 遍历数量
        count = 0;
        for (int num : nums) {
            if (temp == num) {
                count++;
            }
        }
        if (count * 2 > nums.length) {
            return temp;
        }
        return -1;
    }
}
