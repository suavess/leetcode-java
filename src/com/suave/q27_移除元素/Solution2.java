package com.suave.q27_移除元素;

/**
 * 不保存命中的元素
 * @author shunxin.jin
 * @date 2021/3/29 2:24 下午
 */
public class Solution2 {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
