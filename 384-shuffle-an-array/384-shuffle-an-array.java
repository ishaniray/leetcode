class Solution {
    
    private int[] nums;
    
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        int[] clone = nums.clone();
        int n = clone.length;
        
        for (int i = 0; i < n - 1; ++i) {
            int j = random.nextInt(n - i) + i;
            
            int temp = clone[i];
            clone[i] = clone[j];
            clone[j] = temp;
        }
        
        return clone;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */