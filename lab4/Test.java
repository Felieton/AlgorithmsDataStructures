import java.util.ArrayList;
import java.util.Random;

public class Test {

    public static void testGenerator(int n, int range, boolean ordered){
        ArrayList<Duck> ducks = generateList(n,range);
        if (ordered)
            order(ducks);

        BubbleSort<Duck> bubble =new BubbleSort<>();
        SelectSort<Duck> select = new SelectSort<>();
        InsertSort<Duck> insert = new InsertSort<>();
        ShellSort<Duck> shell1 = new ShellSort<>(n/2);
        ShellSort<Duck> shell2 = new ShellSort<>(n/4);
        ShellSort<Duck> shell3 = new ShellSort<>(4);

        @SuppressWarnings("Duplicates")
        long t1=System.nanoTime(),t2;
        bubble.sort(ducks);
        t2=System.nanoTime();
        @SuppressWarnings("Duplicates")
        long t3=System.nanoTime(),t4;
        select.sort(ducks);
        t4=System.nanoTime();

        long t5=System.nanoTime(),t6;
        insert.sort(ducks);
        t6=System.nanoTime();

        long t7=System.nanoTime(),t8;
        shell1.sort(ducks);
        t8=System.nanoTime();

        long t9=System.nanoTime(),t10;
        shell2.sort(ducks);
        t10=System.nanoTime();

        long t11=System.nanoTime(),t12;
        shell3.sort(ducks);
        t12=System.nanoTime();

        if (ordered)
        System.out.print("ordered, ");
        System.out.println(n +" elements");
        System.out.println("bubble sort: " + (t2-t1) + "ns");
        System.out.println("select sort: " + (t4-t3) + "ns");
        System.out.println("insert sort: " + (t6-t5) + "ns");
        System.out.println("shell sort with gap n/2: " + (t8-t7) + "ns");
        System.out.println("shell sort with gap n/4: " + (t10-t9) + "ns");
        System.out.println("shell sort with gap 4: " + (t12-t11) + "ns");
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
        ArrayList<ArrayList<Duck>> ducksTab = new ArrayList<ArrayList<Duck>>();
        String[] strings = {"bubble", "select", "insert", "shell"};

        for (int i = 0; i < 4; i++)
            ducksTab.add(generateList(10,10));

        for (int i = 0; i < 4; i++)
            printArr(ducksTab.get(i));
            @SuppressWarnings("Duplicate")
            BubbleSort<Duck> bubble =new BubbleSort<>();
            SelectSort<Duck> select = new SelectSort<>();
            InsertSort<Duck> insert = new InsertSort<>();
            ShellSort<Duck> shell1 = new ShellSort<>(5);
            bubble.sort(ducksTab.get(0));
            select.sort(ducksTab.get(1));
            insert.sort(ducksTab.get(2));
            shell1.sort(ducksTab.get(3));
            System.out.println();

            for (int i=0;i<4;i++){
                System.out.print(strings[i]+" ");
                printArr(ducksTab.get(i));
        }
        System.out.println();
    }

    public static ArrayList<Duck> generateList(int n, int range) {
        ArrayList<Duck> ducks = new ArrayList<>();
        Random random = new Random();

        for (int i= 0; i < n; i++)
            ducks.add(new Duck(random.nextInt(range)));

        return ducks;
    }

    public static void main(String [] args){
        testSorts();
        testGenerator(100,100,false);
        testGenerator(100,100,true);
        testGenerator(1000,100,false);
        testGenerator(1000,100,true);
        testGenerator(10000,100,false);
        testGenerator(100000,100,false);
    }
}
