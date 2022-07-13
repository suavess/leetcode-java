package com.suave.q2094_找出3位偶数;
//给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
//
// 你需要找出 所有 满足下述条件且 互不相同 的整数：
//
//
// 该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
// 该整数不含 前导零
// 该整数是一个 偶数
//
//
// 例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。
//
// 将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。
//
//
//
// 示例 1：
//
//
//输入：digits = [2,1,3,0]
//输出：[102,120,130,132,210,230,302,310,312,320]
//解释：
//所有满足题目条件的整数都在输出数组中列出。
//注意，答案数组中不含有 奇数 或带 前导零 的整数。
//
// 示例 2：
//
//
//输入：digits = [2,2,8,8,2]
//输出：[222,228,282,288,822,828,882]
//解释：
//同样的数字（0 - 9）在构造整数时可以重复多次，重复次数最多与其在 digits 中出现的次数一样。
//在这个例子中，数字 8 在构造 288、828 和 882 时都重复了两次。
//
//
// 示例 3：
//
//
//输入：digits = [3,7,5]
//输出：[]
//解释：
//使用给定的 digits 无法构造偶数。
//
//
//
//
// 提示：
//
//
// 3 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
//
// Related Topics 数组 哈希表 枚举 排序 👍 19 👎 0

import java.util.*;

/**
 * @author suave
 * @date 2022-07-13 23:16
 */
public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        // 暴力解法
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < digits.length; i++) {
//            if (digits[i] == 0){
//                continue;
//            }
//            for (int j = 0; j < digits.length; j++) {
//                if (i == j){
//                    continue;
//                }
//                for (int k = 0; k < digits.length; k++) {
//                    if (j == k || i == k){
//                        continue;
//                    }
//                    int tmp = digits[i] * 100 + digits[j] * 10 + digits[k];
//                    if (tmp % 2 == 0) {
//                        set.add(tmp);
//                    }
//                }
//            }
//        }
//        int[] res = new int[set.size()];
//        int index = 0;
//        for (Integer integer : set) {
//            res[index++] = integer;
//        }
//        Arrays.sort(res);
//        return res;
        // 遍历所有可能的三位数,判断是否在数组中存在
        // 先统计数组中各个数字的数量
        List<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(digits.length);
        for (int digit : digits) {
            map.put(digit, map.getOrDefault(digit, 0) + 1);
        }
        for (int i = 100; i < 1000; i += 2) {
            // 百分位的数字
            int hundred = i / 100;
            int ten = i % 100 / 10;
            int digit = i % 10;
            if (hundred == ten && hundred == digit) {
                if (map.getOrDefault(hundred, 0) < 3) {
                    continue;
                }
            } else if (hundred == ten) {
                if (map.getOrDefault(hundred, 0) < 2 || map.getOrDefault(digit, 0) < 1) {
                    continue;
                }
            } else if (hundred == digit) {
                if (map.getOrDefault(hundred, 0) < 2 || map.getOrDefault(ten, 0) < 1) {
                    continue;
                }
            } else if (ten == digit) {
                if (map.getOrDefault(ten, 0) < 2 || map.getOrDefault(hundred, 0) < 1) {
                    continue;
                }
            } else {
                // 都不相等
                if (map.getOrDefault(hundred, 0) < 1 || map.getOrDefault(ten, 0) < 1 || map.getOrDefault(digit, 0) < 1) {
                    continue;
                }
            }
            arr.add(i);
        }
        int[] res = new int[arr.size()];
        int index = 0;
        for (Integer integer : arr) {
            res[index++] = integer;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findEvenNumbers(new int[]{2, 1, 3, 0})));
    }
}
