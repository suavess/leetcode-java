package com.suave.q662_二叉树最大宽度;
//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
//
// 树的 最大宽度 是所有层中最大的 宽度 。
//
//
//
// 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的
//null 节点，这些 null 节点也计入长度。
//
//
//
// 题目数据保证答案将会在 32 位 带符号整数范围内。
//
//
//
// 示例 1：
//
//
//输入：root = [1,3,2,5,3,null,9]
//输出：4
//解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
//
//
// 示例 2：
//
//
//输入：root = [1,3,2,5,null,null,9,6,null,7]
//输出：7
//解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
//
//
// 示例 3：
//
//
//输入：root = [1,3,2,5]
//输出：2
//解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
//
//
//
//
// 提示：
//
//
// 树中节点的数目范围是 [1, 3000]
// -100 <= Node.val <= 100
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 482 👎 0

import com.suave.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author suave
 * @date 2022-08-27 22:15
 */
public class Solution {

    Map<Integer, Integer> levelMin = new HashMap<>();
    private int max = 1;
    public int widthOfBinaryTree(TreeNode root) {
        // bfs
        /**
         *                   a(1)(index)
         *                /              \
         *          b(2)(2*index)   c(3)(2*index+1)
         *        /    \                 /  \
         *     d(4)                          e(7)
         *
         */
//        int res = 1;
//        Map<Long, TreeNode> map = new HashMap<>();
//        map.put(1L, root);
//        while (true) {
//            long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
//            Map<Long, TreeNode> tmp = new HashMap<>();
//            for (Map.Entry<Long, TreeNode> entry : map.entrySet()) {
//                if (entry.getValue().left != null) {
//                    tmp.put(2 * entry.getKey(), entry.getValue().left);
//                    min = Math.min(min, 2 * entry.getKey());
//                    max = Math.max(max, 2 * entry.getKey());
//                }
//                if (entry.getValue().right != null) {
//                    tmp.put(2 * entry.getKey() + 1, entry.getValue().right);
//                    min = Math.min(min, 2 * entry.getKey() + 1);
//                    max = Math.max(max, 2 * entry.getKey() + 1);
//                }
//            }
//            if (tmp.isEmpty()) {
//                break;
//            }
//            if (min < max){
//                res = (int) Math.max(res, max - min + 1);
//            }
//            map = tmp;
//        }
//        return res;
        // dfs
        dfs(root, 1, 1);
        return max;
    }

    private void dfs(TreeNode node, int level, int index){
        if (node == null) {
            return;
        }
        dfs(node.left, level + 1, index * 2);
        levelMin.putIfAbsent(level, index);
        dfs(node.right, level + 1, index * 2 + 1);
        max = Math.max(max, index - levelMin.get(level) + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Solution().widthOfBinaryTree(root));
    }
}
