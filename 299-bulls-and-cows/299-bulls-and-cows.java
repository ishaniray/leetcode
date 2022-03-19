class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        Map<Character, Integer> potentialCows = new HashMap<>();
        
        for (int i = 0; i < guess.length(); ++i) {
            if (guess.charAt(i) == secret.charAt(i)) {
                ++bulls;
            } else {
                int mapVal = 1;
                if (potentialCows.containsKey(guess.charAt(i))) {
                    mapVal = potentialCows.get(guess.charAt(i)) + 1;
                }
                potentialCows.put(guess.charAt(i), mapVal);
            }
        }
        
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) != guess.charAt(i)) {
                if (potentialCows.containsKey(secret.charAt(i))) {
                    ++cows;
                    potentialCows.put(secret.charAt(i), potentialCows.get(secret.charAt(i)) - 1);
                    if (potentialCows.get(secret.charAt(i)) == 0) {
                        potentialCows.remove(secret.charAt(i));
                    }
                }
            }
        }
        
        return new StringBuilder().append(bulls).append("A").append(cows).append("B").toString();
    }
}