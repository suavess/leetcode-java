package com.suave.面试题17_11_单词距离;
//有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词
//不同，你能对此优化吗?
//
// 示例：
//
//
//输入：words = ["I","am","a","student","from","a","university","in","a","city"],
//word1 = "a", word2 = "student"
//输出：1
//
// 提示：
//
//
// words.length <= 100000
//
// Related Topics 数组 字符串 👍 49 👎 0

/**
 * @author shunxin.jin
 * @date 2022/5/27 09:18
 */
public class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int result = 0, index1 = 0, index2 = 0;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                index1 = i;
                if (index2 != 0) {
                    int abs = Math.abs(index1 - index2);
                    result = result == 0 ? abs : Math.min(result, abs);
                }
            } else if (word2.equals(words[i])) {
                index2 = i;
                if (index1 != 0) {
                    int abs = Math.abs(index1 - index2);
                    result = result == 0 ? abs : Math.min(result, abs);
                }
            }
        }
        return result;
    }
}
