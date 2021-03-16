import java.util.ArrayList;

public class InsertSort<T extends Comparable<T>> implements ListSorter<T> {

    @Override
    public ArrayList<T> sort(ArrayList<T> list) {
        int size = list.size();
        for (int i = 1; i < size; i++){
            T value = list.get(i);
            T temp;
            int j;
            for (j = i; j > 0 && value.compareTo(temp=list.get(j - 1)) < 0; j--)
                list.set(j,temp);
            list.set(j, value);
        }

        return list;
    }
}
