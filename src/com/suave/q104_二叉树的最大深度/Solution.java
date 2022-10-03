package com.suave.q104_二叉树的最大深度;

import com.suave.common.TreeNode;

import java.util.logging.Level;
//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例： 给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1393 👎 0

/**
 * @author shunxin.jin
 * @date 2022/10/3 11:30
 */
public class Solution {

    private int max = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return max;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        max = Math.max(level, max);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
