package org.example.backtrace;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        Solution9 solution = new Solution9();
        List<String> generateParenthesis = solution.generateParenthesis(3);
        for (String s : generateParenthesis) {
            System.out.println(s);
        }
    }
}

class Solution9 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuffer s = new StringBuffer();
        backTrack(s, ans, 0, 0, n );
        return ans;
    }

    private void backTrack(StringBuffer s, List<String> ans, int left, int right, int n) {
        if (right > left || left > n) {
            return;
        }
        if (left == n) {
            StringBuffer s1 = new StringBuffer(s);
            for (int i = right; i < n ; i++) {
                s1.append(')');
            }
            ans.add(s1.toString());
            return;
        }

        s.append('(');
        backTrack(s, ans, left + 1, right, n);
        s.deleteCharAt(s.length() - 1);

        s.append(')');
        backTrack(s, ans, left, right + 1, n);
        s.deleteCharAt(s.length() - 1);

    }
}