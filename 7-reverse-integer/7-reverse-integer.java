class Solution {
    public int reverse(int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        }
        
        String xRevString = new StringBuilder().append(Math.abs(x)).reverse().toString();
        int beginIndex = 0;
        while (beginIndex < xRevString.length() - 1 && xRevString.charAt(beginIndex) == '0') {
            ++beginIndex;
        }
        xRevString = xRevString.substring(beginIndex);
        
        String rangeLimit = String.valueOf(Integer.MAX_VALUE);
        if (x < 0) {
            xRevString = new StringBuilder().append('-').append(xRevString).toString();
            rangeLimit = String.valueOf(Integer.MIN_VALUE);
        }
        
        if (xRevString.length() == rangeLimit.length() && xRevString.compareTo(rangeLimit) > 0) {
            return 0;
        }
        return Integer.parseInt(xRevString);
    }
}