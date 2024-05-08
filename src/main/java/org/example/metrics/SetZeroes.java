package org.example.metrics;

import java.util.Arrays;

public class SetZeroes {
    public static void main(String[] args) {

        //int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new Solution2().setZeroes(matrix);
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class Solution2 {
    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int column = matrix[0].length;
        boolean[] rowFlag = new boolean[row];
        boolean[] columnFlag = new boolean[column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    rowFlag[i] = columnFlag[j] = true;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (rowFlag[i] || columnFlag[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {

        //  注意：Arrays.copyOfRange中的元素是之前元素的地址，如果是二维数组或对象，直接是原来元素的地址，只是一个浅拷贝
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            newMatrix[i] = Arrays.copyOfRange(matrix[i], 0, matrix[i].length);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    setRowAndColumnToZero(newMatrix, i, j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(newMatrix[i], 0, matrix[i], 0, matrix[0].length);
        }
    }

    private void setRowAndColumnToZero(int[][] newMatrix, int i, int j) {
        for (int k = 0; k < newMatrix.length; k++) {
            newMatrix[k][j] = 0;
        }
        for (int k = 0; k < newMatrix[0].length; k++) {
            newMatrix[i][k] = 0;
        }
    }
}
