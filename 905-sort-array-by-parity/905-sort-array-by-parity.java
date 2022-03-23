class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int lastEvenAt = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 0) {
                int temp = nums[lastEvenAt + 1];
                nums[lastEvenAt + 1] = nums[i];
                nums[i] = temp;
                lastEvenAt += 1;
            }
        }
        return nums;
    }
}