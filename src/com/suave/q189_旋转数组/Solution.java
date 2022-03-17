package com.suave.q189_旋转数组;

/**
 * @author shunxin.jin
 * @date 2021/9/28 12:32 上午
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (i > nums.length - k) {
                break;
            }
            for (int j = 0; j < k + i; j++) {
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        new Solution().rotate(nums, 3);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
