package com.suave.q100_相同的树;

import com.suave.common.TreeNode;
//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//
//
//
// 示例 1：
//
//
//输入：p = [1,2,3], q = [1,2,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：p = [1,2], q = [1,null,2]
//输出：false
//
//
// 示例 3：
//
//
//输入：p = [1,2,1], q = [1,1,2]
//输出：false
//
//
//
//
// 提示：
//
//
// 两棵树上的节点数目都在范围 [0, 100] 内
// -10⁴ <= Node.val <= 10⁴
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 901 👎 0

/**
 * @author suave
 * @date 2022-09-21 19:33
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p == null) {
            return true;
        } else if (q == null || p == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
