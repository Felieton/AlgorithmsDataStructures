public class OneWayCyclicListWithHead<T extends Comparable <T>> implements List<T> {

    private class Element{
        private T value;
        private Element next;

        public Element(T value){
            this.value=value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    private Element head;
    private int size;

    public OneWayCyclicListWithHead() {
        head = new Element(null);
        clear();
        this.size = 0;
    }

    @Override
    public void add(T data) throws IllegalArgumentException {
        if(!(data instanceof Car))
            throw new IllegalArgumentException();
        Element newElem = new Element(data);
        if(head.getValue() == null) {
            head = newElem;
            head.setNext(head);
            size++;
            return;
        }
        if((head.getValue().compareTo(newElem.getValue()) > 0)) {
            Element tail = getElem(size()-1);
            newElem.setNext(head);
            head = newElem;
            tail.setNext(head);
            size++;
            return;
        }
        Element currentElem = head;
        while(currentElem.getNext() != head && (newElem.getValue().compareTo(currentElem.getValue()) > 0)) {
            currentElem = currentElem.getNext();
        }
        size++;
        newElem.setNext(currentElem.getNext());
        currentElem.setNext(newElem);
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        if(index < 0 || head == null)
            throw new IndexOutOfBoundsException();
        if(index == 0) {
            head = head.getNext();
            Element tail = getElem(size()-1);
            tail.setNext(head);
            size--;
            return;
        }
        Element currentElem =  getElem(index-1);
        if(currentElem.getNext() == null || currentElem.getNext() == head)
            throw new IndexOutOfBoundsException();
        currentElem.setNext(currentElem.getNext().getNext());
        size--;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Element find=head;
        for (int i=0;i<index;i++)
            find=find.getNext();

        return find.getValue();
    }

    public Element getElem(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Element find=head;

        for (int i=0;i<index;i++)
            find=find.getNext();

        return find;
    }

    @Override
    public void set(int index, T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        head.setNext(head);
    }
}
