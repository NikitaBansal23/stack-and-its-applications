import java.util.Stack;
public class PostfixToPrefix {
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
    private static String postfixToPrefix(String expression){
        Stack<String> stack=new Stack<>();
        for(int i=0;i<expression.length();i++){
            char ch=expression.charAt(i);
            if(isOperator(ch)){
                String operand1=stack.pop();
                String operand2=stack.pop();
                stack.push(ch+operand1+operand2);
            }else{
                stack.push(ch+"");
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String post_exp = "ABC/-AK/L-*";
        // Function call
        System.out.println("Prefix : "+ postfixToPrefix(post_exp));
    }
}
