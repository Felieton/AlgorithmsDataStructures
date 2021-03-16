import java.util.ArrayList;

public class MyStack<T> implements Stack<T> {
    private ArrayList<T> stack;

    public MyStack (){
        stack = new ArrayList<T>();
    }

    @Override
    public void push(T elem) {
        stack.add(elem);
    }

    @Override
    public T pop() throws EmptyStackException {
        if (this.isEmpty())
            throw new EmptyStackException();

        return stack.remove(stack.size()-1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty() ;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    public int getSize() {
        return stack.size();
    }

    public String toString() {
        return stack.toString();
    }
}
