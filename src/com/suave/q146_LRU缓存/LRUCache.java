package com.suave.q146_LRU缓存;
//
// 请你设计并实现一个满足
// LRU (最近最少使用) 缓存 约束的数据结构。
//
//
//
// 实现
// LRUCache 类：
//
//
//
//
//
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
//
//
//
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
//
//
//
// 示例：
//
//
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
//
//
//
//
// 提示：
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 10000
// 0 <= value <= 10⁵
// 最多调用 2 * 10⁵ 次 get 和 put
//
//
// Related Topics 设计 哈希表 链表 双向链表 👍 2255 👎 0

import com.suave.q648_单词替换.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author shunxin.jin
 * @date 2022/7/7 10:20
 */
public class LRUCache {

    private final int capacity;

    private final Map<Integer, Integer> cachePool;

    private final LinkedList<Integer> usePool;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cachePool = new HashMap<>((int) (capacity / 0.75 + 1));
        usePool = new LinkedList<>();
    }

    public int get(int key) {
        Integer value = cachePool.get(key);
        if (value == null) {
            return -1;
        }
        usePool.remove((Object) key);
        usePool.add(key);
        return value;
    }

    public void put(int key, int value) {
        if (cachePool.containsKey(key)) {
            cachePool.put(key, value);
            usePool.remove((Object) key);
            usePool.add(key);
        } else {
            if (cachePool.size() == capacity) {
                // 缓存池已满,需要移除最近最少使用的键
                Integer removeItem = usePool.removeFirst();
                cachePool.remove(removeItem);
            }
            usePool.add(key);
            cachePool.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2,6);
        lruCache.get(1);
        lruCache.put(1,5);
        lruCache.put(1,2);
        lruCache.get(1);
        lruCache.get(2);
    }
}
