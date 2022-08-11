package com.suave.q640_求解方程;
//求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
//
// 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
//
// 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
//
//
//
// 示例 1：
//
//
//输入: equation = "x+5-3+x=6+x-2"
//输出: "x=2"
//
//
// 示例 2:
//
//
//输入: equation = "x=x"
//输出: "Infinite solutions"
//
//
// 示例 3:
//
//
//输入: equation = "2x=x"
//输出: "x=0"
//
//
//
//
// 提示:
//
//
// 3 <= equation.length <= 1000
// equation 只有一个 '='.
// equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。
//
//
// Related Topics 数学 字符串 模拟 👍 132 👎 0

/**
 * @author shunxin.jin
 * @date 2022/8/10 10:56
 */
public class Solution {
    public String solveEquation(String equation) {
        boolean left = true;
        boolean add = true;
        int xCnt = 0;
        int num = -1;
        int sum = 0;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '+') {
                if (num != -1) {
                    if (add) {
                        sum += num;
                    } else {
                        sum -= num;
                    }
                }
                if (left) {
                    add = true;
                } else {
                    add = false;
                }
                num = -1;
            } else if (equation.charAt(i) == '-') {
                if (num != -1) {
                    if (add) {
                        sum += num;
                    } else {
                        sum -= num;
                    }
                }
                if (left) {
                    add = false;
                } else {
                    add = true;
                }
                num = -1;
            } else if (equation.charAt(i) == 'x') {
                num = num == -1 ? 1 : num;
                for (int j = 0; j < num; j++) {
                    if (add) {
                        xCnt++;
                    } else {
                        xCnt--;
                    }
                }
                num = -1;
            } else if (equation.charAt(i) == '=') {
                if (num != -1) {
                    if (add) {
                        sum += num;
                    } else {
                        sum -= num;
                    }
                    num = -1;
                }
                left = false;
                add = false;
            } else {
                // 数字
                if (num == -1) {
                    num = equation.charAt(i) - '0';
                } else {
                    num = num * 10 + equation.charAt(i) - '0';
                }
            }
        }
        if (num != -1) {
            if (add) {
                sum += num;
            } else {
                sum -= num;
            }
        }
        if (xCnt == 0) {
            if (sum == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        return "x=" + (-sum / xCnt);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveEquation("x+5-3+x=6+x-2"));
    }
}
