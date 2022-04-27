class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return 1;
        }
        
        int l = 0;
        int lcis = 1;
        
        for (int r = l + 1; ; ++r) {
            if (r < nums.length && nums[r] > nums[r - 1]) {
                continue;
            }
            
            int cis = r - l;
            if (cis > lcis) {
                lcis = cis;
            }
            
            if (r > nums.length - 1) {
                break;
            }
            
            l = r;
        }
        
        return lcis;
    }
}