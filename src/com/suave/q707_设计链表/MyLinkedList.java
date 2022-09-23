package com.suave.q707_设计链表;
//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
//
// 在链表类中实现这些功能：
//
//
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
//
//
//
//
// 示例：
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
//
//
//
//
// 提示：
//
//
// 所有val值都在 [1, 1000] 之内。
// 操作次数将在 [1, 1000] 之内。
// 请不要使用内置的 LinkedList 库。
//
//
// Related Topics 设计 链表 👍 628 👎 0

import com.suave.common.ListNode;

/**
 * @author suave
 * @date 2022-09-23 22:06
 */
public class MyLinkedList {

    private ListNode root;

    private int size;

    public MyLinkedList() {
        size = 0;
        root = null;
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        ListNode current = root;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        root = new ListNode(val, root);
        size++;
    }

    public void addAtTail(int val) {
        if (root == null) {
            addAtHead(val);
            return;
        }
        ListNode current = root;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        ListNode current = root;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        ListNode next = current.next;
        ListNode node = new ListNode(val);
        current.next = node;
        node.next = next;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        if (index == 0) {
            root = root.next;
            size--;
            return;
        }
        ListNode current = root;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }


    public static void main(String[] args) {
        //["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        //[[],[1],[3],[1,2],[1],[1],[1]]
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1,2);
        list.get(1);
        list.deleteAtIndex(1);
        list.get(1);
    }
}
