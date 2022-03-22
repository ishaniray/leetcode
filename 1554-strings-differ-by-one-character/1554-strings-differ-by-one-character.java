class Solution {
    public boolean differByOne(String[] dict) {
        for (int i = 0; i < dict.length - 1; ++i) {
            for (int j = i + 1; j < dict.length; ++j) {
                int diff = 0;
                for (int k = 0; k < dict[i].length(); ++k) {
                    if (dict[i].charAt(k) != dict[j].charAt(k)) {
                        if (++diff > 1) {
                            break;
                        }
                    }
                }
                if (diff == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}