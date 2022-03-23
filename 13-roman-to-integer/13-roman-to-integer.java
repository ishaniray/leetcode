class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        
        Map<Character, Set<Character>> subSymbols = new HashMap<>();
        
        Set<Character> subPairs = new HashSet<>();
        subPairs.add('V');
        subPairs.add('X');
        subSymbols.put('I', subPairs);
        
        subPairs = new HashSet<>();
        subPairs.add('L');
        subPairs.add('C');
        subSymbols.put('X', subPairs);
        
        subPairs = new HashSet<>();
        subPairs.add('D');
        subPairs.add('M');
        subSymbols.put('C', subPairs);
        
        int totalVal = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            int valToAdd = romanValues.get(s.charAt(i));
            if (i < s.length() - 1 && subSymbols.containsKey(s.charAt(i)) && subSymbols.get(s.charAt(i)).contains(s.charAt(i + 1))) {
                valToAdd = romanValues.get(s.charAt(i + 1)) - romanValues.get(s.charAt(i));
                ++i;
            }
            totalVal += valToAdd;
        }
        
        return totalVal;
    }
}