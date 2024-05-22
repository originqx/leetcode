package org.example.stack;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int[] res = solution7.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i : res) {
            System.out.println(i);
        }
    }
}


class Solution7 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }

        return res;
    }
}