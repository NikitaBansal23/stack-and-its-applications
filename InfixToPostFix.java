import java.util.Stack;

public class InfixToPostFix {
    static int preceedence(char ch){
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    static String infixToPostfix(String expression){
        String result=new String("");
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<expression.length();i++){
            char c=expression.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result+=c;
            }else if(c=='('){
                stack.push(c);
            }else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    result+=stack.pop();
                }
                stack.pop();
            }else if(c=='^' && stack.peek()=='^'){
                stack.push(c);
            }
            else{
                while(!stack.isEmpty() && preceedence(c)<=preceedence(stack.peek())){
                    result+=stack.pop();
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek()=='('){
                return "Invalid Expression";
            }
            result+=stack.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }
}
