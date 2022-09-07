package com.suave.q94_二叉树的中序遍历;
//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1554 👎 0

import com.suave.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author suave
 * @date 2022-09-07 20:13
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 递归
//        List<Integer> res = new ArrayList<>();
//        dfs(root, res);
//        return res;
        // 迭代
        if (root == null) {
            return new ArrayList<>(0);
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            if (stack.peek().left != null) {
                TreeNode left = stack.peek().left;
                stack.peek().left = null;
                stack.push(left);
                continue;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return res;
    }

//    private void dfs(TreeNode node, List<Integer> list){
//        if (node == null) {
//            return;
//        }
//        dfs(node.left, list);
//        list.add(node.val);
//        dfs(node.right, list);
//    }

    public static void main(String[] args) {
        new Solution().inorderTraversal(null);
    }
}
