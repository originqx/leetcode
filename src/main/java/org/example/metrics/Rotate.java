package org.example.metrics;

public class Rotate {
    public static void main(String[] args) {

        // 测试代码

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        new Solution5().rotate(matrix);

        // 打印旋转后的矩阵

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}

class Solution5 {
    public void rotate(int[][] matrix) {
        // 第一行变为最后一列，第二行变成倒数第二列
        // i,j -> j,n-i-1
        int n = matrix.length;
        int[][] tmp = new int[n][n];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                tmp[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(tmp[i], 0, matrix[i], 0, n);
        }
    }
}