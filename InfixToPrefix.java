import java.util.Stack;
public class InfixToPrefix {
    private static int precedence(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
        }
        return 0;
    }
    
    // this function is very similar to the infixToPostfix() with a few changes and they are listed below:
    //1: loop variable is decremented and the string is traversed from the end
    //2: Conditions with "(" and ")" are reversed such that if it was about "(", now it is about ")", and vice versa but the conditional block is still the same
    //3: reverse of the result string is done and returned as the answer
    private static String infixToPrefix(String expression){
        Stack<Character> stack=new Stack<>();
        StringBuilder result=new StringBuilder("");
        for(int i=expression.length()-1;i>=0;i--){
            char ch=expression.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                result.append(ch);
            }else if(ch==')'){
                stack.push(ch);
            }else if(ch=='('){
                while(!stack.isEmpty() && stack.peek()!=')'){
                    result.append(stack.pop());
                }
                if(stack.peek()==')'){
                    stack.pop();
                }
            }else{
                while(!stack.isEmpty() && precedence(ch)<=precedence(stack.peek())){
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
    public static void main(String[] args) {
        String exp="(A-B/C)*(A/K-L)";
        System.out.println("Prefix: "+infixToPrefix(exp));
    }
}
