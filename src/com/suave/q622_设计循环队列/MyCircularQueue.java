package com.suave.q622_设计循环队列;
//设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”
//。
//
// 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环
//队列，我们能使用这些空间去存储新的值。
//
// 你的实现应该支持如下操作：
//
//
// MyCircularQueue(k): 构造器，设置队列长度为 k 。
// Front: 从队首获取元素。如果队列为空，返回 -1 。
// Rear: 获取队尾元素。如果队列为空，返回 -1 。
// enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
// deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
// isEmpty(): 检查循环队列是否为空。
// isFull(): 检查循环队列是否已满。
//
//
//
//
// 示例：
//
// MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
//circularQueue.enQueue(1);  // 返回 true
//circularQueue.enQueue(2);  // 返回 true
//circularQueue.enQueue(3);  // 返回 true
//circularQueue.enQueue(4);  // 返回 false，队列已满
//circularQueue.Rear();  // 返回 3
//circularQueue.isFull();  // 返回 true
//circularQueue.deQueue();  // 返回 true
//circularQueue.enQueue(4);  // 返回 true
//circularQueue.Rear();  // 返回 4
//
//
//
// 提示：
//
//
// 所有的值都在 0 至 1000 的范围内；
// 操作数将在 1 至 1000 的范围内；
// 请不要使用内置的队列库。
//
//
// Related Topics 设计 队列 数组 链表 👍 362 👎 0


import com.suave.common.ListNode;

/**
 * @author shunxin.jin
 * @date 2022/8/2 18:58
 */
public class MyCircularQueue {

    /**
     * 实际队列中元素数量
     */
    private int size;

    /**
     * 队列长度
     */
    private int[] element;

    public MyCircularQueue(int k) {
        this.size = 0;
        element = new int[k];
    }

    public boolean enQueue(int value) {
        if (size == element.length) {
            return false;
        }
        element[size++] = value;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        int[] copyArr = new int[element.length];
        System.arraycopy(element, 1, copyArr, 0, size - 1);
        element = copyArr;
        size--;
        return true;
    }

    public int Front() {
        if (size == 0) {
            return -1;
        }
        return element[0];
    }

    public int Rear() {
        if (size == 0) {
            return -1;
        }
        return element[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == element.length;
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.deQueue();
        queue.enQueue(4);
        System.out.println(queue.Rear());

    }
}
