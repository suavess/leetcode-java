package com.suave.q914_卡牌分组;
//给定一副牌，每张牌上都写着一个整数。
//
// 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
//
//
// 每组都有 X 张牌。
// 组内所有的牌上都写着相同的整数。
//
//
// 仅当你可选的 X >= 2 时返回 true。
//
//
//
// 示例 1：
//
//
//输入：deck = [1,2,3,4,4,3,2,1]
//输出：true
//解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
//
//
// 示例 2：
//
//
//输入：deck = [1,1,1,2,2,2,3,3]
//输出：false
//解释：没有满足要求的分组。
//
//
// 提示：
//
//
// 1 <= deck.length <= 10⁴
// 0 <= deck[i] < 10⁴
//
//
// Related Topics 数组 哈希表 数学 计数 数论 👍 261 👎 0

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author suave
 * @date 2022-08-07 21:14
 */
public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        if (list.get(0) < 2) {
            return false;
        }
        // 判断各个value之间是否存在公约数
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < 2) {
                return false;
            }
            if (!gcd(list.get(i), list.get(i - 1))) {
                return false;
            }
        }
        return true;
    }

    private boolean gcd(int a, int b) {
        for (int i = 2; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                return true;
            }
        }
        return false;
    }
}
