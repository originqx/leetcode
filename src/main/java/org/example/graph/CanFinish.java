package org.example.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanFinish {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        Solution6 solution = new Solution6();
        System.out.println(solution.canFinish(numCourses, prerequisites));
    }
}

class Solution6 {
    List<List<Integer>> edges;
    // 入度
    int[] inDegree;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            edges.get(edge[1]).add(edge[0]);
            ++inDegree[edge[0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;

        while (!queue.isEmpty()) {
            ++visited;
            Integer u = queue.poll();
            for (Integer v : edges.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }
}

class Solution5 {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for (int[] edge : prerequisites) {
            edges.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }

        }
        return valid;

    }

    private void dfs(int i) {
        visited[i] = 1;
        for (Integer v : edges.get(i)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }
}