import java.util.ArrayList;

public class SelectSort<T extends Comparable<T>> implements ListSorter<T> {

    @Override
    public ArrayList<T> sort(ArrayList<T> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++){
            int min = i;
            for (int j = i + 1; j < size; j++)
                if (list.get(j).compareTo(list.get(min)) < 0)
                    min = j;
                swap(list, min, i);
        }

        return list;
    }

    private void swap(ArrayList<T> list, int left, int right){
        T temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }
}
