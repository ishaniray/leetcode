class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justifiedLines = new ArrayList<>();
        int indexOfLastLinedWord = -1;
        
        while (indexOfLastLinedWord != words.length - 1) {
            int charactersConsumed = 0;
            List<String> newLineWords = new ArrayList<>();
            for (int i = indexOfLastLinedWord + 1; i < words.length && charactersConsumed < maxWidth; ++i) {
                int wordCost = newLineWords.isEmpty() ? words[i].length() : words[i].length() + 1;
                if (wordCost <= maxWidth - charactersConsumed) {
                    newLineWords.add(words[i]);
                    charactersConsumed += wordCost;
                    indexOfLastLinedWord = i;
                } else {
                    break;
                }
            }
            justifiedLines.add(buildJustifiedLine(newLineWords, charactersConsumed, maxWidth, 
                                                  indexOfLastLinedWord == words.length - 1));
        }
        
        return justifiedLines;
    }
    
    private String buildJustifiedLine(List<String> words, int charactersConsumed, 
                                      int maxWidth, boolean isLastLine) {
        StringBuilder lineBuilder = new StringBuilder();
        
        if (words.size() == 1) {
            return buildLineWithTrailingSpaces(lineBuilder.append(words.get(0)), maxWidth);
        }
        
        if (isLastLine) {
            return buildLineWithTrailingSpaces(
                lineBuilder.append(words.stream().collect(Collectors.joining(" "))), maxWidth);
        }
        
        
        int[] spacesAfterWord = new int[words.size() - 1];
        for (int i = 0; i < spacesAfterWord.length; ++i) {
            spacesAfterWord[i] = 1;
        }
        
        int extraSpacesToAdd = maxWidth - charactersConsumed;
        for (int i = 0; i < extraSpacesToAdd; ++i) {
            spacesAfterWord[i % spacesAfterWord.length] += 1;
        }
        
        for (int i = 0; i < spacesAfterWord.length; ++i) {
            lineBuilder.append(words.get(i));
            for (int j = 0; j < spacesAfterWord[i]; ++j) {
                lineBuilder.append(" ");
            }
        }
        lineBuilder.append(words.get(words.size() - 1));
        
        return lineBuilder.toString();
    }
    
    private String buildLineWithTrailingSpaces(StringBuilder lineBuilder, int maxWidth) {
        int trailingSpacesToAdd = maxWidth - lineBuilder.length();
        for (int i = 0; i < trailingSpacesToAdd; ++i) {
            lineBuilder.append(" ");
        }
        return lineBuilder.toString();
    }
}