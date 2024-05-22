package org.example.binarysearch;


public class FindMin {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        // int[] nums = {4,5,6,7,0,1,2};
        // int[] nums = {11,13,15,17};
        Solution9 solution = new Solution9();
        System.out.println(solution.findMin(nums));
    }
}

class Solution9 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
            res = Math.min(res, nums[mid]);
        }
        return res;
    }
}