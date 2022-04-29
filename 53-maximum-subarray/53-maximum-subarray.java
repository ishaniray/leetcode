class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax = nums[0];
        int maxSoFar = nums[0];
        
        for (int i = 1; i < nums.length; ++i) {
            maxSoFar = Math.max(maxSoFar + nums[i], nums[i]); // max ending at (i)th index is either max ending at (i - 1)th index + num at (i)th index, or, num at (i)th index
            globalMax = Math.max(globalMax, maxSoFar);
        }
        
        return globalMax;
    }
}