package com.suave.q67_二进制求和;

//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
// 示例 1:
//
// 输入: a = "11", b = "1"
//输出: "100"
//
// 示例 2:
//
// 输入: a = "1010", b = "1011"
//输出: "10101"
//
//
//
// 提示：
//
//
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。
//
// Related Topics 数学 字符串
// 👍 588 👎 0

/**
 * @author shunxin.jin
 * @date 2021/4/2 1:35 下午
 */
public class Solution {
    public String addBinary(String a, String b) {
//        int aLen = a.length();
//        int bLen = b.length();
//        String bigStr = aLen > bLen ? a : b;
//        String smallStr = bigStr.equals(a) ? b : a;
//        StringBuilder res = new StringBuilder();
//        // 判断是否要进位
//        boolean flag = false;
//        for (int i = bigStr.length() - 1, j = smallStr.length() - 1; i >= 0; i--, j--) {
//            int bigStrChar = Integer.parseInt(String.valueOf(bigStr.charAt(i)));
//            if (j >= 0) {
//                // 此时进行相加
//                int localRes = bigStrChar + Integer.parseInt(String.valueOf(smallStr.charAt(j)));
//                if (flag) {
//                    if (localRes + 1 == 3) {
//                        res.append(1);
//                    } else if (localRes + 1 == 2) {
//                        res.append(0);
//                    } else {
//                        res.append(1);
//                        flag = false;
//                    }
//                } else {
//                    if (localRes == 2) {
//                        flag = true;
//                        res.append(0);
//                    } else {
//                        res.append(localRes);
//                    }
//                }
//            } else {
//                if (flag) {
//                    if (bigStrChar + 1 == 2) {
//                        res.append(0);
//                    } else {
//                        res.append(1);
//                        flag = false;
//                    }
//                } else {
//                    res.append(bigStr.charAt(i));
//                }
//            }
//        }
//        return flag ? res.append(1).reverse().toString() : res.reverse().toString();

        // 优化，空位填充0
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1010", "1011"));
    }
}
