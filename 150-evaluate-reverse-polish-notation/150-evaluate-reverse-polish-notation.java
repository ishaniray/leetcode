class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> operandStack = new LinkedList<>();
        
        for (String token : tokens) {
            if (isOperator(token)) {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                if (token.equals("+")) {
                    operandStack.push(operand1 + operand2);
                } else if (token.equals("-")) {
                    operandStack.push(operand1 - operand2);
                } else if(token.equals("*")) {
                    operandStack.push(operand1 * operand2);
                } else {
                    operandStack.push(operand1 / operand2);
                }
            } else {
                operandStack.push(Integer.parseInt(token));
            }
        }
        
        return operandStack.pop();
    }
    
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}