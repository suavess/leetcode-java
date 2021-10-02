package com.suave.q1670_设计前中后队列;

import com.sun.codemodel.internal.JForEach;

/**
 * @author shunxin.jin
 * @date 2021/10/2 1:42 下午
 */
public class Solution {
    public static void main(String[] args) {
        FrontMiddleBackQueue frontMiddleBackQueue = new FrontMiddleBackQueue();
        frontMiddleBackQueue.pushMiddle(2);
        frontMiddleBackQueue.pushMiddle(9);
        System.out.println(frontMiddleBackQueue.popMiddle());
        frontMiddleBackQueue.pushMiddle(6);
        frontMiddleBackQueue.pushMiddle(6);
        frontMiddleBackQueue.pushMiddle(5);
        System.out.println(frontMiddleBackQueue.popMiddle());
        System.out.println(frontMiddleBackQueue.popMiddle());
        frontMiddleBackQueue.pushMiddle(6);

    }
}

class FrontMiddleBackQueue {

    private Node head;
    private Node tail;
    private int len;

    public FrontMiddleBackQueue() {
        len = 0;
        head = null;
        tail = null;
    }

    public void pushFront(int val) {
        Node temp = new Node(val);
        if (len == 0) {
            head = temp;
            tail = temp;
            len++;
            return;
        }
        head.pre = temp;
        temp.next = head;
        head = temp;
        len++;
    }

    public void pushMiddle(int val) {
        if (len == 0) {
            pushFront(val);
            return;
        }
        if (len == 1) {
            pushFront(val);
            return;
        }
        Node node = head;
        for (int i = 0; i < len / 2 - 1; i++) {
            node = node.next;
        }
        Node temp = new Node(val);
        node.next.pre = temp;
        temp.next = node.next;
        temp.pre = node;
        node.next = temp;
        len++;
    }

    public void pushBack(int val) {
        Node temp = new Node(val);
        if (len == 0) {
            head = temp;
            tail = temp;
            len++;
            return;
        }
        temp.pre = tail;
        tail.next = temp;
        tail = temp;
        len++;
    }

    public int popFront() {
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            int val = head.val;
            len = 0;
            head = null;
            tail = null;
            return val;
        }
        int val = head.val;
        head = head.next;
        head.pre = null;
        len--;
        return val;
    }

    public int popMiddle() {
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            int val = head.val;
            len = 0;
            head = null;
            tail = null;
            return val;
        }
        if (len == 2) {
            int val = head.val;
            len = 1;
            head = tail;
            return val;
        }
        Node node = head;
        for (int i = 0; i < (len - 1) / 2; i++) {
            node = node.next;
        }
        int val = node.val;
        Node next = node.next;
        Node pre = node.pre;
        pre.next = next;
        next.pre = pre;
        len--;
        return val;
    }

    public int popBack() {
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            int val = head.val;
            len = 0;
            head = null;
            tail = null;
            return val;
        }
        int val = tail.val;
        tail = tail.pre;
        tail.next = null;
        len--;
        return val;
    }

}
class Node {
    public Node pre;
    public Node next;
    public int val;

    public Node(int val) {
        this.val = val;
    }
}