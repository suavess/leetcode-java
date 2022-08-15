package com.suave.q641_设计循环双端队列;
//设计实现双端队列。
//
// 实现 MyCircularDeque 类:
//
//
// MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
// boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
// boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
// boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
// boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
// int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
// int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
// boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false 。
// boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
//
//
//
//
// 示例 1：
//
//
//输入
//["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront",
//"getRear", "isFull", "deleteLast", "insertFront", "getFront"]
//[[3], [1], [2], [3], [4], [], [], [], [4], []]
//输出
//[null, true, true, true, false, 2, true, true, true, 4]
//
//解释
//MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
// 
//
//
//
// 提示：
//
//
// 1 <= k <= 1000
// 0 <= value <= 1000
// insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty,
// isFull 调用次数不大于 2000 次
//
//
// Related Topics 设计 队列 数组 链表 👍 175 👎 0

/**
 * @author suave
 * @date 2022-08-15 21:34
 */
public class MyCircularDeque {
    int right = 0;
    private int[] element;

    public MyCircularDeque(int k) {
        element = new int[k];
    }

    public boolean insertFront(int value) {
        if (right == element.length) {
            return false;
        }
        int[] tmp = new int[element.length];
        System.arraycopy(element, 0, tmp, 1, element.length -1);
        element = tmp;
        element[0] = value;
        right++;
        return true;
    }

    public boolean insertLast(int value) {
        if (right == element.length) {
            return false;
        }
        element[right++] = value;
        return true;
    }

    public boolean deleteFront() {
        if (right == 0) {
            return false;
        }
        int[] tmp = new int[element.length];
        System.arraycopy(element, 1, tmp, 0, element.length -1);
        element = tmp;
        right--;
        return true;
    }

    public boolean deleteLast() {
        if (right == 0) {
            return false;
        }
        right--;
        return true;
    }

    public int getFront() {
        return right == 0 ? -1 : element[0];
    }

    public int getRear() {
        return right == 0 ? -1 : element[right - 1];
    }

    public boolean isEmpty() {
        return right == 0;
    }

    public boolean isFull() {
        return right == element.length;
    }

    public static void main(String[] args) {

    }
}
