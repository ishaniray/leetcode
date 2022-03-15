/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        Random random = new Random();
        
        for (int i = 0, matches = 0; i < 10; ++i) {
            String guessWord = wordlist[random.nextInt(wordlist.length)];
            matches = master.guess(guessWord);
            
            if (matches == 6) {
                break;
            }
            
            List<String> candidates = new ArrayList<>();
            for (String word : wordlist) {
                if (matches == findMatches(word, guessWord)) {
                    candidates.add(word);
                }
            }
            wordlist = candidates.toArray(new String[candidates.size()]);
        }
    }
    
    private int findMatches(String word, String guessWord) {
        int matches = 0;
        for (int i = 0; i < 6; ++i) {
            if (word.charAt(i) == guessWord.charAt(i)) {
                ++matches;
            }
        }
        return matches;
    }
}