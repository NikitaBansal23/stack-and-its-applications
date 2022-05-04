import java.util.Stack;
public class PostfixToInfix {
    private static boolean isOperator(char ch){
        switch(ch){
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '%':
                return true;
        }
        return false;
    }
    private static String postfixToInfix(String expression){
        Stack<String> stack=new Stack<>();
        for(int i=0;i<expression.length();i++){
            char ch=expression.charAt(i);
            if(isOperator(ch)){
                stack.push("("+stack.pop()+ch+stack.pop()+")");
            }else{
                stack.push(ch+"");
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String exp = "ab*c+";
        System.out.println( postfixToInfix(exp));
    }
}
