package com.suave.q745_前缀和后缀搜索;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shunxin.jin
 * @date 2022/7/14 11:01
 */
public class WordFilter {
    // 暴力解法
//    private String[] words = null;
//
//    public WordFilter(String[] words) {
//        this.words = words;
//    }
//
//    public int f(String pref, String suff) {
//        for (int i = words.length - 1; i >= 0; i--) {
//            if (words[i].startsWith(pref) && words[i].endsWith(suff)) {
//                return i;
//            }
//        }
//        return -1;
//    }

    // 列举出所有的可能
    private Map<String, Integer> map = new HashMap<>();

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 1; j <= word.length(); j++) {
                for (int k = word.length() - 1; k >= 0; k--) {
                    map.put(word.substring(0, j) + "_" + word.substring(k), i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return map.getOrDefault(pref + "_" + suff, -1);
    }

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"apple"});
        System.out.println(wordFilter.f("a", "e"));
    }
}
