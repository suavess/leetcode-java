package com.suave.q593_有效的正方形;
//给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。
//
// 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
//
// 一个 有效的正方形 有四条等边和四个等角(90度角)。
//
//
//
// 示例 1:
//
//
//输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//输出: True
//
//
// 示例 2:
//
//
//输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
//输出：false
//
//
// 示例 3:
//
//
//输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
//输出：true
//
//
//
//
// 提示:
//
//
// p1.length == p2.length == p3.length == p4.length == 2
// -10⁴ <= xi, yi <= 10⁴
//
//
// Related Topics 几何 数学 👍 111 👎 0

/**
 * @author shunxin.jin
 * @date 2022/7/29 09:18
 */
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return isRightTriangle(p1, p2, p3) && isRightTriangle(p2, p3, p4) && isRightTriangle(p1, p2, p4) && isRightTriangle(p1, p3, p4);
    }

    private boolean isRightTriangle(int[] p1, int[] p2, int[] p3) {
        int d1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int d2 = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);
        int d3 = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]);
        if (d1 == 0 && d2 == 0){
            return false;
        }
        if (d1 == 0 && d3 == 0){
            return false;
        }
        if (d2 == 0 && d3 == 0){
            return false;
        }
        if (d1 != d2 && d2 != d3 && d1 != d3) {
            return false;
        }
        if (d1 == d2 && d1 + d2 == d3) {
            return true;
        }
        if (d2 == d3 && d2 + d3 == d1) {
            return true;
        }
        if (d1 == d3 && d1 + d3 == d2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] p1 = {1, 0};
        int[] p2 = {-1, 0};
        int[] p3 = {0, 1};
        int[] p4 = {0, -1};
        System.out.println(new Solution().validSquare(p1, p2, p3, p4));
    }
}
