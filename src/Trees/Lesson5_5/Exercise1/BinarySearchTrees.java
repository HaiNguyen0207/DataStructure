package Trees.Lesson5_5.Exercise1;

public class BinarySearchTrees<T extends Comparable<T>> {
    private Node<T> root;

    public BinarySearchTrees() {
        this.root = null;
    }

    //insert
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

    // insert using for -while
    public void addUsingLoop(T t) {
        Node newNode = new Node<>(t);
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

    //brower in order
    public void inOrder() {
        inOrder(root);
    }

    //brower perv order
    public void pervOrder() {
        pervOrder(root);
    }

    private void pervOrder(Node<T> r) {
        if (r != null) {
            System.out.print(r.data + " ");
            pervOrder(r.leftNode);
            pervOrder(r.rightNode);
        }
    }

    //brower post order
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

    private void inOrder(Node<T> r) {
        if (r != null) {
            inOrder(r.leftNode);
            System.out.print(r.data + " ");
            inOrder(r.rightNode);
        }
    }

    //serch
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
        return countNode(this.root);
    }

    private int countNode(Node<T> r) {
        if (r == null) {
            return 0;
        }
        return 1 + countNode(r.leftNode) + countNode(r.rightNode);
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
        return countLeafNode(r.leftNode) + countLeafNode(r.rightNode);
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
