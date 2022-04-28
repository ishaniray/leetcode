class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return getMoneyAmountDp(1, n, dp);
    }
    
    private int getMoneyAmountDp(int lower, int upper, int[][] dp) {
        if (lower >= upper) {
            return 0;
        }
        
        if (dp[lower][upper] != 0) {
            return dp[lower][upper];
        }
    
        int maximum = Integer.MAX_VALUE;
        for (int i = lower; i <= upper; ++i) {
            maximum = Math.min(maximum, Math.max(getMoneyAmountDp(lower, i - 1, dp), getMoneyAmountDp(i + 1, upper, dp)) + i);
        }
        
        dp[lower][upper] = maximum;
    
        return maximum;
    }
}