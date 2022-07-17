package com.suave.q941_有效的山脉数组;
//给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
//
// 让我们回顾一下，如果 arr 满足下述条件，那么它是一个山脉数组：
//
//
// arr.length >= 3
// 在 0 < i < arr.length - 1 条件下，存在 i 使得：
//
// arr[0] < arr[1] < ... arr[i-1] < arr[i]
// arr[i] > arr[i+1] > ... > arr[arr.length - 1]
//
//
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：arr = [2,1]
//输出：false
//
//
// 示例 2：
//
//
//输入：arr = [3,5,5]
//输出：false
//
//
// 示例 3：
//
//
//输入：arr = [0,3,2,1]
//输出：true
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 10⁴
// 0 <= arr[i] <= 10⁴
//
//
// Related Topics 数组 👍 179 👎 0

/**
 * @author suave
 * @date 2022-07-17 17:12
 */
public class Solution {
    public boolean validMountainArray(int[] arr) {
//        if (arr.length == 1) {
//            return false;
//        }
//        if (arr[1] < arr[0]) {
//            return false;
//        }
//        boolean increment = true;
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] == arr[i - 1]) {
//                return false;
//            }
//            if (increment) {
//                if (arr[i] < arr[i - 1]) {
//                    increment = false;
//                }
//            } else {
//                if (arr[i] > arr[i - 1]) {
//                    return false;
//                }
//            }
//        }
//        return !increment;
        int n = arr.length;
        int i = 0;
        // 递增
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1) {
            return false;
        }
        // 递减
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == n - 1;
    }
}
