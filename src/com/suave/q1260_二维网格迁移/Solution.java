package com.suave.q1260_二维网格迁移;
//给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
//
// 每次「迁移」操作将会引发下述活动：
//
//
// 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
// 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
// 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
//
//
// 请你返回 k 次迁移操作后最终得到的 二维网格。
//
//
//
// 示例 1：
//
//
//
//
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//输出：[[9,1,2],[3,4,5],[6,7,8]]
//
//
// 示例 2：
//
//
//
//
//输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
//输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
//
//
// 示例 3：
//
//
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
//输出：[[1,2,3],[4,5,6],[7,8,9]]
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m <= 50
// 1 <= n <= 50
// -1000 <= grid[i][j] <= 1000
// 0 <= k <= 100
//
//
// Related Topics 数组 矩阵 模拟 👍 95 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @author suave
 * @date 2022-07-20 22:36
 */
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[] arr = new int[grid.length * grid[0].length];
        int index = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                arr[index++] = anInt;
            }
        }
        for(int i = 1; i <= k; i++) {
            int temp = arr[arr.length - 1];
            for(int j = 1; j < arr.length; j++){
                arr[arr.length - j] = arr[arr.length - j - 1];
            }
            arr[0] = temp;
        }
        List<List<Integer>> result = new ArrayList<>(grid.length);
        List<Integer> list = new ArrayList<>(grid[0].length);
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            if ((i + 1) % grid[0].length == 0) {
                result.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shiftGrid(new int[][]{new int[]{1}, new int[]{2}, new int[]{3}, new int[]{4}, new int[]{7}, new int[]{6}, new int[]{5}}, 2));
    }
}
