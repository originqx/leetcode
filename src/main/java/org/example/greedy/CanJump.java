package org.example.greedy;

public class CanJump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.canJump(nums)); // true
    }
}

class Solution2 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxLength >= i) {
                maxLength = Math.max(i + nums[i], maxLength);
            }
        }
        return maxLength >= nums.length - 1;
    }
}