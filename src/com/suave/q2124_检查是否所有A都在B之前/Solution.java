package com.suave.q2124_检查是否所有A都在B之前;

//存在一个 'a' 位于下标 2 ，而一个 'b' 位于下标 1 。
//因此，不能满足每个 'a' 都出现在每个 'b' 之前，所以返回 false 。
//
//
// 示例 3：
//
// 输入：s = "bbb"
//输出：true
//解释：
//不存在 'a' ，因此可以视作每个 'a' 都出现在每个 'b' 之前，所以返回 true 。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s[i] 为 'a' 或 'b'
//
//
// Related Topics 字符串 👍 5 👎 0

/**
 * @author suave
 * @date 2022-07-09 16:01
 */
public class Solution {
    public boolean checkString(String s) {
//        char[] chars = s.toCharArray();
//        boolean start = false;
//        for (char aChar : chars) {
//            if (start && aChar == 'a') {
//                return false;
//            }
//            if (aChar == 'b'){
//                start = true;
//            }
//        }
//        return true;
        return !s.contains("ba");
    }
}
