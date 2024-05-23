package org.example.heap;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleArea {
    public static void main(String[] args) {
        Solution33 solution = new Solution33();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(solution.largestRectangleArea(heights));
    }
}

class Solution33 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n-1; i >=0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max((right[i] - left[i] - 1) * heights[i], ans);
        }
        return ans;
    }
}
