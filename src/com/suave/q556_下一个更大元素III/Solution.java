package com.suave.q556_下一个更大元素III;
//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
//
// 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：n = 12
//输出：21
//
//
// 示例 2：
//
//
//输入：n = 21
//输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2³¹ - 1
//
//
// Related Topics 数学 双指针 字符串 👍 255 👎 0

import java.util.Arrays;

/**
 * @author suave
 * @date 2022-07-03 12:34
 */
public class Solution {
    public int nextGreaterElement(int n) {
        if (n < 10) {
            return -1;
        }
        char[] arr = String.valueOf(n).toCharArray();
        int i = arr.length - 1;
        for (;;){
            // 从右向左找到第一个不是递增的字符
            if (arr[i] > arr[i - 1]) {
                i--;
                break;
            }
            i--;
            if (i == 0) {
                return -1;
            }
        }
        // 从右向左找到一个大于i但是是右边最小的字符,然后进行交换
        for (int j = arr.length - 1; j >= i; j--) {
            if (arr[j] > arr[i]) {
                // 交换i和j的元素
                char temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                break;
            }
        }
        // 将i以后的元素从小到大排序
        Arrays.sort(arr, i + 1, arr.length);
        long l = Long.parseLong(new String(arr));
        if (l > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) l;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nextGreaterElement(15914272));
    }
}
