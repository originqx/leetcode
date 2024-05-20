package org.example.graph;


import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
    public static void main(String[] args) {

        //char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(new Solution3().numIslands(grid));
    }
}

class Solution3 {
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        UnionFInd unionFInd = new UnionFInd(grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';

                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        unionFInd.union(i * column + j, (i - 1) * column + j);
                    }
                    if (i + 1 < row && grid[i + 1][j] == '1') {
                        unionFInd.union(i * column + j, (i + 1) * column + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        unionFInd.union(i * column + j, i * column + j - 1);

                    }
                    if (j + 1 < column && grid[i][j+1] == '1') {
                        unionFInd.union(i * column + j, i * column + j + 1);

                    }

                }
            }
        }

        return unionFInd.getCount();
    }

}

class UnionFInd{
    int count;
    int[] root;
    int[] rank;

    public UnionFInd(char[][] grid) {
        count = 0;
        int row = grid.length;
        int column = grid[0].length;

        root = new int[row * column];
        rank = new int[row * column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    root[i * column + j] = i * column + j;
                    count++;
                }
                rank[i * column + j] = 0;
            }
        }
    }

    public int findRoot(int i) {
        if (root[i] != i) {
            root[i] = findRoot(root[i]);
        }
        return root[i];
    }

    public void union(int x, int y) {
        int rootX = findRoot(x);
        int rootY = findRoot(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
            --count;
        }
    }

    public int getCount() {
        return count;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;

        if (grid == null || grid.length == 0) {
            return res;
        }
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    grid[i][j] = '0';
                    Queue<Integer> queue =  new LinkedList<>();
                    queue.offer(i * column + j);
                    while (!queue.isEmpty()) {
                        Integer poll = queue.poll();
                        int rowPoll = poll / column;
                        int columnPoll = poll % column;
                        if (rowPoll - 1 >= 0 && grid[rowPoll - 1][columnPoll] == '1') {
                            queue.offer((rowPoll - 1) * column + columnPoll);
                            grid[rowPoll - 1][columnPoll] = '0';
                        }
                        if (rowPoll + 1 < row && grid[rowPoll + 1][columnPoll] == '1') {
                            queue.offer((rowPoll + 1) * column + columnPoll);
                            grid[rowPoll + 1][columnPoll] = '0';
                        }
                        if (columnPoll - 1 >= 0 && grid[rowPoll][columnPoll - 1] == '1') {
                            queue.offer(rowPoll * column + columnPoll - 1);
                            grid[rowPoll][columnPoll - 1] = '0';
                        }
                        if (columnPoll + 1 < column && grid[rowPoll][columnPoll+1] == '1') {
                            queue.offer(rowPoll  * column + columnPoll+1);
                            grid[rowPoll][columnPoll + 1] = '0';
                        }
                    }
                }
            }
        }



        return res;
    }
}

class Solution2 {
    public int numIslands(char[][] grid) {
        int res = 0;

        if (grid == null || grid.length == 0) {
            return res;
        }
        int row = grid.length;
        int column = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        int row = grid.length;
        int column = grid[0].length;

        if (i < 0 || i >= row || j < 0 || j >= column || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
//        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
//        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}