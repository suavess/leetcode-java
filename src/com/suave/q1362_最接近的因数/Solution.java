package com.suave.q1362_最接近的因数;
//给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
//
//
// 两数乘积等于 num + 1 或 num + 2
// 以绝对差进行度量，两数大小最接近
//
//
// 你可以按任意顺序返回这两个整数。
//
//
//
// 示例 1：
//
// 输入：num = 8
//输出：[3,3]
//解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10, 最接近的两个因数是 2 & 5，因此返回 3 & 3
//。
//
//
// 示例 2：
//
// 输入：num = 123
//输出：[5,25]
//
//
// 示例 3：
//
// 输入：num = 999
//输出：[40,25]
//
//
//
//
// 提示：
//
//
// 1 <= num <= 10^9
//
//
// Related Topics 数学 👍 29 👎 0

import java.util.Arrays;

/**
 * @author suave
 * @date 2022-09-18 00:00
 */
public class Solution {
    public int[] closestDivisors(int num) {
        int[] res1 = getFactor(num + 1);
        int[] res2 = getFactor(num + 2);
        if (res1[1] - res1[0] > res2[1] - res2[0]) {
            return res2;
        }
        return res1;
    }

    private int[] getFactor(int num) {
        int[] res = new int[]{1, num};
        int sqrt = (int) Math.sqrt(num);
        for (int i = sqrt; i > 1; i--) {
            if (num % i == 0) {
                // 被整除了
                int j = num / i;
                if (i > res[0] && j < res[1]) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().closestDivisors(999)));
    }
}
