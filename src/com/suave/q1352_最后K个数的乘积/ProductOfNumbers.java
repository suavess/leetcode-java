package com.suave.q1352_最后K个数的乘积;
//请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
//
// 1. add(int num)
//
//
// 将数字 num 添加到当前数字列表的最后面。
//
//
// 2. getProduct(int k)
//
//
// 返回当前数字列表中，最后 k 个数字的乘积。
// 你可以假设当前列表中始终 至少 包含 k 个数字。
//
//
// 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
//
//
//
// 示例：
//
// 输入：
//["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct",
//"getProduct","add","getProduct"]
//[[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
//
//输出：
//[null,null,null,null,null,null,20,40,0,null,32]
//
//解释：
//ProductOfNumbers productOfNumbers = new ProductOfNumbers();
//productOfNumbers.add(3);        // [3]
//productOfNumbers.add(0);        // [3,0]
//productOfNumbers.add(2);        // [3,0,2]
//productOfNumbers.add(5);        // [3,0,2,5]
//productOfNumbers.add(4);        // [3,0,2,5,4]
//productOfNumbers.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
//productOfNumbers.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
//productOfNumbers.getProduct(4); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
//productOfNumbers.add(8);        // [3,0,2,5,4,8]
//productOfNumbers.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
//
//
//
//
// 提示：
//
//
// add 和 getProduct 两种操作加起来总共不会超过 40000 次。
// 0 <= num <= 100
// 1 <= k <= 40000
//
//
// Related Topics 设计 队列 数组 数学 数据流 👍 83 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @author suave
 * @date 2022-08-08 20:55
 */
public class ProductOfNumbers {
//    暴力解法
//    private final List<Integer> list = new ArrayList<>();
//
//    /**
//     * 最后一个0的索引位置
//     */
//    private int lastIndex = -1;
//
//    public ProductOfNumbers() {
//    }
//
//    public void add(int num) {
//        list.add(num);
//        if (num == 0 && list.size() - 1 > lastIndex) {
//            lastIndex = list.size() - 1;
//        }
//    }
//
//    public int getProduct(int k) {
//        if (lastIndex > list.size() - k){
//            return 0;
//        }
//        int size = list.size();
//        int res = list.get(size - 1);
//        for (int i = size - 2; i >= size - k; i--) {
//            res *= list.get(i);
//        }
//        return res;
//    }

    /**
     * 第i个元素表示到i为止的乘积
     */
    private List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        if(num == 0) {
            list.clear();
            return;
        }
        if(list.isEmpty()) {
            list.add(1);
        }
        list.add(list.get(list.size() - 1) * num);
    }

    public int getProduct(int k) {
        if(k >= list.size()) {
            return 0;
        }
        return list.get(list.size() - 1) / list.get(list.size() - 1 - k);
    }

    public static void main(String[] args) {
        /**
         * ["ProductOfNumbers","add","add","add","getProduct","add","add","add","getProduct","getProduct","getProduct","add","add"]
         * [[],[0],[0],[9],[3],[8],[3],[8],[5],[4],[6],[8],[8]]
         */
        ProductOfNumbers numbers = new ProductOfNumbers();
        numbers.add(0);
        numbers.add(0);
        numbers.add(9);
        System.out.println(numbers.getProduct(3));
        numbers.add(8);
        numbers.add(3);
        numbers.add(8);
        System.out.println(numbers.getProduct(5));
        System.out.println(numbers.getProduct(4));
        System.out.println(numbers.getProduct(8));
        numbers.add(8);
        numbers.add(8);
    }
}
