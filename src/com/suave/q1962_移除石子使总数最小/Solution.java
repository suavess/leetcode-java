package com.suave.q1962_移除石子使总数最小;
//给你一个整数数组 piles ，数组 下标从 0 开始 ，其中 piles[i] 表示第 i 堆石子中的石子数量。另给你一个整数 k ，请你执行下述操作 恰
//好 k 次：
//
//
// 选出任一石子堆 piles[i] ，并从中 移除 floor(piles[i] / 2) 颗石子。
//
//
// 注意：你可以对 同一堆 石子多次执行此操作。
//
// 返回执行 k 次操作后，剩下石子的 最小 总数。
//
// floor(x) 为 小于 或 等于 x 的 最大 整数。（即，对 x 向下取整）。
//
//
//
// 示例 1：
//
//
//输入：piles = [5,4,9], k = 2
//输出：12
//解释：可能的执行情景如下：
//- 对第 2 堆石子执行移除操作，石子分布情况变成 [5,4,5] 。
//- 对第 0 堆石子执行移除操作，石子分布情况变成 [3,4,5] 。
//剩下石子的总数为 12 。
//
//
// 示例 2：
//
//
//输入：piles = [4,3,6,7], k = 3
//输出：12
//解释：可能的执行情景如下：
//- 对第 2 堆石子执行移除操作，石子分布情况变成 [4,3,3,7] 。
//- 对第 3 堆石子执行移除操作，石子分布情况变成 [4,3,3,4] 。
//- 对第 0 堆石子执行移除操作，石子分布情况变成 [2,3,3,4] 。
//剩下石子的总数为 12 。
//
//
//
//
// 提示：
//
//
// 1 <= piles.length <= 10⁵
// 1 <= piles[i] <= 10⁴
// 1 <= k <= 10⁵
//
//
// Related Topics 数组 堆（优先队列） 👍 14 👎 0

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author suave
 * @date 2022-09-19 22:18
 */
public class Solution {
    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int pile : piles) {
            queue.offer(pile);
        }
        for (int i = 0; i < k; i++) {
            Integer poll = queue.poll();
            queue.offer(poll % 2 == 0 ? poll / 2 : (poll + 1) / 2);
        }
        int sum = 0;
        for (Integer num : queue) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minStoneSum(new int[]{4,3,6,7}, 3));
    }
}
