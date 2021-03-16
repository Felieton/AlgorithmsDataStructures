public class OneWayListWithSentinel<T> implements List<T> {

    private class Element{
        private T value;
        private Element next;

        public Element (T value) {
            this.value = value;
            this.next=null;
        }

        public T getValue(){
            return value;
        }

        public Element getNext(){
            return next;
        }

        public void setNext(Element next){
            this.next = next;
        }

        public void setValue(T value){
            this.value = value;
        }
    }

    private Element sentinel;
    private int size;

    public OneWayListWithSentinel(){
        sentinel=new Element(null);
        clear();
        this.size=0;
    }


    @Override
    public void add(T data) {
        if (sentinel.getNext()==null) {
            sentinel.setNext(new Element(data));
            size++;
            return;
        }

        Element last=sentinel.getNext();
        while (last.getNext()!=null)
            last=last.getNext();
        size++;
        last.setNext(new Element(data));
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        if(index < 0 || sentinel.getNext() == null)
            throw new IndexOutOfBoundsException();

        Element currentElem;
        if(index == 0) {
            currentElem = sentinel.getNext().getNext();
            sentinel.setNext(currentElem);
            size--;
            return;
        }

        currentElem = getElem(index-1);
        if(currentElem.getNext() == null)
            throw new IndexOutOfBoundsException();
        currentElem.setNext(currentElem.getNext().getNext());
        size--;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index<0||index >= size) throw new IndexOutOfBoundsException();

        Element find = sentinel.getNext();
        for (int i = 0; i < index; i++)
            find=find.getNext();

        return find.getValue();
    }

    public Element getElem(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Element find=sentinel.getNext();
        for (int i=0;i<index;i++)
            find=find.getNext();

        return find;
    }

    @Override
    public void set(int index, T data) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Element find = sentinel.getNext();
        for (int i = 0; i < index; i++)
            find=find.getNext();
        find.setValue(data);
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
        sentinel.setNext(null);
    }
}
