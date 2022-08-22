package com.suave.q655_输出二叉树;
//给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩
//阵需要遵循以下规则：
//
//
// 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
// 矩阵的列数 n 应该等于 2ʰᵉⁱᵍʰᵗ⁺¹ - 1 。
// 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
// 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] ，右子节点放置在
//res[r+1][c+2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] 。
// 继续这一过程，直到树中的所有节点都妥善放置。
// 任意空单元格都应该包含空字符串 "" 。
//
//
// 返回构造得到的矩阵 res 。
//
//
//
//
//
// 示例 1：
//
//
//输入：root = [1,2]
//输出：
//[["","1",""],
// ["2","",""]]
//
//
// 示例 2：
//
//
//输入：root = [1,2,3,null,4]
//输出：
//[["","","","1","","",""],
// ["","2","","","","3",""],
// ["","","4","","","",""]]
//
//
//
//
// 提示：
//
//
// 树中节点数在范围 [1, 2¹⁰] 内
// -99 <= Node.val <= 99
// 树的深度在范围 [1, 10] 内
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 187 👎 0

import com.suave.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author suave
 * @date 2022-08-22 22:32
 */
public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int depth = getDepth(root);
        int width = (1 << depth) - 1;
        // 构建二维list
        List<List<String>> res = new ArrayList<>(depth);
        for (int i = 0; i < depth; i++) {
            List<String> tmp = new ArrayList<>(width);
            for (int j = 0; j < width; j++) {
                tmp.add("");
            }
            res.add(tmp);
        }
        dfs(res, root, 0, 0, width);
        return res;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    private void dfs(List<List<String>> res, TreeNode node, int level, int left, int right) {
        if (node == null) {
            return;
        }
        res.get(level).set((left + right) / 2, String.valueOf(node.val));
        dfs(res, node.left, level + 1, left, (left + right) / 2);
        dfs(res, node.right, level + 1, (left + right) / 2, right);
    }

    public static void main(String[] args) {

    }
}
