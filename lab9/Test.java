import java.util.Comparator;

public class Test {
    private AVLTree<Duck> AVLtree;

    public Test(){
        AVLtree = new AVLTree<Duck>(new Comparator<Duck>() {
            @Override
            public int compare(Duck d1, Duck d2) {
                return d1.getSize()-d2.getSize();
            }});
    }

    public void showAVL(){
        Test test = new Test();
        int[] sizes = {10, 20, 30, 40, 50, 12, 43, 3, 44, 400, 401, 10};
        for (int size : sizes) {
            test.AVLtree.root = test.AVLtree.insert(test.AVLtree.root, new Duck(size));
            test.AVLtree.print();
        }
    }

    public void testTrie() {
        TrieTree trie = new TrieTree();
        int complexity;
        String[] keys = {"dog", "elephant", "doggo", "verynicehatdsadlaspdlsapdl"};

        for (int i = 0; i < keys.length; i++) {
            complexity = 0;
            trie.insert(keys[i]);

            for (int j = 0; j < 1000; j++) {
                trie.search(keys[i]);
                complexity += trie.getComplexity();
                trie.clearComplexity();
            }
            complexity /= 1000;
            System.out.println(keys[i] + ", length= " + keys[i].length() + ", complexity= " + complexity);
        }
    }

    public static void main (String[]args){
        Test test = new Test();
        test.showAVL();
        test.testTrie();
    }
}
