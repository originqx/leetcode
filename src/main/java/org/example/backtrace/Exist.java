package org.example.backtrace;

import org.example.graph.Triew;
import org.example.hash.GroupAnagrams;
import org.example.linkedlist.SwapPairs;

import java.beans.beancontext.BeanContext;

public class Exist {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        Solution10 solution10 = new Solution10();
        System.out.println(solution10.exist(board, word));
    }
}

class Solution10 {

    int[] dr = new int[]{-1, 1, 0, 0};
    int[] dc = new int[]{0, 0, -1, 1};
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }

        int R = board.length;
        int C = board[0].length;
        int[][] visited = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                flag = backTrack(board, word, i, j, R, C,visited,0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, String word, int r, int c, int R,int C, int[][] visited,int k) {
        if (board[r][c] != word.charAt(k)) {
            return false;
        } else if (k == word.length() - 1) {
            return true;
        }
        visited[r][c] = 1;
        boolean res = false;

        for (int i = 0; i < 4; i++) {
            int cr = r + dr[i];
            int cc = c + dc[i];
            if (cr >= 0 && cc >= 0 && cr < R && cc < C && visited[cr][ cc] == 0) {
                boolean flag = backTrack(board, word, cr, cc, R, C, visited, k + 1);
                if (flag) {
                    res = true;
                    break;
                }
            }
        }
        visited[r][c] = 0;
        return res;
    }
}