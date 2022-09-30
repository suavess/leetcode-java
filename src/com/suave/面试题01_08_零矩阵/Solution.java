package com.suave.面试题01_08_零矩阵;
//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
//
//
//
// 示例 1：
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
//
//
// 示例 2：
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
//
//
// Related Topics 数组 哈希表 矩阵 👍 96 👎 0

import java.util.HashSet;
import java.util.Set;

/**
 * @author shunxin.jin
 * @date 2022/9/30 09:04
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
//        Set<Integer> row = new HashSet<>();
//        Set<Integer> column = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] column = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
//                    row.add(i);
//                    column.add(j);
                    row[i] = column[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                if (row.contains(i) || column.contains(j)) {
//                    matrix[i][j] = 0;
//                }
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
