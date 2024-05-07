package org.example.ordinaryarray;

import java.util.Arrays;

public class Rotate {
    public static void main(String[] args) {
        new Solution6().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}

class Solution6 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        // 每次移动一个，移动K次
        for (int i = 0; i < k; i++) {
            move1(nums);
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private void move1(int[] nums) {
        int temp = nums[nums.length - 1];
        for (int i = nums.length-1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = temp;
    }

}

class Solution5 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        // double数组后取中间部分
        int doubleLen = nums.length * 2;
        int[] doubleArray = new int[doubleLen];

        for (int i = 0; i < nums.length; i++) {
            doubleArray[i] = nums[i];
            doubleArray[i + nums.length] = nums[i];
        }
        System.arraycopy(doubleArray, nums.length - k, nums, 0, nums.length);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
