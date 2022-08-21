package com.suave.q415_字符串相加;
//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
//
//
//
// 示例 1：
//
//
//输入：num1 = "11", num2 = "123"
//输出："134"
//
//
// 示例 2：
//
//
//输入：num1 = "456", num2 = "77"
//输出："533"
//
//
// 示例 3：
//
//
//输入：num1 = "0", num2 = "0"
//输出："0"
//
//
//
//
//
//
// 提示：
//
//
// 1 <= num1.length, num2.length <= 10⁴
// num1 和num2 都只包含数字 0-9
// num1 和num2 都不包含任何前导零
//
//
// Related Topics 数学 字符串 模拟 👍 607 👎 0

/**
 * @author suave
 * @date 2022-08-21 17:20
 */
public class Solution {
    public String addStrings(String num1, String num2) {
//        char[] num1Arr = num1.toCharArray();
//        char[] num2Arr = num2.toCharArray();
//        int index1 = num1Arr.length - 1;
//        int index2 = num2Arr.length - 1;
//        char[] res = new char[Math.max(index1, index2) + 1];
//        boolean carry = false;
//        while (index1 >= 0 || index2 >= 0) {
//            int num;
//            if (index1 >= 0 && index2 >= 0) {
//                num = num1Arr[index1] + num2Arr[index2] - '0';
//            } else if (index1 >= 0) {
//                num = num1Arr[index1];
//            } else {
//                num = num2Arr[index2];
//            }
//            if (carry) {
//                char i = (char) (num + 1);
//                if (i <= '9') {
//                    carry = false;
//                } else {
//                    i -= 10;
//                }
//                res[Math.max(index1, index2)] = i;
//            } else {
//                char i = (char) num;
//                if (i > '9') {
//                    carry = true;
//                    i -= 10;
//                }
//                res[Math.max(index1, index2)] = i;
//            }
//            index1--;
//            index2--;
//        }
//        if (carry) {
//            char[] tmp = new char[res.length + 1];
//            System.arraycopy(res, 0, tmp, 1, res.length);
//            tmp[0] = '1';
//            res = tmp;
//        }
//        return new String(res);

        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("11", "123"));
    }
}
