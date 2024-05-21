package org.example.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class OrangesRotting {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(new Solution4().orangesRotting(grid));
    }
}

//广度优先的最大层次数
class Solution4 {
    public int orangesRotting(int[][] grid) {
        int res = 0;

        if (grid == null || grid.length == 0) {
            return res;
        }
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};
        int row = grid.length;
        int column = grid[0].length;

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> depth = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 2) {
                    int index = i * column + j;
                    queue.offer(index);
                    depth.put(index, 0);
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            int r = node / column;
            int c = node % column;
            for (int i = 0; i < 4; i++) {
                int rc = r + dr[i];
                int cc = c + dc[i];
                if (rc >= 0 && rc < row && cc >= 0 && cc < column && grid[rc][cc] == 1) {
                    grid[rc][cc] = 2;
                    int nodeC = rc * column + cc;
                    queue.offer(nodeC);
                    depth.put(nodeC, depth.get(node) + 1);
                    res = depth.get(nodeC);
                }
            }
        }
        for (int[] ints : grid) {
            for (int q = 0; q < column; q++) {
                if (ints[q] == 1) {
                    return -1;
                }
            }
        }
        return res;
    }
}
