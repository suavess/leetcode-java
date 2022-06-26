package com.suave.q1037_有效的回旋镖;

//给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
//
//
// 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。
//
//
//
// 示例 1：
//
//
//输入：points = [[1,1],[2,3],[3,2]]
//输出：true
//
//
// 示例 2：
//
//
//输入：points = [[1,1],[2,2],[3,3]]
//输出：false
//
//
//
// 提示：
//
//
//
// points.length == 3
// points[i].length == 2
// 0 <= xi, yi <= 100
//
// Related Topics 几何 数组 数学 👍 45 👎 0

/**
 * @author shunxin.jin
 * @date 2022/6/8 09:13
 */
public class Solution {

    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];
//        return  (y2 - y1) / (x2 -x1) != (y3 - y1) / (x3 - x1);
        // 不能用除法
        return (y2 - y1) * (x3 - x1) != (y3 - y1) * (x2 - x1);
    }


}
