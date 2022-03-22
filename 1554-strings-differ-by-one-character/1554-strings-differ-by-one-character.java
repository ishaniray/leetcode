class Solution {
    public boolean differByOne(String[] dict) {
        Set<String> set = new HashSet<>();
        
        for (String s : dict) {
            for (int i = 0; i < s.length(); ++i) {
                StringBuilder stringBuilder = new StringBuilder(s);
                stringBuilder.setCharAt(i, '*');
                if (!set.add(stringBuilder.toString())) {
                    return true;
                }
            }
        }
        
        return false;
    }
}