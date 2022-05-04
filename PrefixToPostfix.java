import java.util.Stack;

public class PrefixToPostfix {
    private static boolean isOperator(char ch){
        switch (ch) {
            case '+':
            case '-':
            case '/':
            case '%':
            case '^':
            case '*':
                return true;
        }
        return false;
    }
    private static String prefixToPostfix(String expression){
        Stack<String> stack=new Stack<>();
        for(int i=expression.length()-1;i>=0;i--){
            char ch=expression.charAt(i);
            if(isOperator(ch)){
                String operand1=stack.pop();
                String operand2=stack.pop();
                stack.push(operand1+operand2+ch);
            }else{
                stack.push(ch+"");
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String pre_exp = "*-A/BC-/AKL";
        System.out.println("Postfix : "+ prefixToPostfix(pre_exp));
    }
}
