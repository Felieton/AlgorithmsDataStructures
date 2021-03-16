import java.util.ArrayList;

public class TrieTree {
    private static final int ALPH_SIZE=26;
    private int complexity;
    private TrieNode root;

    private class TrieNode {
        ArrayList<TrieNode> children = new ArrayList<>() ;
        boolean isEndOfWord;

        private TrieNode(){
            isEndOfWord = false;

            for (int i = 0; i < ALPH_SIZE; i++)
                children.add(null);
        }
    }

    public TrieTree(){
        root = new TrieNode();
    }

    public void insert(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode tNode = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (tNode.children.get(index) == null)
                tNode.children.set(index,new TrieNode());
            tNode = tNode.children.get(index);
        }

        tNode.isEndOfWord = true;
    }

    public boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode tNode = root;

        for (level = 0; level < length; level++) {
            complexity++;
            index = key.charAt(level) - 'a';

            if (tNode.children.get(index) == null)
                return false;

            tNode = tNode.children.get(index);
        }

        return (tNode != null && tNode.isEndOfWord);
    }

    public ArrayList<TrieNode> getChildren(TrieNode n){
        return n.children;
    }

    public int getComplexity(){
        return complexity;
    }

    public void clearComplexity(){
        this.complexity=0;
    }
}
