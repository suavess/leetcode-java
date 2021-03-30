package com.suave.q28_实现strStr;

//实现 strStr() 函数。
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。
//
// 示例 1:
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
//
//
// 示例 2:
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
//
//
// 说明:
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
// Related Topics 双指针 字符串
// 👍 759 👎 0

/**
 * @author shunxin.jin
 * @date 2021/3/29 3:35 下午
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        int sourceLen = haystack.length();
        int targetLen = needle.length();
        if (targetLen == 0) {
            return 0;
        }
        if (sourceLen < targetLen) {
            return -1;
        }
        // 最大索引值
        int maxIndex = sourceLen - targetLen;
        for (int i = 0; i <= maxIndex; i++) {
            while (haystack.charAt(i) != needle.charAt(0)) {
                if (i == maxIndex && (haystack.charAt(i) != needle.charAt(0))){
                    return -1;
                }
                i++;
            }
            int j = 0;
            int k = i;
            while (haystack.charAt(k) == needle.charAt(j)) {
                j++;
                if (j < targetLen) {
                    k++;
                } else {
                    break;
                }
            }
            if (j == targetLen) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("mississippi", "issip"));
    }
}
