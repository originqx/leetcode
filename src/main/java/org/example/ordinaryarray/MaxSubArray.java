package org.example.ordinaryarray;

public class MaxSubArray {
    public static void main(String[] args) {
        new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1 ] + nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                max = Math.max(max, sums[i] - sums[j]);
            }
        }
        System.out.println(max);
        return max;
    }
}
