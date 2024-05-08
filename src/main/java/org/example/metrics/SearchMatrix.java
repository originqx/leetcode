package org.example.metrics;

public class SearchMatrix
{
    public static void main(String[] args) {
        boolean b = new Solution6().searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 222);
        System.out.println(b);
    }
}

class Solution6 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 每个元素是它右面、下面最小的一个
        /**
         * Z字搜索
         */
        int row = matrix.length;
        int col = matrix[0].length;

        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}