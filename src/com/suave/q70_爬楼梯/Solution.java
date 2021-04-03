package com.suave.q70_爬楼梯;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划
// 👍 1578 👎 0

import java.util.ArrayList;

/**
 * 1 1
 * 2 2
 * 3 3
 * 4 5
 * 5 8
 *
 * @author shunxin.jin
 * @date 2021/4/3 11:12 下午
 */
public class Solution {
    public int climbStairs(int n) {
        // 递归 超时了。。。。。
//        if (n <= 3) {
//            return n;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);

        // 动态规划，数组暂存计算出来的数据
        if (n <= 3) {
            return n;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        for (int i = 3; i < n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n-1];
    }
}
