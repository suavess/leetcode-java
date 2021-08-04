package com.suave.q171_Excel表列序号;

//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
//
//
//
// 例如，
//
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    ...
//
//
//
//
// 示例 1:
//
//
//输入: columnTitle = "A"
//输出: 1
//
//
// 示例 2:
//
//
//输入: columnTitle = "AB"
//输出: 28
//
//
// 示例 3:
//
//
//输入: columnTitle = "ZY"
//输出: 701
//
// 示例 4:
//
//
//输入: columnTitle = "FXSHRXW"
//输出: 2147483647
//
//
//
//
// 提示：
//
//
// 1 <= columnTitle.length <= 7
// columnTitle 仅由大写英文组成
// columnTitle 在范围 ["A", "FXSHRXW"] 内
//
// Related Topics 数学 字符串
// 👍 268 👎 0

import java.sql.SQLOutput;

/**
 * @author shunxin.jin
 * @date 2021/7/30 4:55 下午
 */
public class Solution {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
//            sum += ((int) c - 64) * Math.pow(26, columnTitle.length() - i - 1);
            int temp = c - 'A' + 1;
            sum = sum * 26 + temp;
        }
        return sum;
    }
}
