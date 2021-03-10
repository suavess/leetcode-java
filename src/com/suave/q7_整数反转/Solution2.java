package com.suave.q7_整数反转;

/**
 * @author Suave
 * @author 2021/3/10 10:32 下午
 */
public class Solution2 {
    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }
}
