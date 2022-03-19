class Solution {
    public int calculate(String s) {
        int result = 0;
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); ++i) {
            int j = i;
            while (j < s.length() && Character.isDigit(s.charAt(j))) {
                ++j;
            }
            
            if (j > i) {
                result += Integer.parseInt(s.substring(i, j)) * sign;
                i = j - 1;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        
        return result;
    }
}