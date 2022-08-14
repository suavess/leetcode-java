package com.suave.q994_腐烂的橘子;
//在给定的 m x n 网格
// grid 中，每个单元格可以有以下三个值之一：
//
//
// 值 0 代表空单元格；
// 值 1 代表新鲜橘子；
// 值 2 代表腐烂的橘子。
//
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
//
//
//
// 示例 1：
//
//
//
//
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
//
//
// 示例 2：
//
//
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
//
//
// 示例 3：
//
//
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] 仅为 0、1 或 2
//
//
// Related Topics 广度优先搜索 数组 矩阵 👍 585 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author suave
 * @date 2022-08-14 13:41
 */
public class Solution {
    public int orangesRotting(int[][] grid) {
        // 第(i,j)个橘子腐烂,下一分钟则(i-1,j),(i,j-1),(i,j+1),(i+1,j)会腐烂
//        int index = 0;
//        List<int[]> last = new ArrayList<>();
//        while (true) {
//            // 找到腐烂的橘子
//            boolean allBad = true;
//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[0].length; j++) {
//                    if (grid[i][j] != 2) {
//                        continue;
//                    }
//                    if (i != 0) {
//                        if (grid[i - 1][j] == 1) {
//                            last.add(new int[]{i - 1, j});
//                            allBad = false;
//                        }
//                    }
//                    if (i != grid.length - 1) {
//                        if (grid[i + 1][j] == 1) {
//                            last.add(new int[]{i + 1, j});
//                            allBad = false;
//                        }
//                    }
//                    if (j != 0) {
//                        if (grid[i][j - 1] == 1) {
//                            last.add(new int[]{i, j - 1});
//                            allBad = false;
//                        }
//                    }
//                    if (j != grid[0].length - 1) {
//                        if (grid[i][j + 1] == 1) {
//                            last.add(new int[]{i, j + 1});
//                            allBad = false;
//                        }
//                    }
//                }
//            }
//            for (int[] ints : last) {
//                grid[ints[0]][ints[1]] = 2;
//            }
//            last.clear();
//            if (allBad) {
//                break;
//            }
//            index++;
//        }
//        // 遍历看看有没有1的
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    return -1;
//                }
//            }
//        }
//        return index;
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // count 表示新鲜橘子的数量
        int count = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
            }
        }
        // round 表示腐烂的轮数，或者分钟数
        int round = 0;
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                if (r-1 >= 0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    count--;
                    queue.add(new int[]{r-1, c});
                }
                if (r+1 < M && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    count--;
                    queue.add(new int[]{r+1, c});
                }
                if (c-1 >= 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    count--;
                    queue.add(new int[]{r, c-1});
                }
                if (c+1 < N && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    count--;
                    queue.add(new int[]{r, c+1});
                }
            }
        }

        if (count > 0) {
            return -1;
        } else {
            return round;
        }
    }
}
