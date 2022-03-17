class Solution {
    public String decodeString(String s) {
        Deque<String> tokenStack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == '[') {
                ++i;
                continue;
            }
            
            if (s.charAt(i) == ']') {
                String encodedString = tokenStack.pop();
                int k = Integer.parseInt(tokenStack.pop());
                
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < k; ++j) {
                    stringBuilder.append(encodedString);
                }
                
                tokenStack.push(mergeStacktopCharTokens(tokenStack, stringBuilder.toString()));
                
                ++i;
                continue;
            }
            
            int j = i;
            while (j < s.length() && Character.isDigit(s.charAt(j))) {
                ++j;
            }
            
            boolean isCharToken = false;
            if (j == i) {
                isCharToken = true;
                while (j < s.length() && Character.isAlphabetic(s.charAt(j))) {
                    ++j;
                }
            }
            
            String toPush = s.substring(i, j);
            if (isCharToken) {
                toPush = mergeStacktopCharTokens(tokenStack, toPush);
            }
            tokenStack.push(toPush);
            i = j;
        }
        
        List<String> decodedStringArray = new ArrayList<>();
        while(!tokenStack.isEmpty()) {
            decodedStringArray.add(0, tokenStack.pop());
        }
        
        return decodedStringArray.stream().collect(Collectors.joining(""));
    }
    
    private String mergeStacktopCharTokens(Deque<String> tokenStack, String charToken) {
        String topElement = tokenStack.peek();
        if (topElement != null) {
        try {
                Integer.parseInt(topElement);
            } catch (NumberFormatException e) {
                return new StringBuilder().append(tokenStack.pop()).append(charToken).toString();
            }
        }
        return charToken;
    }
}