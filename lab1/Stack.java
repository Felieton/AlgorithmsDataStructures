public interface Stack<T> {
    void push(T elem) throws FullStackException;
    T pop() throws EmptyStackException;
    boolean isEmpty();
    boolean isFull();
}
