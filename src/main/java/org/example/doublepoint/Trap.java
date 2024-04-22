package org.example.doublepoint;

import java.util.LinkedList;

public class Trap {
    public static void main(String[] args) {
        new Solution7().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }
}

class Solution6 {
    // 动态规划
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0] = height[0];
        maxRight[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);

        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        System.out.println(res);
        return res;
    }
}

class Solution7 {
    // 单调栈
    public int trap(int[] height) {
        int length = height.length;
        int res = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length ; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int right = i;
                int h = Math.min(height[left], height[right]) - height[top];
                int w = right - left - 1;
                res+= h * w;
            }
            stack.push(i);
        }
        System.out.println(res);
        return res;
    }
}
