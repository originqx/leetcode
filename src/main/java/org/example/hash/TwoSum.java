package org.example.hash;

import java.util.ArrayList;

public class TwoSum {
    public static void main(String[] args) {
        new Solution2().twoSum(new int[]{2, 7, 11, 15}, 9);
    }
}

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        ArrayList<Integer> ints = new ArrayList<Integer>(length);
        for (int i = 0; i < length; i++) {
            if (ints.contains(target - nums[i])) {
                return new int[]{i, ints.indexOf(target - nums[i])};
            }
            ints.add(nums[i]);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}