package org.example.binarysearch;


public class SearchRange {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] ans = solution4.searchRange(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}

class Solution4 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] ans = new int[2];
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left >= n || nums[left] != target) {
            return new int[]{-1, -1};
        }
        ans[0] = left;

        left = 0;
        right = n - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return new int[]{-1, -1};
        }
        ans[1] = right;
        return ans;
    }
}