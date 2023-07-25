package Trees.Lesson5_7.Test;

public class BinarySearchTrees<T extends Comparable<T>> {
    private Node<T> root;

    public BinarySearchTrees() {
        this.root = null;
    }

    //add node
    public void add(T t) {
        root = insert(root, t);
    }

    // add node using loop
    public void addNodeUsingLoop(T t) {
        Node newNode = new Node(t);
        if (root == null) {
            root = newNode;
        } else {
            var p = root;
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

    //traversal trees

    //in order
    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(Node<T> r) {
        if (r != null) {
            inOrder(r.leftNode);
            System.out.print(r.data + " ");
            inOrder(r.rightNode);
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

    //count leaf node
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

    //remove
    public void remove(T t) {
        this.root = remove(this.root, t);
    }

    private Node<T> remove(Node<T> r, T t) {
        if (r == null) {
            return null;
        } else if (r.data.compareTo(t) > 0) {
            r.leftNode = remove(r.leftNode, t);
        } else if (r.data.compareTo(t) < 0) {
            r.rightNode = remove(r.rightNode, t);
        } else {
            if (r.leftNode == null) {
                r = r.rightNode;
            } else if (r.rightNode == null) {
                r = r.leftNode;
            } else {
                r.data = findMinNode(r.rightNode);
                r.rightNode = remove(r.rightNode, r.data);
            }
        }
        return r;
    }

    private T findMinNode(Node<T> r) {
        while (r.leftNode != null) {
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
