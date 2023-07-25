package Trees.Lesson5_2.Exercise1;

public class BinarySearchTrees<T extends Comparable<T>> {
    private Node<T> root;

    public BinarySearchTrees() {
        this.root = null;
    }


    public void add(T t) {
        root = insert(root, t);
    }

    public void addNewNodeUsingLoop(T t) {
        Node newNode = new Node(t);
        if (root == null) {
            root = newNode;
        } else {
            Node p = root;
            while (true) {
                if (p.data.compareTo(t) > 0) {
                    if (p.leftNode != null) {
                        p = p.leftNode;
                    } else {
                        p.leftNode = newNode;
                        break;
                    }
                }
                if (p.data.compareTo(t) < 0) {
                    if (p.data.compareTo(t) < 0) {
                        if (p.rightNode != null) {
                            p = p.rightNode;
                        } else {
                            p.rightNode = newNode;
                            break;
                        }
                    }
                }
            }
        }

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

    // show trees;
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
