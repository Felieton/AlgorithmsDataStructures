public class ArrayList1<T> implements List<T> {
    private Car[] array;
    private int size;

    public ArrayList1() {
        array = new Car[0];
        size = 0;
    }

    private void changeCapacity(int newCapacity) throws IllegalArgumentException {
        if(size > newCapacity || newCapacity < 0)
            throw new IllegalArgumentException();
        Car[] newArray = new Car[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public void add(Object value) throws IllegalArgumentException {
        if(!(value instanceof Car))
            throw new IllegalArgumentException();
        Car element = (Car) value;
        changeCapacity(size+1);
        size++;
        int i;
        for(i = size-2; i > -1; i--) {
            if(array[i].getAge() <= element.getAge())
                break;

            array[i+1] = array[i];
        }
        array[i+1] = element;
    }

    public void delete(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if(index + 1 < size)
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        changeCapacity(size);
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        return array[index];
    }


    @Override
    public void set(int index, Object value) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Car[0];
        size = 0;
    }

    public Car[] getArray() {
        return array;
    }
}
