//Memoization
class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        int[][] dp = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(arr, 1, arr.length - 1, dp);
    }
    
    private static int helper(int[] arr, int i, int j, int[][] dp) {
        if(i >= j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int tempAns = helper(arr, i, k, dp) + helper(arr, k + 1, j, dp) + (arr[i - 1] * arr[k] * arr[j]);
            ans = Math.min(ans, tempAns);
        }
        dp[i][j] = ans;
        return ans;
    }
}

//Tabulation (Bottom up approach)
