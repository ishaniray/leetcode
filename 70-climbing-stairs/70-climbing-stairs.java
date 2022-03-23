class Solution {
    public int climbStairs(int n) {        
        if (n < 1) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        if (n == 2) {
            return 2;
        }
        
        int i = 3;
        int allWaysToReachIMinus2thStep = 1, allWaysToReachIMinus1thStep = 2;
        for ( ; i < n + 1; ++i) {
            int allWaysToReachIthStep = allWaysToReachIMinus2thStep + allWaysToReachIMinus1thStep;
            allWaysToReachIMinus2thStep = allWaysToReachIMinus1thStep;
            allWaysToReachIMinus1thStep = allWaysToReachIthStep;
        }
        
        return allWaysToReachIMinus1thStep;
    }
}