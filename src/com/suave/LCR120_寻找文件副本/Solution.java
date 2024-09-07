package com.suave.LCR120_寻找文件副本;
//设备中存有 n 个文件，文件 id 记于数组 documents。若文件 id 相同，则定义为该文件存在副本。请返回任一存在副本的文件 id。
//
//
//
// 示例 1：
//
//
//输入：documents = [2, 5, 3, 0, 5, 0]
//输出：0 或 5
//
//
//
//
// 提示：
//
//
// 0 ≤ documents[i] ≤ n-1
// 2 <= n <= 100000
//
//
//
//
// Related Topics 数组 哈希表 排序
// 👍 1239 👎 0

/**
 * @author Suave
 * @since 2024/09/07 22:46
 */
public class Solution {
    public int findRepeatDocument(int[] documents) {
        // Arrays.sort(documents);
        // for (int i = 0; i < documents.length - 1; i++) {
        //     if (documents[i] == documents[i + 1]) {
        //         return documents[i];
        //     }
        // }
        // return -1;

        int i = 0;
        while(i < documents.length) {
            if(documents[i] == i) {
                i++;
                continue;
            }
            if(documents[documents[i]] == documents[i]){
                return documents[i];
            }
            int tmp = documents[i];
            documents[i] = documents[tmp];
            documents[tmp] = tmp;
        }
        return -1;
    }

    public static void main(String[] args) {
        new Solution().findRepeatDocument(new int[]{2, 5, 3, 0, 5, 0});
    }
}
