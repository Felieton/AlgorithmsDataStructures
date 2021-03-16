import java.util.Comparator;
import java.util.NoSuchElementException;

public class BST<T> {

    class Node{
        T value;
        Node left, right;

        Node (T obj){
            this.value=obj;
        }

        Node (T obj, Node leftNode, Node rightNode){
            this.value = obj;
            this.left = leftNode;
            this.right = rightNode;
        }
    }

    private final Comparator<T> _comparator;
    private Node _root;

    public BST(Comparator<T> comp){
        this._comparator = comp;
        _root = null;
    }

    public class Executor implements IExecutor<Duck,String>{

        StringBuffer line = new StringBuffer();

        @Override
        public void execute(Duck elem) {
            line.append(elem+"; ");
        }

        @Override
        public String getResult() {
            line.delete(line.length() - 2, line.length());
            return line.toString();
        }
    }

    private Node search(T elem){
        Node node = _root;
        int cmp = 0;

        while (node != null && (cmp = _comparator.compare(elem, node.value)) != 0){
            if (cmp < 0)
                node = node.left;
            else
                node = node.right;
        }
        return node;
    }

    public T find(T elem){
        Node node = search(elem);
        if (node == null)
            return null;

        return node.value;
    }

    public <R> void inOrderWalk(IExecutor<T,R> exec){
        inOrderWalk(_root, exec);
    }

    public <R> void inOrderWalk(Node node, IExecutor<T,R> exec){
        if (node != null){
            inOrderWalk(node.left,exec);
            exec.execute(node.value);
            inOrderWalk(node.right,exec);
        }
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
        Node node = getMax(_root);

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
        if (node == null) throw new NoSuchElementException();
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
        _root=insert(_root,elem);
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
            int cmp = _comparator.compare(elem,node.value);
            if(cmp < 0)
                node.left = delete(elem,node.left);
            else if(cmp > 0)
                node.right = delete(elem, node.right);
            else if(node.left != null && node.right != null)
                node.right = detachMin(node, node.right);
            else{
                if(node.left != null)
                    return node.left;
                else return node.right;
            }
        }

        return node;
    }
    private Node detachMin(Node del, Node node) {
        if(node.left != null) node.left = detachMin(del, node.left);
        else {
            del.value = node.value;
            node = node.right;
        }

        return node;
    }
}
