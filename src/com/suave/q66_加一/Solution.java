package com.suave.q66_加一;

//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//
//
// 示例 1：
//
//
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
//
//
// 示例 2：
//
//
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
//
//
// 示例 3：
//
//
//输入：digits = [0]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
// Related Topics 数组
// 👍 655 👎 0

import java.awt.*;
import java.util.Arrays;

/**
 * @author shunxin.jin
 * @date 2021/4/2 9:30 上午
 */
public class Solution {
    public int[] plusOne(int[] digits) {
//        int[] ints = new int[digits.length + 1];
//        System.arraycopy(digits, 0, ints, 1, digits.length);
//        for (int i = ints.length - 1; i >= 0; i--) {
//            if (ints[i] + 1 == 10) {
//                ints[i] = 0;
//                if (i - 1 >= 0) {
//                    digits[i - 1] = 0;
//                }
//            } else {
//                ints[i] += 1;
//                if (i - 1 >= 0) {
//                    digits[i - 1] += 1;
//                }
//                break;
//            }
//        }
//        if (ints[0] != 0) {
//            return ints;
//        }
//        return digits;


        // 继续优化
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 == 10) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                break;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{9, 9, 9})));
    }
}
