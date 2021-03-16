public interface List<T> {
    void add(T data);
    void delete(int index);
    Object get(int index);
    void set(int index, T data);
    boolean isEmpty();
    int size();
    void clear();
}
