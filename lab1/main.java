
public class main {
    static public<T> void thrower(Stack<T> stack1, Stack<T> stack2) {
        try {
            while (!stack2.isEmpty() && !stack1.isFull())
                stack1.push(stack2.pop());

        } catch (EmptyStackException e) {
            System.out.println(e.getMessage());
        } catch (FullStackException f) {
            System.out.println(f.getMessage());
        }
    }

    public static void main(String[] args){
        MyStack<Integer> stack = new MyStack<Integer>();
        MyArrayStack<Integer> a_stack = new MyArrayStack<>(3);
            stack.push(2);
            stack.push(33);
            stack.push(34);
            System.out.println(stack.toString());
            System.out.println(a_stack.toString());
            thrower(a_stack, stack);
            System.out.println(stack.toString());
            System.out.println(a_stack.toString());

            thrower(stack, a_stack);
            System.out.println(stack.toString());
            System.out.println(a_stack.toString());
    }
}
