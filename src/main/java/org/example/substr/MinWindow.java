package org.example.substr;


public class MinWindow {
    public static void main(String[] args) {
        new Solution6().minWindow("ADOBECODEBANC", "ABC");
    }
}

class Solution6 {
    public String minWindow(String s, String t) {
        int[] needs = new int[256];
        int[] windows = new int[256];
        int count = 0;
        int match = 0;
        int left = 0;
        int right = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
            if (needs[t.charAt(i)] == 1) {
                count++;
            }
        }
        while (right < s.length()){
            char c = s.charAt(right);
            if (needs[c] > 0) {
                windows[c]++;
                if (needs[c] == windows[c]) {
                    match++;
                }
            }
            right++;

            while (match == count) {
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }
                char c1 = s.charAt(left);
                if (needs[c1] > 0) {
                    windows[c1]--;
                    if (windows[c1] < needs[c1]) {
                        match--;
                    }
                }
                left++;
            }
        }
        String x = min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
        System.out.println(x);
        return x;
    }
}