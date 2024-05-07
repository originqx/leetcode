
package org.example.ordinaryarray;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {

        // test case

        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        Solution3 solution = new Solution3();
        solution.merge(intervals);
    }
}

class Solution3 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        // 按照区间的起始位置排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] merged = new int[intervals.length][2];
        int count = 0;

        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] <= right) {
                right = Math.max(right, interval[1]);
            } else {
                merged[count++] = new int[]{left, right};
                left = interval[0];
                right = interval[1];
            }
        }
        merged[count++] = new int[]{left, right};
        int[][] res = new int[count][2];
        System.arraycopy(merged, 0, res, 0, count);
        for (int[] re : res) {
            System.out.println(re[0]+ " " + re[1]);
        }
        return res;
    }
}