package Trees.Lesson5_6.Exercise2;

public class BinarySearchTrees<T extends Comparable<T>> {
    private Node<T> root;

    public BinarySearchTrees() {
        this.root = null;
    }

    //add node
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

    // post order
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

    // find
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

    // count node
    public int countNode() {
        return countNode(root);
    }

    private int countNode(Node<T> r) {
        if (r == null) {
            return 0;
        }
        return 1 + countNode(r.leftNode) + countNode(r.rightNode);
    }

    // count leaf node
    public int countLeafNode() {
        return countLeafNode(root);
    }

    private int countLeafNode(Node<T> r) {
        if (r == null) {
            return 0;
        } else if (r.rightNode == null && r.leftNode == null) {
            return 1;
        } else {
            return countLeafNode(r.rightNode) + countLeafNode(r.leftNode);
        }
    }

    // remove node
    public void remove(T t) {
        root = remove(root, t);
    }

    private Node<T> remove(Node<T> r, T t) {
        if (r == null) {
            return null;
        } else if (r.data.compareTo(t) > 0) {
            r.leftNode = remove(r.leftNode, t);
        } else if (r.data.compareTo(t) < 0) {
            r.rightNode = remove(r.rightNode, t);
        } else {
            if (r.rightNode == null) {
                r = r.leftNode;
            } else if (r.leftNode == null) {
                r = r.rightNode;
            } else {
                r.data = findMinNode(r.rightNode);
                r.rightNode = remove(r.rightNode, r.data);
            }
        }
        return r;
    }

    private T findMinNode(Node<T> r) {
        if (r.leftNode != null) {
            r = r.leftNode;
        }
        return r.data;
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
