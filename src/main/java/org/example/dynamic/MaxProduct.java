package org.example.dynamic;

import java.util.Arrays;

public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        Solution10 solution = new Solution10();
        System.out.println(solution.maxProduct(nums));
    }
}

class Solution10 {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] dpMax = new int[length];
        int[] dpMin = new int[length];
        System.arraycopy(nums, 0, dpMax, 0, length);
        System.arraycopy(nums, 0, dpMin, 0, length);
        for (int i = 1; i < length; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(nums[i], dpMax[i - 1] * nums[i]));
        }
        int ans = dpMax[0];
        for (int i = 1; i < length; i++) {
            ans = Math.max(ans, dpMax[i]);
        }
        return ans;
    }
}