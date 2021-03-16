import java.util.Arrays;

public class MyArrayStack<T> implements Stack<T> {
    private T [] array;
    private int last_index;

    public MyArrayStack(int size) {
        array = (T[]) new Object[size];
        this.last_index = -1;
    }

    @Override
    public void push(T elem) throws FullStackException {
        if (isFull())
            throw new FullStackException();
        array[++last_index] = elem;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (this.isEmpty())
            throw new EmptyStackException();
        T elem = array[last_index];
        array[last_index--] = null;
        return elem;
    }

    @Override
    public boolean isEmpty() {
        return last_index == -1;
    }

    @Override
    public boolean isFull() {
        return last_index != array.length-1;
    }

    public String toString() {
        return Arrays.toString(array);
    }
}
