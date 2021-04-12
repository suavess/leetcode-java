package com.suave.q179_最大数;
//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
//
//
//
// 示例 1：
//
//
//输入：nums = [10,2]
//输出："210"
//
// 示例 2：
//
//
//输入：nums = [3,30,34,5,9]
//输出："9534330"
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出："1"
//
//
// 示例 4：
//
//
//输入：nums = [10]
//输出："10"
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 109
//
// Related Topics 排序
// 👍 605 👎 0

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author shunxin.jin
 * @date 2021/4/12 3:06 下午
 */
public class Solution {
    public String largestNumber(int[] nums) {
//        int length = nums.length;
//        for (int i = 1; i < length; i++) {
//            boolean flag = true;
//            for (int j = 0; j < length - i; j++) {
//                String num1 = String.valueOf(nums[j]) + String.valueOf(nums[j + 1]);
//                String num2 = String.valueOf(nums[j + 1]) + String.valueOf(nums[j]);
//                if (num1.compareTo(num2) < 0) {
//                    int tmp = nums[j];
//                    nums[j] = nums[j + 1];
//                    nums[j + 1] = tmp;
//                    flag = false;
//                }
//            }
//            if (flag) {
//                break;
//            }
//        }
//        String collect = Arrays.stream(nums).boxed().map(Object::toString).collect(Collectors.joining());
//        if (collect.charAt(0) == '0') {
//            return "0";
//        }
//        return collect;


        // 优化
        return Arrays.stream(nums)
                .mapToObj(Integer::toString)
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                .reduce("", (s1, s2) -> s1.equals("0") ? s2 : s1 + s2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{0, 0}));
    }
}
