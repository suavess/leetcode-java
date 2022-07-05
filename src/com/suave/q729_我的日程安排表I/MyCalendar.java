package com.suave.q729_我的日程安排表I;

import com.suave.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shunxin.jin
 * @date 2022/7/5 09:14
 */
public class MyCalendar {

    public List<TreeNode> list = new ArrayList<>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        int mid = (start + end) / 2;
        if (list.isEmpty()) {
            TreeNode node = new TreeNode(mid);
            node.left = new TreeNode(start);
            node.right = new TreeNode(end);
            list.add(node);
            return true;
        }
        int startIndex = 0, endIndex = list.size() - 1;
        while (startIndex <= endIndex) {
            int index = (startIndex + endIndex) / 2;
            TreeNode node = list.get(index);
            if (node.val == mid) {
                return false;
            }
            if (node.val < mid) {
                // 平均值大于列表中该节点的值,判断左值是否大于该右节点的值
                if (start < node.right.val) {
                    // 小于说明在该节点范围内,返回false
                    return false;
                }
                // 大于或等于就继续循环
                startIndex = index + 1;
            } else {
                // 平均值小于列表中该节点的值,判断右值是否小于该左节点的值
                if (end > node.left.val) {
                    // 小于说明在该节点范围内,返回false
                    return false;
                }
                endIndex = index - 1;
            }
        }
        // 插入并保持顺序
        TreeNode node = new TreeNode(mid);
        node.left = new TreeNode(start);
        node.right = new TreeNode(end);
        if (list.get(list.size() - 1).val <= node.val) {
            list.add(node);
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).val >= node.val) {
                    list.add(i, node);
                    break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(20, 29));
        System.out.println(myCalendar.book(13, 22));
        System.out.println(myCalendar.book(44, 50));
        System.out.println(myCalendar.book(45, 50));
    }
}
