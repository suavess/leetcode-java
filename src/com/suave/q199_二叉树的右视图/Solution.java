package com.suave.q199_二叉树的右视图;
//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
//
//
// 示例 1:
//
//
//
//
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
//
//
// 示例 2:
//
//
//输入: [1,null,3]
//输出: [1,3]
//
//
// 示例 3:
//
//
//输入: []
//输出: []
//
//
//
//
// 提示:
//
//
// 二叉树的节点个数的范围是 [0,100]
//
// -100 <= Node.val <= 100
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 726 👎 0

import com.suave.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suave
 * @date 2022-07-18 21:28
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // 层序遍历
//        List<Integer> result = new ArrayList<>();
//        if (Objects.isNull(root)) {
//            return result;
//        }
//        List<TreeNode> list = new ArrayList<>();
//        list.add(root);
//        while (!list.isEmpty()) {
//            result.add(list.get(list.size() - 1).val);
//            ArrayList<TreeNode> temp = new ArrayList<>(list);
//            list.clear();
//            for (TreeNode treeNode : temp) {
//                if (treeNode.left != null){
//                    list.add(treeNode.left);
//                }
//                if (treeNode.right != null){
//                    list.add(treeNode.right);
//                }
//            }
//        }
//        return result;

        // 深度优先
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, Integer level, List<Integer> result){
        if (node == null){
            return;
        }
        if (result.size() == level) {
            result.add(node.val);
        }
        if (node.right != null){
            dfs(node.right, level + 1, result);
        }
        if (node.left != null){
            dfs(node.left, level + 1, result);
        }
    }
}
