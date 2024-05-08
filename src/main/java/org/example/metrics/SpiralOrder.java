package org.example.metrics;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static void main(String[] args) {

        // 测试代码

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        List<Integer> result = new Solution3().spiralOrder(matrix);

        System.out.println(result); // 输出 [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}

class Solution3 {
    public List<Integer> spiralOrder(int[][] matrix) {

        // 实现螺旋遍历矩阵的算法
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int left = 0, right = col - 1 , top = 0, bottom = row - 1;
        while (left <= right && top <= bottom) {
            // 上
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            // 右
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            // 下
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
            }
            bottom--;
            // 左
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
        }
        return result;
    }
}