class Solution {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                maxGold = Math.max(maxGold, maxGoldDfs(i, j, grid));
            }
        }
        
        return maxGold;
    }
    
    private int maxGoldDfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[i].length - 1) {
            return 0;
        }
        
        int goldHere = grid[i][j];
        if (goldHere == 0) {
            return 0;
        }
        
        grid[i][j] = 0; // mark as visited
        
        int maxGoldFromHere = goldHere;
        maxGoldFromHere = Math.max(maxGoldFromHere, maxGoldDfs(i - 1, j, grid) + goldHere);
        maxGoldFromHere = Math.max(maxGoldFromHere, maxGoldDfs(i + 1, j, grid) + goldHere);
        maxGoldFromHere = Math.max(maxGoldFromHere, maxGoldDfs(i, j + 1, grid) + goldHere);
        maxGoldFromHere = Math.max(maxGoldFromHere, maxGoldDfs(i, j - 1, grid) + goldHere);
        
        grid[i][j] = goldHere; // very imp. - remember to change back to orig. value
        
        return maxGoldFromHere;
    }
}