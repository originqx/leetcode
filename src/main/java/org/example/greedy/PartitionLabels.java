package org.example.greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        List<Integer> partitionLabels = solution6.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(partitionLabels);
//        [9,7,8]
    }
}

class Solution6 {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            last[c - 'a'] = i;
        }
        List<Integer> part = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                part.add(end - start + 1);
                start = end + 1;
            }
        }
        return part;

    }
}