package com.suave.LCS01_下载插件;

/**
 * @author suave
 * @date 2022-07-03 18:43
 */
public class Solution {
    public int leastMinutes(int n) {
        // 不加速带宽下载就需要n分钟
        int min = n;
        for (int i = 1;; i++) {
            // i为加速次数
            // 每分钟下载的个数
            int number = 1 << (i);
            int ceil = (int) Math.ceil((double) n / number);
            if (ceil + i > min){
                return min;
            } else {
                min = ceil + i;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(1 << 1);
        System.out.println(new Solution().leastMinutes(4));
    }
}
