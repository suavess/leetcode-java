package com.suave.q68_x的平方根;

//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
// 示例 1:
//
// 输入: 4
//输出: 2
//
//
// 示例 2:
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
//
// Related Topics 数学 二分查找
// 👍 639 👎 0

/**
 * @author shunxin.jin
 * @date 2021/4/3 10:49 下午
 */
public class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int start = 0;
        int end = x;
        while (end - start > 1) {
            int tmp = (end + start) / 2;
            if (x / tmp < tmp){
                end  = tmp;
            } else {
                start = tmp;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2147483647));
    }
}
