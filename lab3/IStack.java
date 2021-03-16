public interface IStack<T> {
    public class EmptyStackException extends Exception{}

    boolean isEmpty();
    boolean isFull();
    T pop() throws EmptyStackException;
    void push(T elem);
    int size();
    T top() throws EmptyStackException;
}
