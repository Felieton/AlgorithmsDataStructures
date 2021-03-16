import java.util.LinkedList;

public class LimitedQueue<T> implements IQueue<T> {
    private int size_limit;
    private LinkedList<T> list;

    public LimitedQueue(int size_limit){
        this.size_limit = size_limit;
        list = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public boolean isFull() {
        return list.size() == this.size_limit;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        T value = list.remove(0);
        if (value == null)
            throw new EmptyQueueException();
        else

        return value;
    }

    @Override
    public void enqueue(T elem) throws FullQueueException {
        if (list.size()==size_limit)
            throw new FullQueueException();
        else
            list.add(elem);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T first() throws EmptyQueueException {
        T value = list.get(0);
        if (value == null)
            throw new EmptyQueueException();

        return value;
    }
}
