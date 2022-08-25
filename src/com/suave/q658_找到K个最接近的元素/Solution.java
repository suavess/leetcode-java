package com.suave.q658_找到K个最接近的元素;
//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
//
// 整数 a 比整数 b 更接近 x 需要满足：
//
//
// |a - x| < |b - x| 或者
// |a - x| == |b - x| 且 a < b
//
//
//
//
// 示例 1：
//
//
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
//
//
//
//
// 提示：
//
//
// 1 <= k <= arr.length
// 1 <= arr.length <= 10⁴
//
// arr 按 升序 排列
// -10⁴ <= arr[i], x <= 10⁴
//
//
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 406 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shunxin.jin
 * @date 2022/8/25 15:49
 */
public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        ArrayDeque<Integer> res = new ArrayDeque<>(k);
//        int index = 0;
//        for (; index < k; index++) {
//            res.add(arr[index]);
//        }
//        for (; index < arr.length; index++) {
//            if (Math.abs(x - res.getFirst()) > Math.abs(x - arr[index])) {
//                res.removeFirst();
//                res.add(arr[index]);
//                continue;
//            }
//            if (Math.abs(x - res.getLast()) > Math.abs(x - arr[index])) {
//                res.removeLast();
//                res.add(arr[index]);
//                continue;
//            }
//            if (Math.abs(x - res.getFirst()) == Math.abs(x - arr[index]) && res.getFirst() > arr[index]){
//                res.removeFirst();
//                res.add(arr[index]);
//                continue;
//            }
//            if (Math.abs(x - res.getLast()) == Math.abs(x - arr[index]) && res.getLast() > arr[index]) {
//                res.removeLast();
//                res.add(arr[index]);
//            }
//        }
//        return new ArrayList<>(res);
        // 二分
//        LinkedList<Integer> res = new LinkedList<>();
//        int left = 0, right = arr.length - 1;
//        while (left + 1 < right) {
//            if (x > arr[(left + right) / 2]) {
//                left = (left + right) / 2;
//            } else if (x < arr[(left + right) / 2]) {
//                right = (left + right) / 2;
//            } else {
//                left = (left + right) / 2;
//                right = left;
//                break;
//            }
//        }
//        if (k == 1) {
//            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
//                res.add(arr[right]);
//            } else {
//                res.add(arr[left]);
//            }
//            return res;
//        }
//        if (left == right) {
//            res.add(arr[left--]);
//            right++;
//        }
//        while (res.size() < k) {
//            if (left == -1) {
//                res.add(arr[right++]);
//                continue;
//            } else if (right == arr.length) {
//                res.addFirst(arr[left--]);
//                continue;
//            }
//            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
//                res.add(arr[right++]);
//            } else {
//                res.addFirst(arr[left--]);
//            }
//        }
//        return res;
        // 排序
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        list.sort((a, b) -> {
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        });
        List<Integer> ans = list.subList(0, k);
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findClosestElements(new int[]{1,2,3,4,5}, 4, 5));
    }
}
