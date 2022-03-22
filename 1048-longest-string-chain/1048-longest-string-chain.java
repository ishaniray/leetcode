class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (word1, word2) -> word1.length() - word2.length());
        
        Map<String, Integer> longestChainEndingAtWord = new HashMap<>();
        
        int longestChain = 0;
        
        for (String word : words) {
            int chainLengthAtWord = 1;
            for (int i = 0; i < word.length(); ++i) {
                String possiblePredecessor = new StringBuilder(word).deleteCharAt(i).toString();
                chainLengthAtWord = Math.max(chainLengthAtWord, 
                                             longestChainEndingAtWord.getOrDefault(possiblePredecessor, 0) + 1);
            }
            longestChainEndingAtWord.put(word, chainLengthAtWord);
            longestChain = Math.max(longestChain, chainLengthAtWord);
        }
        
        return longestChain;
    }
}