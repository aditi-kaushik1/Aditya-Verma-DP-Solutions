/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false

Problem Link: https://leetcode.com/problems/is-subsequence/
*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        //Time complexity: O(n + m), where n and m are lengths of strings.
        //2 pointer approach
        // int i = 0;
        // int j = 0;
        // while(i != s.length() && j != t.length()) {
        //     if(s.charAt(i) == t.charAt(j)) {
        //         i++;
        //         j++;
        //     }
        //     else
        //         j++;
        // }
        // return i == s.length();

        //Time complexity : O(n*m), where n and m are lengths of strings.
        //USing LCS concept. Their lcs should be same as the string s.
        String[][] dp = new String[s.length() + 1][t.length() + 1];
        for(int i = 0; i <= s.length(); i++) {
            for(int j = 0; j <= t.length(); j++) {
                dp[i][j] = "";
            }
        }

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= t.length(); j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + s.charAt(i - 1);
                else {
                    int l1 = (dp[i - 1][j]).length();
                    int l2 = (dp[i][j - 1]).length();
                    if(l1 >= l2)
                        dp[i][j] = dp[i - 1][j];
                    else
                        dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()].equals(s);
    }
}
