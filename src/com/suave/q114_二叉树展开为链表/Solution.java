package com.suave.q114_二叉树展开为链表;
//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。
//
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
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
//输入：root = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 树中结点数在范围 [0, 2000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
//
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1253 👎 0

import com.suave.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shunxin.jin
 * @date 2022/7/29 10:13
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> result = new ArrayList<>();
        dfs(root, result);
        for (int i = 0; i < result.size() - 1; i++) {
            result.get(i).left = null;
            result.get(i).right = result.get(i + 1);
        }
        result.get(result.size() - 1).left = null;
        result.get(result.size() - 1).right = null;
        root = result.get(0);
    }

    private void dfs(TreeNode node, List<TreeNode> result) {
        if (node == null) {
            return;
        }
        result.add(node);
        dfs(node.left, result);
        dfs(node.right, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        new Solution().flatten(root);
    }
}
