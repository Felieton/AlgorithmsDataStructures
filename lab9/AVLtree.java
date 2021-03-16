import java.util.Comparator;

class AVLTree<T> {
    class Node implements Comparable<T> {
        @Override
        public int compareTo(T o) {
            return _comparator.compare(key, o);
        }

        T key;
        int height;
        Node left, right;

        Node(T obj) {
            key = obj;
            height = 1;
        }

        public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
            if(right != null) {
                right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
            }
            sb.append(prefix).append(isTail ? "└── " : "┌── ").append(key.toString()+"["+getBalance(this)+"]").append("\n");
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
    Node root;
    private final Comparator<T> _comparator;

    public AVLTree(Comparator<T> comp){
        this._comparator=comp;
        root=null;
    }

    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x; //root
    }


    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    public Node insert(Node node, T key) {

        if (node == null)
            return (new Node(key));

        if (_comparator.compare(key,node.key)<0)
            node.left = insert(node.left, key);
        else if (_comparator.compare(key,node.key)>0)
            node.right = insert(node.right, key);
        else
            return node;


        node.height = 1 + max(height(node.left),
                height(node.right));


        int balance = getBalance(node);

        //4 cases
        if (balance > 1 && _comparator.compare(key,node.left.key)<0)
            return rightRotate(node);

        if (balance < -1 && _comparator.compare(key,node.right.key)>0)
            return leftRotate(node);

        if (balance > 1 && _comparator.compare(key,node.left.key)>0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && _comparator.compare(key,node.right.key)<0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void print() {
        System.out.println(root.toString());
    }
}
