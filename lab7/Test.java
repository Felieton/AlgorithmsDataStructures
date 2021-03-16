import java.util.Comparator;
import java.util.Random;

public class Test {

    public static int[] CreateArray(int n){
        int[]tab = new int[n];

        for (int i = 0; i < n; i++)
            tab[i] = i + 1;

        return tab;
    }

    public static void testComplexityData(int bound){
        Random rand = new Random();
        BinarySearch binSearch = new BinarySearch();
        double complexity = 0;

        for (int i = 0; i < 10000; i++){
            binSearch.BinarySearch(CreateArray(bound), rand.nextInt(bound));
            complexity += binSearch.getComplexityCounter();
            binSearch.clearComplexity();
        }
        complexity /= 10000.0;

        System.out.println(binSearch.BinarySearch(CreateArray(bound), rand.nextInt(bound)));
        System.out.println("number of operations: " + complexity);
    }

    public static void testBST(){
        BST<Duck> tree = new BST<Duck>(new Comparator<Duck>() {
            @Override
            public int compare(Duck d1, Duck d2) {
                return d1.getSize() - d2.getSize();
            }});

        tree.insert(new Duck(7));
        tree.insert(new Duck(5));
        tree.insert(new Duck(2));
        tree.insert(new Duck(10));
        tree.insert(new Duck(12));
        BST.Executor exec = tree.new Executor();
        tree.inOrderWalk(exec);
        System.out.println(exec.getResult());
    }

    public static void main(String[] args){
        testComplexityData(8);
        testComplexityData(32);
        testComplexityData(512);
        testComplexityData(8192);
        System.out.println();
        testBST();
    }
}
