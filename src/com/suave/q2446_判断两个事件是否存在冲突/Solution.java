package com.suave.q2446_判断两个事件是否存在冲突;
//给你两个字符串数组 event1 和 event2 ，表示发生在同一天的两个闭区间时间段事件，其中：
//
//
// event1 = [startTime1, endTime1] 且
// event2 = [startTime2, endTime2]
//
//
// 事件的时间为有效的 24 小时制且按 HH:MM 格式给出。
//
// 当两个事件存在某个非空的交集时（即，某些时刻是两个事件都包含的），则认为出现 冲突 。
//
// 如果两个事件之间存在冲突，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
//输出：true
//解释：两个事件在 2:00 出现交集。
//
//
// 示例 2：
//
//
//输入：event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
//输出：true
//解释：两个事件的交集从 01:20 开始，到 02:00 结束。
//
//
// 示例 3：
//
//
//输入：event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
//输出：false
//解释：两个事件不存在交集。
//
//
//
//
// 提示：
//
//
// evnet1.length == event2.length == 2.
// event1[i].length == event2[i].length == 5
// startTime1 <= endTime1
// startTime2 <= endTime2
// 所有事件的时间都按照 HH:MM 格式给出
//
//
// Related Topics 数组 字符串
// 👍 37 👎 0

/**
 * @author Suave
 * @since 2023/05/17 13:25
 */
public class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        // String[] event1Start = event1[0].split(":");
        // String[] event1End = event1[1].split(":");
        // String[] event2Start = event2[0].split(":");
        // String[] event2End = event2[1].split(":");
        // int event1StartTime = Integer.parseInt(event1Start[0]) * 60 + Integer.parseInt(event1Start[1]);
        // int event1EndTime = Integer.parseInt(event1End[0]) * 60 + Integer.parseInt(event1End[1]);
        // int event2StartTime = Integer.parseInt(event2Start[0]) * 60 + Integer.parseInt(event2Start[1]);
        // int event2EndTime = Integer.parseInt(event2End[0]) * 60 + Integer.parseInt(event2End[1]);
        // return (event1StartTime >= event2StartTime && event1StartTime <= event2EndTime) || (event2StartTime >= event1StartTime && event2StartTime <= event1EndTime);

        /**
         * 忘了字符串可以直接比较啊啊啊啊啊..........
         * 根据不相交的情况取反，更简洁一点
         */
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }
}
