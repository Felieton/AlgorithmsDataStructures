import java.util.ArrayList;

public class BubbleSort<T extends Comparable<T>> implements ListSorter<T> {

    @Override
    public ArrayList<T> sort(ArrayList<T> list) {
        int size=list.size();

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size - 1; j++)
                if (list.get(j).compareTo(list.get(j + 1)) > 0)
                swap(list, j,j+1);
        }

        return list;
    }

    private void swap(ArrayList<T> list, int left, int right){
        T temp = list.get(left);
        list.set(left,list.get(right));
        list.set(right,temp);
    }
}
