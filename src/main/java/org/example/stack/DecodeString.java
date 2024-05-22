package org.example.stack;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        Solution6 solution = new Solution6();
        System.out.println(solution.decodeString(s));
    }
}

class Solution6 {
    public String decodeString(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            }else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                String currString = sb.toString();
                stack.pop();


                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                int count = Integer.parseInt(sb.toString());

                while (count > 0) {
                    for (char c1 : currString.toCharArray()) {
                        stack.push(c1);
                    }
                    count--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}