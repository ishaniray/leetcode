class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackMap = new HashMap<>();
        brackMap.put(')', '(');
        brackMap.put('}', '{');
        brackMap.put(']', '[');
        
        Deque<Character> brackStack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            char brack = s.charAt(i);
            if (brackMap.containsKey(brack)) {
				if (brackStack.isEmpty() || !brackMap.get(brack).equals(brackStack.removeFirst())) {
					return false;
				}
			} else {
                brackStack.addFirst(brack);
            }
        }
        
        return brackStack.isEmpty();
    }
}