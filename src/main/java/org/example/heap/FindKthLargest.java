package org.example.heap;

import java.awt.geom.QuadCurve2D;

public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        Solution4 solution = new Solution4();
        int res = solution.findKthLargest(nums, k);
        System.out.println(res);
    }
}

class Solution4 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        buildMaxHeap(nums, n);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            n--;
            maxHeapify(nums, 0, n);
        }
        return nums[0];
    }

    private void maxHeapify(int[] nums, int i, int n) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;
        if (l < n && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < n && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums, i, largest);
            maxHeapify(nums, largest, n);
        }

    }

    private void buildMaxHeap(int[] nums, int n) {
        for (int i = n / 2; i >= 0; i--) {
            maxHeapify(nums, i, n);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, k);
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int p = nums[(l + r) / 2];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (nums[i] < p);
            do {
                j--;
            } while (nums[j] > p);
            if (i < j) {
                swap(nums, i, j);
            }
        }
        int R = r - j;

        if (R < k) {
            return quickSelect(nums, l, j, k - R);
        } else {
            return quickSelect(nums, j + 1, r, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}