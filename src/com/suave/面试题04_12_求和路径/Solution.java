package com.suave.面试题04_12_求和路径;
//给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的
//根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
//
// 示例: 给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// 3
//解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
//
// 提示：
//
//
// 节点总数 <= 10000
//
//
// Related Topics 树 深度优先搜索 二叉树 👍 114 👎 0

import com.suave.common.TreeNode;

/**
 * @author suave
 * @date 2022-07-04 20:59
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 从根节点出发有多少种
        int k = dfs(root, sum);
        if (root.left != null) {
            k += pathSum(root.left, sum);
        }
        if (root.right != null) {
            k += pathSum(root.right, sum);
        }
        return k;
    }

    private int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int k = 0;
        if (node.val == sum) {
            // 可能后面的节点之和为0,不能直接返回1
//            return 1;
            k++;
        }
        if (node.left != null) {
            k += dfs(node.left, sum - node.val);
        }
        if (node.right != null) {
            k += dfs(node.right, sum - node.val);
        }
        return k;
    }
}
