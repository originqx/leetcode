package org.example.doublepoint;

public class MaxArea {
    public static void main(String[] args) {
        new Solution3().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
}

class Solution3 {
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(maxArea);
        return maxArea;
    }
}
