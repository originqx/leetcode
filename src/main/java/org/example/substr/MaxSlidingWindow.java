package org.example.substr;

import java.util.*;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        new Solution4().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
}

class Solution4 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 使用单调队列。还需要存储下标
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        int left = 0;
        res[left++] = nums[queue.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);

            if (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            res[left++] = nums[queue.peekFirst()];
        }
         Arrays.stream(res).forEach(System.out::println);
        return res;
    }
}


class Solution5 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 暴力解法 .超时
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int right = 0;
        for (int i = 0; i < k - 1; i++) {
            right++;
        }
        while (right < nums.length) {
            res[left] = getMax(nums, left, right);
            right++;
            left++;
        }
        Arrays.stream(res).forEach(System.out::println);
        return res;
    }

    private int getMax(int[] nums, int left, int right) {
        int max = nums[left];
        for (int i = left; i <= right; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }
}