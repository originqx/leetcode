package org.example.hash;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        new Solution3().longestConsecutive(nums);
    }
}


class Solution3 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (Integer num : set) {
            if (set.contains(num - 1)){
                continue;
            }
            int count = 1;
            while (set.contains(num + 1)){
                num++;
                count++;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
        return max;
    }
}

class Solution4 {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length;) {
            int count = 1;
            int j = i + 1;
            while (j < nums.length && (nums[j] == nums[j - 1] + 1 || nums[j] == nums[j - 1])) {
                if (nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                count++;
                j++;
            }
            i = j;
            max = Math.max(max, count);
        }
        System.out.println(max);
        return max;
    }
}
