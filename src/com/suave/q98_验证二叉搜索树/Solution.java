package com.suave.q98_验证二叉搜索树;
//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
// 有效 二叉搜索树定义如下：
//
//
// 节点的左子树只包含 小于 当前节点的数。
// 节点的右子树只包含 大于 当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
//
//
// 示例 1：
//
//
//输入：root = [2,1,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
//
//
//
//
// 提示：
//
//
// 树中节点数目范围在[1, 10⁴] 内
// -2³¹ <= Node.val <= 2³¹ - 1
//
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1702 👎 0

import com.suave.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suave
 * @date 2022-08-07 14:20
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        // 中序遍历为升序排列
//        List<Integer> res = new ArrayList<>();
//        dfs(root, res);
//        for (int i = 1; i < res.size(); i++) {
//            if (res.get(i) <= res.get(i - 1)) {
//                return false;
//            }
//        }
//        return true;
        // 直接判断
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

//    private void dfs(TreeNode node, List<Integer> res) {
//        if (node == null) {
//            return;
//        }
//        dfs(node.left, res);
//        res.add(node.val);
//        dfs(node.right, res);
//    }

    private boolean dfs(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }
}
