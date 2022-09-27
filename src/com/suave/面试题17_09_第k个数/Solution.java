package com.suave.面试题17_09_第k个数;
//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 25 27 35 45 49 63 75 81
//
// 示例 1:
//
// 输入: k = 5
//
//输出: 9
//
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 100 👎 0

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author shunxin.jin
 * @date 2022/9/28 00:28
 */
public class Solution {
    public int getKthMagicNumber(int k) {
//        if (k == 1) {
//            return 1;
//        }
//        if (k == 2) {
//            return 3;
//        }
//        if (k == 3) {
//            return 5;
//        }
//        if (k == 4) {
//            return 7;
//        }
//        int[] res = new int[k];
//        res[0] = 1;
//        res[1] = 3;
//        res[2] = 5;
//        res[3] = 7;
//        for (int i = 4; i < k; i++) {
//            // 取大于res[i-1]的最小数
//            long min = Long.MAX_VALUE;
//            for (int j = 0; j < i; j++) {
//                if (res[j] * 3 > res[i - 1]) {
//                    min = Math.min(res[j] * 3L, min);
//                }
//                if (res[j] * 5 > res[i - 1]) {
//                    min = Math.min(res[j] * 5L, min);
//                }
//                if (res[j] * 7 > res[i - 1]) {
//                    min = Math.min(res[j] * 7L, min);
//                }
//            }
//            res[i] = (int) min;
//        }
//        return res[k - 1];
        // 优先队列加哈希表
        int[] factors = {3, 5, 7};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < k; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getKthMagicNumber(10));
    }
}
