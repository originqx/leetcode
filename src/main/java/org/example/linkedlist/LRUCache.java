package org.example.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache {
    public static void main(String[] args) {
        // 测试代码
        LRUCache2 cache = new LRUCache2(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}

class LRUCache2 {
    int capacity;
    Map<Integer, Integer> map;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() >= capacity) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }
}
