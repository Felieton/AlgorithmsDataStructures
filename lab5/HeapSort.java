import java.util.ArrayList;

public class HeapSort<T extends Comparable<T>> implements ListSorter<T> {

    @Override
    public ArrayList<T> sort(ArrayList<T> list){
        heapsort(list, list.size());

        return list;
    }

    private void heapsort(ArrayList<T> heap, int n) {
        heapAdjustment(heap, n);

        for (int i = n - 1; i > 0; i--) {
            swap(heap, i, 0);
            heapify(heap, 0, i);
        }
    }

        private void swap(ArrayList<T> list, int left, int right) {
        T temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }

    public void heapify(ArrayList<T> heap,int idx, int n){
        int idxOfBigger = 2 * idx + 1;
        if(idxOfBigger < n){
            if(idxOfBigger + 1 < n &&
                    heap.get(idxOfBigger).compareTo(heap.get(idxOfBigger+1)) < 0)
                idxOfBigger++;
            if(heap.get(idx).compareTo(heap.get(idxOfBigger)) < 0){
                swap(heap,idx,idxOfBigger);
                heapify(heap,idxOfBigger,n);
            }
        }
    }
    void heapAdjustment(ArrayList<T> heap,int n) {
        for (int i = (n - 1) / 2; i >= 0; i--)
            heapify(heap, i, n);
    }

}
