package com.suave.q513_找树左下角的值;

//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
//
// 假设二叉树中至少有一个节点。
//
//
//
// 示例 1:
//
//
//
//
//输入: root = [2,1,3]
//输出: 1
//
//
// 示例 2:
//
//
//
//
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
//
//
//
//
// 提示:
//
//
// 二叉树的节点个数的范围是 [1,10⁴]
//
// -2³¹ <= Node.val <= 2³¹ - 1
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 310 👎 0

import com.suave.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shunxin.jin
 * @date 2022/6/22 11:15
 */
public class Solution {
    int curVal = 0;
    int curHeight = 0;

    public int findBottomLeftValue(TreeNode root) {
        // 广度优先
//        List<List<Integer>> list = new ArrayList<>();
//        layer(root, 0, list);
//        return list.get(list.size()-1).get(0);
        // 深度优先
        dfs(root, 0);
        return curVal;
    }

    private void layer(TreeNode node, int level, List<List<Integer>> list){
        if (list.size() < level + 1) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(node.val);
            list.add(tmp);
        } else {
            list.get(level).add(node.val);
        }
        if (node.left != null) {
            layer(node.left, level+1, list);
        }
        if (node.right != null) {
            layer(node.right, level+1, list);
        }
    }

    public void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        height++;
        dfs(root.left, height);
        dfs(root.right, height);
        if (height > curHeight) {
            curHeight = height;
            curVal = root.val;
        }
    }

}
