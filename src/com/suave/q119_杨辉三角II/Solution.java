package com.suave.q119_杨辉三角II;
//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//
//
//
//
//
// 示例 1:
//
//
//输入: rowIndex = 3
//输出: [1,3,3,1]
//
//
// 示例 2:
//
//
//输入: rowIndex = 0
//输出: [1]
//
//
// 示例 3:
//
//
//输入: rowIndex = 1
//输出: [1,1]
//
//
//
//
// 提示:
//
//
// 0 <= rowIndex <= 33
//
//
//
//
// 进阶：
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
//
// Related Topics 数组 动态规划 👍 407 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @author shunxin.jin
 * @date 2022/7/1 10:09
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> last = new ArrayList<>();
        last.add(1);
        if (rowIndex == 0) {
            return last;
        }
        last.add(1);
        if (rowIndex == 1) {
            return last;
        }
        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> next = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    next.add(1);
                } else {
                    next.add(last.get(j - 1) + last.get(j));
                }
            }
            last = next;
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getRow(3));
    }
}
