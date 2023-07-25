package Trees.Lesson5_3;

public class BinarySearchTrees<T extends Comparable<T>> {
    private Node<T> root;

    public BinarySearchTrees() {
        root = null;
    }

    //add
    public void add(T t) {
        root = insert(root, t);
    }

    private Node<T> insert(Node<T> r, T t) {
        if (r == null) {
            return new Node<>(t);
        } else if (r.data.compareTo(t) > 0) {
            r.leftNode = insert(r.leftNode, t);
        } else if (r.data.compareTo(t) < 0) {
            r.rightNode = insert(r.rightNode, t);
        }
        return r;
    }

    //prev order
    public void prevOrder() {
        prevOrder(root);
    }

    private void prevOrder(Node<T> r) {
        if (r != null) {
            System.out.print(r.data + " ");
            prevOrder(r.leftNode);
            prevOrder(r.rightNode);
        }
    }

    // in order
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<T> r) {
        if (r != null) {
            inOrder(r.leftNode);
            System.out.print(r.data + " ");
            inOrder(r.rightNode);
        }
    }

    //post order
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<T> r) {
        if (r != null) {
            postOrder(r.leftNode);
            postOrder(r.rightNode);
            System.out.print(r.data + " ");
        }
    }

    static class Node<T extends Comparable<T>> {
        private Node<T> leftNode;
        private Node<T> rightNode;
        private T data;

        public Node(T data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }
}
