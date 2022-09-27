package com.suave.面试题04_03_特定深度节点链表;
//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
//
//
//
// 示例：
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \
//      2    3
//     / \    \
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
//
//
// Related Topics 树 广度优先搜索 链表 二叉树 👍 77 👎 0

import com.suave.common.ListNode;
import com.suave.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shunxin.jin
 * @date 2022/7/5 19:15
 */
public class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> list = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            List<TreeNode> tmp = new ArrayList<>();
            ListNode root = new ListNode(queue.get(0).val);
            ListNode current = root;
            for (int i = 0; i < queue.size(); i++) {
                TreeNode treeNode = queue.get(i);
                if (treeNode.left != null) {
                    tmp.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    tmp.add(treeNode.right);
                }
                if (i != 0) {
                    current.next = new ListNode(treeNode.val);
                    current = current.next;
                }
            }
            queue = tmp;
            list.add(root);
        }
        ListNode[] result = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        ListNode[] listNodes = new Solution().listOfDepth(root);
        for (int i = 0; i < listNodes.length; i++) {
            ListNode listNode = listNodes[i];
            System.out.println(listNode.val);
            while (listNode.next != null) {
                System.out.println(listNode.next.val);
                listNode = listNode.next;
            }
            System.out.println("---");
        }
    }
}
