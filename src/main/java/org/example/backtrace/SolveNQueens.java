package org.example.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        List<List<String>> lists = solution12.solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}

class Solution12 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] grid = new char[n][n];
        for (char[] chars : grid) {
            Arrays.fill(chars, '.');
        }

        backTrack(grid, 0, n, ans);
        return ans;
    }

    private void backTrack(char[][] grid, int currRow, int n, List<List<String>> ans) {
        if (currRow == n) {
            ans.add(validRes(grid));
            return;
        }
        for (int currCol = 0; currCol < n; currCol++) {
            if (!checkValid(grid,currRow,currCol)) {
                continue;
            }
            grid[currRow][currCol] = 'Q';
            backTrack(grid, currRow + 1, n, ans);
            grid[currRow][currCol] = '.';
        }
    }

    private List<String> validRes(char[][] grid) {
        List<String> res = new ArrayList<>();
        for (char[] chars : grid) {
            res.add(new String(chars));
        }
        return res;
    }

    private boolean checkValid(char[][] grid, int currRow, int currCol) {
        int n = grid.length;
        //列
        for (int i = 0; i < n; i++) {
            if (grid[i][currCol] == 'Q') {
                return false;
            }
        }
        //右上
        for (int i = currRow - 1, j = currCol + 1; i >= 0 && j < n; i--, j++) {
            if (grid[i][j] == 'Q') {
                return false;
            }
        }

        //左上
        for (int i = currRow - 1, j = currCol - 1; i >= 0 && j >= 0; i--, j--) {
            if (grid[i][j] == 'Q') {
                return false;
            }
        }
        return true;

    }

}