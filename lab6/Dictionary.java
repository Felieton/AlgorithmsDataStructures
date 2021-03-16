import java.util.ArrayList;
import java.util.Iterator;

public class Dictionary implements Map {
    private ArrayList<Integer> values;
    private ArrayList<String> keys;
    private int size;

    public Dictionary(){
        values = new ArrayList<Integer>();
        keys = new ArrayList<String>();
        this.size = 0;
    }

    @Override
    public int get(String key) throws IllegalArgumentException {
        if (!containsKey(key))
            throw new IllegalArgumentException();
        return values.get(keys.indexOf(key));
    }

    @Override
    public void put(String key, int value) throws IllegalArgumentException{
        if (containsKey(key))
            throw new IllegalArgumentException();
        values.add(value);
        keys.add(key);
        this.size++;
    }

    @Override
    public boolean containsKey(String key) {
        for (String keyCheck : keys)
            if (keyCheck.equals(key))
                return true;
            return false;
    }

    @Override
    public int remove(String key) throws IllegalArgumentException {
        if (!containsKey(key))
            throw new IllegalArgumentException();
        int value = values.remove(keys.indexOf(key));
        keys.remove(key);
        size--;

        return value;
    }

    @Override
    public void clear() {
        this.keys = new ArrayList<String>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < values.size(); i++)
            result += keys.get(i) + " " + values.get(i) + "\n";
        result = result.substring(0, result.length() - 2);

        return result;
    }

    public Iterator getValuesIterator() {
        return values.iterator();
    }

    public Iterator getKeysIterator(){
        return keys.iterator();
    }
}
