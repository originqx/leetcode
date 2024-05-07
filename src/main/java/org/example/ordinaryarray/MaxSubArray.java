package org.example.ordinaryarray;

public class MaxSubArray {
    public static void main(String[] args) {
        new Solution2().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
//        new Solution2().maxSubArray(new int[]{1,2,-1});
    }
}

class Solution2 {
    // 动态规划
    // 状态转移方程：sum[i] = max(sum[i-1]+nums[i],nums[i])
    // 初始化：sum[0] = nums[0]
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sums[i] = Math.max(sums[i - 1] + nums[i], nums[i]);
            max = Math.max(max, sums[i]);
        }

        System.out.println(max);
        return max;
    }
}

class Solution {
    // 前缀和，超时
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            // 可以不减，
            // 也可以减去前面的和，得到最大子数组
            // 因为减去前面的和，得到的是一个子数组，所以需要遍历前面的和，找到最大的
            max = Math.max(max, sums[i]);
            for (int j = i - 1; j >= 0; j--) {
                max = Math.max(max, sums[i] - sums[j]);
            }
        }
        System.out.println(max);
        return max;
    }
}
