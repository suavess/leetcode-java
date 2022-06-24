package com.suave.q515_在每个树行中找最大值;
//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
//
//
//
// 示例1：
//
//
//
//
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
//
//
// 示例2：
//
//
//输入: root = [1,2,3]
//输出: [1,3]
//
//
//
//
// 提示：
//
//
// 二叉树的节点个数的范围是 [0,10⁴]
//
// -2³¹ <= Node.val <= 2³¹ - 1
//
//
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 217 👎 0

import com.suave.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shunxin.jin
 * @date 2022/6/24 09:53
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (result.size() < level + 1) {
            result.add(node.val);
        } else {
            if (result.get(level) < node.val) {
                result.set(level, node.val);
            }
        }
        if (node.left != null) {
            dfs(node.left, level + 1, result);
        }
        if (node.right != null) {
            dfs(node.right, level + 1, result);
        }
    }
}
