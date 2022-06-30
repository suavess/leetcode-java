package com.suave.q118_杨辉三角;
//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
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
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
//
// 示例 2:
//
//
//输入: numRows = 1
//输出: [[1]]
//
//
//
//
// 提示:
//
//
// 1 <= numRows <= 30
//
//
// Related Topics 数组 动态规划 👍 781 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author suave
 * @date 2022-06-30 21:05
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(1));
        if (numRows == 1) {
            return result;
        }
        result.add(Arrays.asList(1, 1));
        if (numRows == 2) {
            return result;
        }
        for (int i = 2; i < numRows; i++) {
            // 上一层的列表
            List<Integer> lastList = result.get(i - 1);
            // 这层的列表
            List<Integer> list = new ArrayList<>(i + 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    // 第一个或最后一个数字为1
                    list.add(1);
                    continue;
                }
                list.add(lastList.get(j - 1) + lastList.get(j));
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generate(5));
    }
}
