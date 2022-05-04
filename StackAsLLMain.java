class StackAsLL{
    class Node{
        int data;
        Node next;
        Node(int data){this.data=data;}
    }
    Node root;
    void push(int data){
        Node node=new Node(data);
        if(root==null){
            root=node;
        }else{
            node.next=root;
            root=node;
        }
        System.out.println("\n"+data+" has been pushed onto the stack");
    }
    boolean isEmpty(){
        if(root==null){
            return true;
        }else{
            return false;
        }
    }
    int pop(){
        int popped=Integer.MIN_VALUE;
        if(isEmpty()){
            System.out.println("\nStack is empty!! Nothing can be popped out!!");
        }else{
            popped=root.data;
            root=root.next;
        }
        return popped;
    }
    int peek(){
        if(isEmpty()){
            System.out.println("\nStack is empty!! Nothing can be peeked at!!");
            return Integer.MIN_VALUE;
        }else{
            return root.data;
        }
    }
    void printStack(){
        Node node=root;
        while(node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
    }
}
public class StackAsLLMain {
    public static void main(String[] args) {
        StackAsLL stack=new StackAsLL();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("\n\nStack looks like this: \n");
        stack.printStack();
        System.out.println("\n"+stack.pop()+" has been popped from the stack");
        System.out.println("\nTop element: "+stack.peek());
        System.out.println("\nIs the stack empty?: "+stack.isEmpty());
        System.out.println("\n"+stack.pop()+" has been popped from the stack");
        System.out.println("\n"+stack.pop()+" has been popped from the stack");
        System.out.println("\n"+stack.pop()+" has been popped from the stack");
        System.out.println("\n"+stack.pop()+" has been popped from the stack");
    }
}
