package org.example.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
    public static void main(String[] args) {
        new Solution2().findAnagrams("cbaebabacd", "abc");
    }
}
class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] windows = new int[365];
        int[] needs = new int[365];
//        Map<Character,Integer> windows = new HashMap();
//        Map<Character,Integer> needs = new HashMap();
        int i = 0;
        int needsCount = 0;
        while (i < p.length()) {
            needs[p.charAt(i)]++;
            if (needs[p.charAt(i)] == 1) {
                needsCount++;
            }
            i++;
        }
        int left = 0;
        int right = 0;
        int match = 0;
        while (right < s.length()) {
            char rightValue = s.charAt(right);
            if (needs[rightValue] >0) {
                windows[rightValue]++;
                if (needs[rightValue] == windows[rightValue]) {
                    match++;
                }
            }
            right++;
            while (match == needsCount) {
                if (right - left == p.length()) {
                    res.add(left);
                }
                char leftValue = s.charAt(left);
                if (needs[leftValue] > 0) {
                    windows[leftValue]--;
                    if (windows[leftValue] < needs[leftValue]) {
                        match--;
                    }
                }
                left++;
            }
        }
        res.forEach(System.out::println);
        return res;
    }
}