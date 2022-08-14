package com.suave.q230_二叉搜索树中第K小的元素;
//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
//
//
//
// 示例 1：
//
//
//输入：root = [3,1,4,null,2], k = 1
//输出：1
//
//
// 示例 2：
//
//
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
//
//
//
//
//
//
// 提示：
//
//
// 树中的节点数为 n 。
// 1 <= k <= n <= 10⁴
// 0 <= Node.val <= 10⁴
//
//
//
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 651 👎 0

import com.suave.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author suave
 * @date 2022-08-14 23:23
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
//        List<Integer> list = new ArrayList<>();
//        dfs(root, list, k);
//        return list.get(list.size() - 1);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }

    private void dfs(TreeNode node, List<Integer> res, int k) {
        if (node == null) {
            return;
        }
        dfs(node.left, res, k);
        if (res.size() == k) {
            return;
        }
        res.add(node.val);
        dfs(node.right, res, k);
    }

}
