package org.example.slidingwindow;


public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("abcabcbb");
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] windows = new int[365];
        int max = 0;
        int left = 0;
        int right = 0;
        while ( right < s.length()) {
            char rightValue = s.charAt(right);
            windows[rightValue]++;
            right++;
            while (windows[rightValue] > 1) {
                int leftValue = s.charAt(left);
                windows[leftValue]--;
                left++;

            }
            max = Math.max(max, right - left);
        }
        System.out.println(max);
        return max;
    }
}