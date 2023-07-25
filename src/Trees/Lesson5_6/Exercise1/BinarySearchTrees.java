package Trees.Lesson5_6.Exercise1;

public class BinarySearchTrees<T extends Comparable<T>> {
    private Node<T> root;

    //add node in to trees
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

    // browser binary search trees
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

    // previous
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

    //post
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

    // serach
    public boolean search(T t) {
        return search(root, t);
    }

    private boolean search(Node<T> r, T t) {
        if (r == null) {
            return false;
        } else if (r.data.compareTo(t) == 0) {
            return true;
        } else if (r.data.compareTo(t) > 0) {
            return search(r.leftNode, t);
        } else {
            return search(r.rightNode, t);
        }
    }

    //count node
    public int countNodes() {
        return countNodes(this.root);
    }

    private int countNodes(Node<T> r) {
        if (r == null) {
            return 0;
        }
        return 1 + countNodes(r.rightNode) + countNodes(r.leftNode);
    }

    // count node leaf
    public int countLeafNode() {
        return countLeafNode(root);
    }

    private int countLeafNode(Node<T> r) {
        if (r == null) {
            return 0;
        }
        if (r.rightNode == null && r.leftNode == null) {
            return 1;
        }
        return countLeafNode(r.rightNode) + countLeafNode(r.leftNode);
    }

    public BinarySearchTrees() {
        this.root = null;
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
