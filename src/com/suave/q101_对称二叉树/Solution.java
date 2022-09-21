package com.suave.q101_对称二叉树;
//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,2,3,4,4,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,null,3,null,3]
//输出：false
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [1, 1000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2115 👎 0

import com.suave.common.TreeNode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author suave
 * @date 2022-09-21 19:43
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // 层序遍历,看每一层是否一样
//        List<TreeNode> list = new ArrayList<>();
//        list.add(root);
//        while (!list.isEmpty()) {
//            List<TreeNode> layer = new ArrayList<>();
//            for (TreeNode treeNode : list) {
//                if (treeNode == null) {
//                    continue;
//                }
//                layer.add(treeNode.left);
//                layer.add(treeNode.right);
//            }
//            // 遍历layer
//            for (int i = 0; i < layer.size() / 2; i++) {
//                if (layer.get(i) == null && layer.get(layer.size() - i - 1) == null) {
//                } else if (layer.get(i) == null) {
//                    return false;
//                } else if (layer.get(layer.size() - i - 1) == null) {
//                    return false;
//                } else if (layer.get(i).val != layer.get(layer.size() - i - 1).val) {
//                    return false;
//                }
//            }
//            list = layer;
//        }
//        return true;
        // dfs
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode node, TreeNode node2){
        if (node == null && node2 == null) {
            return true;
        }
        if (node == null || node2 == null) {
            return false;
        }
        return node.val == node2.val && dfs(node.left, node2.right) && dfs(node.right, node2.left);
    }
}
