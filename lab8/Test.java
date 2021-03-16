import java.util.Comparator;
import java.util.Random;

public class Test {
   private BST<Duck> tree;

    public Test(){
        tree=new BST<Duck>(new Comparator<Duck>() {
            @Override
            public int compare(Duck d1, Duck d2) {
                return d1.getSize() - d2.getSize();
            }});
    }

    public void exampleTrees(){
        tree.insert(new Duck(5));
        tree.insert(new Duck(13));
        tree.insert(new Duck(1));
        tree.insert(new Duck(23));
        tree.insert(new Duck(7));
        tree.insert(new Duck(12));
        tree.insert(new Duck(33));
        tree.insert(new Duck(41));
        tree.insert(new Duck(55));
        tree.insert(new Duck(79));
        tree.insert(new Duck(88));
    }

    private void printWalks() {
        BST.Executor exec= new BST.Executor();

        System.out.println(exec.getResult());
        System.out.println("in-order");
        tree.inOrderWalk(exec);
        System.out.println(exec.getResult()+"\n");

        System.out.println("pre-order");
        tree.preOrderWalk(exec);
        System.out.println(exec.getResult()+"\n");

        System.out.println("post-order");
        tree.postOrderWalk(exec);
        System.out.println(exec.getResult()+"\n");

        System.out.println("level-order");
        tree.levelOrder();
        System.out.println("\n");

    }

    public void testComplexity() {
        Random rand = new Random();

        int[] numbers= {1,5,7,12,13,23,41,55,79,88};
        double complexity = 0;
        for (int i = 0; i < 10000; i++) {
            tree.search(new Duck(numbers[rand.nextInt(numbers.length)]));
            complexity += tree.getComplexity();
            tree.clearComplexity();
        }
        complexity /= 10000.0;

        System.out.println("number of operations: " + complexity);
    }

    public static void main(String[] args){
        Test test = new Test();
        test.exampleTrees();
        test.printWalks();
        test.tree.print();
        test.testComplexity();
        test.tree.DSW();
        test.tree.print();
        System.out.println("after DSW ");
        test.testComplexity();
    }
}
