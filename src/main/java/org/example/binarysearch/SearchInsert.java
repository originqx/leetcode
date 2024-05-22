package org.example.binarysearch;

import org.example.doublepoint.Trap;

import java.lang.annotation.Target;

public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(nums, target));
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}