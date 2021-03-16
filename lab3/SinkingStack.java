import java.util.LinkedList;

public class SinkingStack<T> implements IStack<T> {
    private LinkedList<T> list;
    private int max_size;

    public SinkingStack(int max_size){
        list = new LinkedList<>();
        this.max_size = max_size;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return list.size() == max_size;
    }

    @Override
    public T pop() throws EmptyStackException {
        T value = list.remove(0);
        if (value == null)
            throw new EmptyStackException();
        else
            return value;
    }

    @Override
    public void push(T elem) {
        if (list.size()==max_size)
            list.removeLast();

        list.add(0,elem);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T top() throws EmptyStackException {
        T value=list.get(0);
        if (value==null)
            throw new EmptyStackException();
        else return value;
    }
}
