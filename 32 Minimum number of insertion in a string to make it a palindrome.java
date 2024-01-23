/*
Problem link: https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/

Minimum number of insertions to make a string palindrome
Given a string, find the minimum number of characters to be inserted to form Palindrome string out of given string

Examples:
ab: Number of insertions required is 1. bab
aa: Number of insertions required is 0. aa
*/

class Solution {
    public int minInsertions(String s) {
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        String reversed = str.toString();
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(s.charAt(i - 1) == reversed.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return s.length() - dp[n][n];
    }
}
