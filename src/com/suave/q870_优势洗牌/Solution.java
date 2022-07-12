package com.suave.q870_优势洗牌;

import java.util.*;

/**
 * @author suave
 * @date 2022-07-12 20:18
 */
public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int[] sortArr = Arrays.copyOf(nums2, nums2.length);
        Arrays.sort(sortArr);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int start = 0, end = nums1.length - 1;
        for (int i : nums1) {
            if (i > sortArr[start]) {
                List<Integer> arr = map.getOrDefault(sortArr[start], new ArrayList<>(1));
                arr.add(i);
                map.put(sortArr[start], arr);
                start++;
            } else {
                List<Integer> arr = map.getOrDefault(sortArr[end], new ArrayList<>(1));
                arr.add(i);
                map.put(sortArr[end], arr);
                end--;
            }
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            List<Integer> arr = map.get(nums2[i]);
            Integer tmp = arr.get(0);
            res[i] = tmp;
            arr.remove(0);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
    }
}
