package com.suave.q1331_数组序号转换;
//给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
//
// 序号代表了一个元素有多大。序号编号的规则如下：
//
//
// 序号从 1 开始编号。
// 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
// 每个数字的序号都应该尽可能地小。
//
//
//
//
// 示例 1：
//
// 输入：arr = [40,10,20,30]
//输出：[4,1,2,3]
//解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
//
// 示例 2：
//
// 输入：arr = [100,100,100]
//输出：[1,1,1]
//解释：所有元素有相同的序号。
//
//
// 示例 3：
//
// 输入：arr = [37,12,28,9,100,56,80,5,12]
//输出：[5,3,4,2,8,6,7,1,3]
//
//
//
//
// 提示：
//
//
// 0 <= arr.length <= 10⁵
// -10⁹ <= arr[i] <= 10⁹
//
//
// Related Topics 数组 哈希表 排序 👍 90 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author shunxin.jin
 * @date 2022/7/28 15:01
 */
public class Solution {
    public int[] arrayRankTransform(int[] arr) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int[] temp = Arrays.copyOf(arr, arr.length);
//        Arrays.sort(temp);
//        int i = 1;
//        for (int num : temp) {
//            if (Objects.isNull(map.putIfAbsent(num, i))) {
//                i++;
//            }
//        }
//        for (int j = 0; j < arr.length; j++) {
//            arr[j] = map.get(arr[j]);
//        }
//        return arr;
        // 不需要额外新建数组,但是超时了....
        int index = 1;
        Set<Integer> set = new HashSet<>();
        while (true) {
            if (set.size() == arr.length) {
                break;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (set.contains(i)){
                    continue;
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (set.contains(i)){
                    continue;
                }
                if (arr[i] == min) {
                    arr[i] = index;
                    set.add(i);
                }
            }
            index++;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12})));
    }
}
