public class PostFixCalculator {
    private String expression;

    PostFixCalculator(String expression){
        this.expression = expression;
    }
    public boolean isBalanced(String expression){
        LinkedStack operatorStack = new LinkedStack();
        char paranthesis = '(';
        char closingParanthesis = ')';
        for (int i = 0; i < expression.length(); i++) {
            char letter = expression.charAt(i);
            if(letter == paranthesis){
                operatorStack.push(letter);
            }
            if(letter == closingParanthesis){
                if(!operatorStack.isEmpty()){
                    operatorStack.pop();
                }else{
                    return false;
                }
            }
        }
        if(operatorStack.isEmpty()){
            return true;
        }else
            return false;
    }
    public String convertToPostFix(String inputExpression) {
        String holdExpression = "";
        LinkedStack<Character> operatorStack = new LinkedStack();
        for (int i = 0; i < inputExpression.length(); i++) {
            char letter = inputExpression.charAt(i);
            if(Character.isLetter(letter)){
                throw new IllegalStateException("Letters and variables not allowed in this");
            }
            if(Character.isDigit(letter)){
                holdExpression = holdExpression + letter;
                continue;
            }
            if(letter == '+' || letter == '-' || letter == '*' || letter == '/'){
                while(!operatorStack.isEmpty()){
                    if(operatorStack.peek() == '('){
                        break;
                    }
                    if(operatorStack.peek() == ')'){
                       while(operatorStack.peek() != '('){
                            holdExpression = holdExpression + operatorStack.pop();
                        }
                       operatorStack.pop();
                    }
                    if(operatorStack.peek() == '*'|| operatorStack.peek() == '/'){
                        if(letter == '+' || letter == '-'){
                            holdExpression = holdExpression + operatorStack.pop();
                            continue;
                        }
                        if(letter == '*' || letter == '/'){
                            holdExpression = holdExpression + operatorStack.pop();
                        }
                    }
                    else if (operatorStack.peek() == '+'|| operatorStack.peek() == '-'){
                        if(letter == '+' || letter == '-'){
                            holdExpression = holdExpression + operatorStack.pop();
                            continue;
                        }
                        if(letter == '*' || letter == '/'){
                            break;
                        }
                    }
                }
                operatorStack.push(letter);
            }
        }
        while(!operatorStack.isEmpty()){
            holdExpression = holdExpression + operatorStack.pop();
        }
        return holdExpression;
    }
//    public double calculatePostFix(String expression){
//
//    }
}
