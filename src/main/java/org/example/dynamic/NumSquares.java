package org.example.dynamic;


public class NumSquares {
    public static void main(String[] args) {
        System.out.println(new Solution8().numSquares(12));
    }
}

class Solution8 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] +1);
            }
        }
        return dp[n];
    }
}
