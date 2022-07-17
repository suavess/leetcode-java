package com.suave.q779_第K个语法符号;
//我们构建了一个包含 n 行( 索引从 1 开始 )的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
//
//
// 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
//
//
// 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始）
//
// 示例 1:
//
//
//输入: n = 1, k = 1
//输出: 0
//解释: 第一行：0
//
//
// 示例 2:
//
//
//输入: n = 2, k = 1
//输出: 0
//解释:
//第一行: 0
//第二行: 01
//
//
// 示例 3:
//
//
//输入: n = 2, k = 2
//输出: 1
//解释:
//第一行: 0
//第二行: 01
//
//
//
//
// 提示:
//
//
// 1 <= n <= 30
// 1 <= k <= 2n - 1
//
//
// Related Topics 位运算 递归 数学 👍 156 👎 0

/**
 * @author suave
 * @date 2022-07-17 16:15
 */
public class Solution {
    public int kthGrammar(int n, int k) {
        // 内存超限制了...
//        String a = "0";
//        char[] chars = new char[]{'0'};
//        for (int i = 1; i < n; i++) {
//            chars = new char[1 << i];
//            for (int j = 0; j < a.length(); j++) {
//                if (a.charAt(j) == '0') {
//                    chars[j * 2] = '0';
//                    chars[j * 2 + 1] = '1';
//                } else {
//                    chars[j * 2] = '1';
//                    chars[j * 2 + 1] = '0';
//                }
//            }
//            a = new String(chars);
//        }
//        return chars[k - 1] - '0';

        // 构建一颗二叉树
        //      0
        //     /\
        //    0  1
        //   /\  /\
        //  0 1 1 0
        // 第n层共有num个数字
        if (n == 1){
            return 0;
        }
        int res = 0;
        int left = 1, right = 1 << (n - 1);
        while (n != 1){
            n--;
            if (k > (left + right) / 2) {
                // 说明在右子树,1的右子树为0,0的右子树为1,调换一下
                res = res == 1 ? 0 : 1;
                left = (left + right) / 2;
            } else {
                // 说明在左子树, 0的左子树为0,不需要改变res
                right = (left + right) / 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kthGrammar(4, 5));
    }
}
