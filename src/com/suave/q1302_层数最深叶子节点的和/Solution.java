package com.suave.q1302_层数最深叶子节点的和;
//给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
//
//
// 示例 2：
//
//
//输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：19
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [1, 10⁴] 之间。
// 1 <= Node.val <= 100
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 122 👎 0

import com.suave.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author shunxin.jin
 * @date 2022/8/17 14:57
 */
public class Solution {
    int sum = 0, maxDepth = 0;

    public int deepestLeavesSum(TreeNode root) {
        // BFS
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//        int sum = 0;
//        while (!queue.isEmpty()) {
//            sum = 0;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode poll = queue.poll();
//                if (poll.left != null) {
//                    queue.add(poll.left);
//                }
//                if (poll.right != null) {
//                    queue.add(poll.right);
//                }
//                sum += poll.val;
//            }
//        }
//        return sum;

        // DFS
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level > maxDepth) {
            maxDepth = level;
            sum = node.val;
        } else if (level == maxDepth){
            sum += node.val;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        System.out.println(new Solution().deepestLeavesSum(node));
    }
}

