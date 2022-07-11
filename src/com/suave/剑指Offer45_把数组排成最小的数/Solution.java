package com.suave.剑指Offer45_把数组排成最小的数;
//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//
//
//
// 示例 1:
//
// 输入: [10,2]
//输出: "102"
//
// 示例 2:
//
// 输入: [3,30,34,5,9]
//输出: "3033459"
//
//
//
// 提示:
//
//
// 0 < nums.length <= 100
//
//
// 说明:
//
//
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
//
//
// Related Topics 贪心 字符串 排序 👍 493 👎 0

import java.util.Arrays;

/**
 * @author shunxin.jin
 * @date 2022/7/11 19:15
 */
public class Solution {
    public String minNumber(int[] nums) {
        String[] arr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(arr, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder result = new StringBuilder();
        for (String str : arr) {
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minNumber(new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247}));
    }
}
