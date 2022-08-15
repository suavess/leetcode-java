package com.suave.q2_两数相加;
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
//
// Related Topics 递归 链表 数学 👍 8507 👎 0

import com.suave.common.ListNode;
import com.sun.org.apache.bcel.internal.generic.IMPDEP1;

/**
 * @author suave
 * @date 2022-08-15 22:19
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode((l1.val + l2.val) % 10);
        ListNode node = root;
        boolean carry = l1.val + l2.val >= 10;
        while (l1.next != null || l2.next != null) {
            int l1Val = 0, l2Val = 0;
            if (l1.next != null) {
                l1Val = l1.next.val;
                l1 = l1.next;
            }
            if (l2.next != null) {
                l2Val = l2.next.val;
                l2 = l2.next;
            }
            if (carry) {
                node.next = new ListNode((l1Val + l2Val + 1) % 10);
                if (l1Val + l2Val + 1 < 10) {
                    carry = false;
                }
            } else {
                node.next = new ListNode((l1Val + l2Val) % 10);
                if (l1Val + l2Val >= 10) {
                    carry = true;
                }
            }
            node = node.next;
        }
        if (carry) {
            node.next = new ListNode(1);
        }
        return reserve(root);
    }

    public ListNode reserve(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reHead = reserve(head.next);
        head.next.next = head;
        head.next = null;
        return reHead;
    }

}
