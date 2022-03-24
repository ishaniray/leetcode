class Solution {
    public int expressiveWords(String s, String[] words) {
        int stretchy = 0;
        for (String word : words) {
            int i = 0, j = 0;
            while (i < s.length()) {
                int k = i;
                while (k < s.length() && s.charAt(k) == s.charAt(i)) {
                    ++k;
                }
                int groupLength = k - i;
                if (groupLength < 3) {
                    boolean notStretchy = false;
                    for (int l = 0; l < groupLength; ++l) {
                        if (j > word.length() - l - 1 || s.charAt(i + l) != word.charAt(j + l)) {
                            notStretchy = true;
                            break;
                        }
                    }
                    if (notStretchy) {
                        break;
                    }
                    i += groupLength;
                    j += groupLength;
                } else {
                    if (j > word.length() - 1 || word.charAt(j) != s.charAt(i)) {
                        break;
                    }
                    int m = j;
                    while (m < word.length() && word.charAt(m) == word.charAt(j)) {
                        ++m;
                    }
                    int groupLengthQueryString = m - j;
                    if (groupLengthQueryString > groupLength) {
                        break;
                    }
                    i += groupLength;
                    j += groupLengthQueryString;
                }
            }
            if (i != s.length() || j != word.length()) {
                continue;
            }
            ++stretchy;
        }
        return stretchy;
    }
}