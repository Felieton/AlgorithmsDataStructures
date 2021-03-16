import java.util.ArrayList;
import java.util.Random;

public class Test {

    public static void testGenerator(int n, int range, boolean ordered){
        ArrayList<Duck> ducks = generateList(n, range);
        if (ordered)
            order(ducks);

        MergeSort<Duck> merge = new MergeSort<>();
        QuickSort<Duck> quick =new QuickSort<>();
        HeapSort<Duck> heap = new HeapSort<>();


        long t1 = System.nanoTime(), t2;
        merge.sort(ducks);
        t2 = System.nanoTime();

        long t3 = System.nanoTime(), t4;
        quick.sort(ducks);
        t4 = System.nanoTime();

        long t5 = System.nanoTime(), t6;
        heap.sort(ducks);
        t6=System.nanoTime();

        if (ordered)
            System.out.print("ordered, ");

        System.out.println(n +" elements");
        System.out.println("merge sort: " + (t2-t1) + "ns");
        System.out.println("quick sort: " + (t4-t3) + "ns");
        System.out.println("heap sort:  " + (t6-t5) + "ns");
        System.out.println();
    }

    public static void order(ArrayList<Duck> list){
        int size = list.size();

        for(int i = size / 2; i < size; i++){
            Duck temp = list.get(i);
            int j;
            for (j = i; j >= size / 2 && list.get(j - size / 2).compareTo(temp) > 0; j -= size / 2)
                list.set(j, list.get(j - size / 2));
            list.set(j, temp);
        }
    }

    public static void printArr(ArrayList<Duck> list){
        for (Duck d : list)
            System.out.print(d.toString());
        System.out.println();
    }

    public static void testSorts(){
        ArrayList<ArrayList<Duck>> ducksTab = new ArrayList<>();
        String[] strings ={"merge", "quick", "heap"};
        for (int i = 0; i < 3; i++)
            ducksTab.add(generateList(10,10));
        for (int i = 0; i < 3; i++)
            printArr(ducksTab.get(i));

        MergeSort<Duck> merge =new MergeSort<>();
        QuickSort<Duck> quick = new QuickSort<>();
        HeapSort<Duck> heap = new HeapSort<>();

        ducksTab.set(0,merge.sort(ducksTab.get(0)));
        quick.sort(ducksTab.get(1));
        heap.sort(ducksTab.get(2));
        System.out.println();

        for (int i = 0; i < 3; i++){
            System.out.print(strings[i] + " ");
            printArr(ducksTab.get(i));
        }
        System.out.println();
    }

    public static ArrayList<Duck> generateList(int n, int range) {
        ArrayList<Duck> ducks = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++)
            ducks.add(new Duck(random.nextInt(range)));
        return ducks;
    }

    public static void main(String [] args){
        testSorts();
        testGenerator(100,10000,false);
        testGenerator(100,10000,true);
        testGenerator(1000,10000,false);
        testGenerator(1000,10000,true);
        testGenerator(10000,10000,false);
        testGenerator(10000,10000,true);
        testGenerator(100000,10000,false);
        testGenerator(1000000,10000,false);
    }
}
