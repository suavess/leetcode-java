package com.suave.q88_合并两个有序数组;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//
//
// 示例 2：
//
//
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//
//
//
//
// 提示：
//
//
// nums1.length == m + n
// nums2.length == n
// 0 <= m, n <= 200
// 1 <= m + n <= 200
// -109 <= nums1[i], nums2[i] <= 109
//
// Related Topics 数组 双指针
// 👍 820 👎 0

import java.util.Arrays;

/**
 * @author shunxin.jin
 * @date 2021/4/4 10:26 下午
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] arr = new int[m + n];
//        int p1 = 0;
//        int p2 = 0;
//        while (p1 < m || p2 < n) {
//            if (p1 == m) {
//                arr[p1 + p2] = nums2[p2++];
//            } else if (p2 == n) {
//                arr[p1 + p2] = nums1[p1++];
//            } else if (nums1[p1] < nums2[p2]) {
//                arr[p1 + p2] = nums1[p1++];
//            } else {
//                arr[p1 + p2] = nums2[p2++];
//            }
//        }
//        System.arraycopy(arr, 0, nums1, 0, m + n);

        // 优化
        int p1 = m - 1, p2 = n - 1;
        int end = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[end--] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[end--] = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[end--] = nums1[p1--];
            } else {
                nums1[end--] = nums2[p2--];
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 0, 0, 0};
        new Solution().merge(ints, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(ints));
    }
}
