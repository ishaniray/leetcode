class Solution {
    // Top-Down Approach: Uses Recursion + Memoization

    public int numDecodings(String s) {        
        return numDecodingsDp(s, new HashMap<>());
    }
    
    private int numDecodingsDp(String s, Map<String, Integer> dpMap) {
        if (s.length() < 1) {
            return 0;
        }
        
        if (s.charAt(0) == '0') {
            return 0;
        }
        
        if (s.length() == 1) {
            return 1;
        }
        
        if (dpMap.containsKey(s)) {
            return dpMap.get(s);
        }
        
        int totalWays = numDecodingsDp(s.substring(1, s.length()), dpMap);
        if (s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) < '7')) {
            if (s.length() == 2) {
                ++totalWays;
            } else {
                totalWays += numDecodingsDp(s.substring(2, s.length()), dpMap);
            }
        }
        
        dpMap.put(s, totalWays);
        
        return totalWays;
    }
}