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
        
        int previous1 = 1, previous2 = 2;
        for (int i = 3; i < n + 1; ++i) {
            int sum = previous1 + previous2;
            previous1 = previous2;
            previous2 = sum;
        }
        
        return previous2;
    }
}