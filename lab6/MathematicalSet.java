import java.util.ArrayList;

public class MathematicalSet implements Set {
    private ArrayList<String> elements;
    private int size;

    public MathematicalSet(){
        elements = new ArrayList<>();
        size = 0;
    }

    @Override
    public void add(String value) throws IllegalArgumentException {
        if (contains(value))
            throw new IllegalArgumentException();
        elements.add(value);
    }

    @Override
    public boolean contains(String value) {
        for (String valCheck : elements)
            if (valCheck.equals(value))
                return true;
            return false;
    }

    @Override
    public void remove(String value) throws IllegalArgumentException {
        if (!contains(value))
            throw new IllegalArgumentException();
        size--;
        elements.remove(value);
    }

    @Override
    public void clear() {
        elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString(){
        String result = "";

        for (int i = 0; i < elements.size(); i++)
            result += elements.get(i) + ", ";

        result=result.substring(0,result.length()-2);

        return result;
    }
}
