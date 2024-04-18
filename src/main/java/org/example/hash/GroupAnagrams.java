package org.example.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        new Solution().groupAnagrams(strs);
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                s.append(count[i]+ 'a');
            }
            String key = s.toString();
            List<String> orDefault = hashMap.getOrDefault(key, new ArrayList<String>());
            orDefault.add(str);
            hashMap.put(key, orDefault);
        }
//        hashMap.entrySet().forEach(it -> System.out.println(it.getKey() + ":" + it.getValue()));
        return new ArrayList<>(hashMap.values());
    }
}