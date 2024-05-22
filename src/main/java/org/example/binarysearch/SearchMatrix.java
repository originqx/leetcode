package org.example.binarysearch;

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 3;
        Solution2 solution = new Solution2();
        boolean result = solution.searchMatrix(matrix, target);
        System.out.println(result);
    }
}

class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 从左上开始搜索
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}