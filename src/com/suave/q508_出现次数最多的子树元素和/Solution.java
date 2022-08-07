package com.suave.q508_出现次数最多的子树元素和;
//给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
//
// 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
//
//
//
// 示例 1：
//
//
//
//
//输入: root = [5,2,-3]
//输出: [2,-3,4]
//
//
// 示例 2：
//
//
//
//
//输入: root = [5,2,-5]
//输出: [2]
//
//
//
//
// 提示:
//
//
// 节点数在 [1, 10⁴] 范围内
// -10⁵ <= Node.val <= 10⁵
//
//
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 202 👎 0

import com.suave.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author suave
 * @date 2022-08-07 22:02
 */
public class Solution {
//    public int[] findFrequentTreeSum(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        dfs(root, list);
//        Map<Integer, Long> map = list.parallelStream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        Long max = map.entrySet().parallelStream().map(Map.Entry::getValue).max(Long::compareTo).get();
//        List<Integer> integers = new ArrayList<>();
//        for (Integer key : map.keySet()) {
//            if (map.get(key).equals(max)) {
//                integers.add(key);
//            }
//        }
//        int[] res = new int[integers.size()];
//        int index = 0;
//        for (Integer integer : integers) {
//            res[index++] = integer;
//        }
//        return res;
//    }
//
//    private int dfs(TreeNode node, List<Integer> list) {
//        if (node == null) {
//            return 0;
//        }
//        int left = dfs(node.left, list);
//        int right = dfs(node.right, list);
//        list.add(node.val + left + right);
//        return node.val + left + right;
//    }

    Map<Integer, Integer> cnt = new HashMap<>();
    int maxCnt = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int s = entry.getKey(), c = entry.getValue();
            if (c == maxCnt) {
                list.add(s);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + dfs(node.left) + dfs(node.right);
        cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
        maxCnt = Math.max(maxCnt, cnt.get(sum));
        return sum;
    }
}
