class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i) {
            if (numIndexMap.containsKey(target - nums[i])) {
                return new int[]{numIndexMap.get(target - nums[i]), i};
            }
            numIndexMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}