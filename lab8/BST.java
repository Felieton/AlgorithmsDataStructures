import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class BST<T> {

    class Node implements Comparable<T>{
        @Override
        public int compareTo(T o) {
            return _comparator.compare(value, o);
        }

        T value;
        Node left,right;

        Node (T obj){
            this.value = obj;
            this.left = null;
            this.right = null;
        }

        Node (T obj, Node leftNode, Node rightNode){
            this.value = obj;
            this.left = leftNode;
            this.right = rightNode;
        }

        public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
            if(right != null) {
                right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
            }
            sb.append(prefix).append(isTail ? "└── " : "┌── ").append(value.toString()).append("\n");
            if(left != null) {
                left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
            }

            return sb;
        }

        @Override
        public String toString() {
            return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
        }
    }

    private final Comparator<T> _comparator;
    private Node _root;
    private int complexity;

    public BST(Comparator<T> comp){
        this._comparator = comp;
        _root = null;
    }

    public static class Executor implements IExecutor<Duck,String>{
        StringBuffer line = new StringBuffer();
        StringBuffer line2 = new StringBuffer();

        @Override
        public void execute(Duck elem) {
            line.append(elem + "; ");
        }

        @Override
        public String getResult() {
            if (line2.length()!=0)
                line2.delete(0,line2.length());

            line2.append(line);
            line.delete(0,line.length());

            return line2.toString();
        }
    }

    private Node search(Node root, T value) {
        complexity++;

        if (root == null)
            return null;

        complexity++;
        if (root.compareTo(value) == 0)
            return root;

        complexity++;
        if (root.compareTo(value) > 0)
            return search(root.left, value);

        return search(root.right, value);
    }

    public Node search(T value) {
        complexity = 0;
        return search(_root, value);
    }

    public <R> void inOrderWalk(IExecutor<T,R> exec){
        inOrderWalk(_root, exec);
    }

    public <R> void inOrderWalk(Node node, IExecutor<T,R> exec){
        if (node != null) {
            inOrderWalk(node.left, exec);
            exec.execute(node.value);
            inOrderWalk(node.right, exec);
        }
    }

    public <R> void preOrderWalk(IExecutor<T,R> exec){
        preOrderWalk(_root, exec);
    }

    public <R> void preOrderWalk(Node node, IExecutor<T,R> exec){
        if (node != null) {
            exec.execute(node.value);
            preOrderWalk(node.left, exec);
            preOrderWalk(node.right, exec);
        }
    }

    public <R> void postOrderWalk(IExecutor<T,R> exec){
        postOrderWalk(_root,exec);
    }

    public <R> void postOrderWalk(Node node, IExecutor<T,R> exec){
        if (node != null){
            postOrderWalk(node.left, exec);
            postOrderWalk(node.right, exec);
            exec.execute(node.value);
        }
    }

    private int computeHeight(Node root) {
        if (root == null)
            return 0;

        else {
            int leftHeight = computeHeight(root.left);
            int rightHeight = computeHeight(root.right);

            if(leftHeight > rightHeight)
                return(leftHeight+1);

            return(rightHeight+1);
        }
    }

    private void printLevel(Node root , int level) {
        if (root == null)
            return;

        if (level == 1)
            System.out.print(root.value.toString() + " ");

        else if (level > 1) {
            printLevel(root.left, level-1);
            printLevel(root.right, level-1);
        }
    }

    public void levelOrder() {
        int h = computeHeight(_root);
        for (int i = 0; i < h; i++)
            printLevel(_root, i + 1);
    }

    public T getMin(){
        if (_root == null)
            throw new NoSuchElementException();
        Node node = getMin(_root);

        return node.value;
    }

    public T getMax(){
        if (_root == null)
            throw new NoSuchElementException();

        Node node=getMax(_root);

        return node.value;
    }

    private Node getMin(Node node){
        assert (node != null);

        while (node.left != null)
            node = node.left;

        return node;
    }

    private Node getMax(Node node){
        assert (node != null);

        while (node.right != null)
            node = node.right;

        return node;
    }

    public T successor(T elem){

        Node succNode=successorNode(_root, elem);
        return succNode == null ? null:succNode.value;
    }

    private Node successorNode(Node node, T elem) {
        if (node == null)
            throw new NoSuchElementException();

        int cmp = _comparator.compare(elem, node.value);

        if (cmp == 0) {
            if (node.right != null)
                return getMin(node.right);
            else return null;
        } else if (cmp < 0) {
            Node retNode = successorNode(node.left, elem);
            if (retNode == null)
                return node;
            else return retNode;
        } else
            return successorNode(node.right, elem);
    }

    public void insert(T elem){
        _root = insert(_root, elem);
    }

    private Node insert(Node node, T elem) {
        if (node == null)
            node = new Node(elem);
        else {
            int cmp = _comparator.compare(elem, node.value);
            if (cmp < 0)
                node.left = insert(node.left, elem);
            else if (cmp > 0)
                node.right = insert(node.right, elem);
            else
                throw new IllegalArgumentException(elem.toString());
        }

        return node;
    }

    protected Node delete(T elem, Node node) {
        if(node == null) throw new NoSuchElementException();
        else {
            int cmp = _comparator.compare(elem, node.value);
            if (cmp < 0)
                node.left = delete(elem, node.left);
            else if (cmp > 0)
                node.right = delete(elem,node.right);
            else if (node.left != null && node.right != null)
                node.right = detachMin(node, node.right);
            else {
                if (node.left != null)
                    return node.left;

                else
                    return node.right;
            }
        }
        return node;
    }
    private Node detachMin(Node del, Node node) {
        if (node.left != null)
            node.left = detachMin(del, node.left);
        else {
            del.value = node.value;
            node = node.right;
        }

        return node;
    }

    private void sortNodes(Node root, ArrayList<Node> nodes) {
        if (root == null)
            return;

        sortNodes(root.left, nodes);
        nodes.add(root);
        sortNodes(root.right, nodes);
    }

    private Node buildTree(ArrayList<Node> nodes, int left, int right) {
        if (left > right)
            return null;

        int mid = (left + right) / 2;
        Node node = nodes.get(mid);

        node.left = buildTree(nodes, left, mid - 1);
        node.right = buildTree(nodes, mid + 1, right);

        return node;
    }

    public void DSW() {
        ArrayList<Node> nodes = new ArrayList<>();
        sortNodes(_root, nodes);
        _root = buildTree(nodes, 0, nodes.size() - 1);
    }


    public int getComplexity() {
        return complexity;
    }

    public void clearComplexity(){
        this.complexity=0;
    }

    public void print() {
        System.out.println(_root.toString());
    }
}
