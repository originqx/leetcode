package org.example.greedy;

public class Jump {
    public static void main(String[] args) {

        // 测试代码
        int[] nums = {2, 3, 1, 1, 4};
        int steps = new Solution5().jump(nums);
        System.out.println("最少需要 " + steps + " 步");

    }
}

class Solution5 {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxLength = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxLength = Math.max(maxLength, i + nums[i]);
            if (i == end) {
                end = maxLength;
                steps++;
            }
        }
        return steps;
    }
}