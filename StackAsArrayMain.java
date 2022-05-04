// stack class implemented as array
class StackAsArray{
    // index of the top element
    int top;
    // maximum size of the array
    final int MAX=1000;
    int[] arr=new int[MAX];

    // constructor initializing top to -1
    StackAsArray(){
        top=-1;
    }

    // to check if stack is empty
    boolean isEmpty(){
        if(top==-1){
            return true;
        }else{
            return false;
        }
    }

    // to add an item at the top of the stack
    void push(int num){
        if(top==MAX){
            System.out.println("\nStack Overflow!!");
        }else{
            arr[++top]=num;
            System.out.println("\n"+num+" pushed onto the stack");
        }
    }

    // to delete an item from the top of the stack
    int pop(){
        if(isEmpty()){
            System.out.println("\nStack Underflow!!");
            return 0;
        }else{
            top--;
            System.out.println("\n"+arr[top+1]+" popped from the stack");
            return arr[top+1];
        }
    }

    // returns the top element
    int peek(){
        if(isEmpty()){
            System.out.println("\nStack Underflow!!");
            return 0;
        }else{
            return arr[top];
        }
    }

    // prints stack items in LIFO order
    void print(){
        for(int i=top;i>=0;i--){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

// driver class
public class StackAsArrayMain{
    public static void main(String[] args) {
        StackAsArray stack=new StackAsArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.print();
        stack.pop();
        System.out.println("\nTop element: "+stack.peek());
        System.out.println("\nIs the stack empty?: "+stack.isEmpty());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}