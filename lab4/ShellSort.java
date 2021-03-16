import java.util.ArrayList;

public class ShellSort<T extends Comparable<T>> implements ListSorter<T> {
    private int gap;

    public ShellSort(int gap){
        this.gap=gap;
    }

    @Override
    public ArrayList<T> sort(ArrayList<T> list) {
        int size = list.size();
        for (int gap = this.gap; gap > 0; gap /= 2){
            for(int i = gap; i < size; i++){
                T temp = list.get(i);
                int j;
                for (j = i; j >= gap && list.get(j - gap).compareTo(temp) > 0; j -= gap)
                    list.set(j, list.get(j - gap));
                list.set(j, temp);
            }
        }

        return list;
    }
}
