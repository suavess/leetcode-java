package com.suave.剑指OfferII083_没有重复元素集合的全排列;
//给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
//
//
//
//
// 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/
//
// Related Topics 数组 回溯 👍 28 👎 0

import org.jcp.xml.dsig.internal.dom.DOMTransform;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author suave
 * @date 2022-08-18 21:05
 */
public class Solution {
    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        List<List<Integer>> res = new ArrayList<>();
        // 用于保存遍历过的下标
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> used = new HashSet<>();
            used.add(i);
            LinkedList<Integer> list = new LinkedList<>();
            list.add(nums[i]);
            dfs(res, nums.length, used, list);
        }
        return res;
    }

    private void dfs(List<List<Integer>> res, int n, Set<Integer> used, LinkedList<Integer> list) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used.contains(i)) {
                used.add(i);
                list.add(nums[i]);
                dfs(res, n, used, list);
                used.remove(i);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3, 4}));
    }
}
