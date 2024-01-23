/* 
  Problem link: https://www.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1

Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
Example:
Input: str = "aab"
Output: "a"
The two subsequence are 'a'(first) and 'a' 
(second). Note that 'b' cannot be considered 
as part of subsequence as it would be at same
index in both.

*/

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        int n = str.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        
       return helper(str, str, 0, 0, dp);
    }
    
    private int helper(String s1, String s2, int i, int j, int[][] dp) {
        if(i == s1.length() || j == s2.length())
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j) && i != j)
            dp[i][j] = 1 + helper(s1, s2, i + 1, j + 1, dp);
        else
            dp[i][j] = Math.max(helper(s1, s2, i, j + 1, dp), helper(s1, s2, i + 1, j, dp));
        return dp[i][j];
    }
}
