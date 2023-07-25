package Trees.Lesson5_2.Test;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinarySearchTree() {
        this.root = null;
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

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node<T> r) {
        if (r != null) {
            inOrderRec(r.leftNode);
            System.out.print(r.data + " ");
            inOrderRec(r.rightNode);
        }
    }

    static class Node<T> {
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
