package LinkedList.Lesson2_4.Exercise3;


public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    //insert tail;
    public void insertTail(T data) {
        Node<T> p = new Node<>(data);
        if (tail == null) {
            head = tail = p;
        } else {
            tail.next = p;
            p.previous = tail;
            tail = p;
        }
    }

    // insert head;
    public void insertHead(T data) {
        Node<T> p = new Node<>(data);
        if (head == null) {
            head = tail = p;
        } else {
            p.next = head;
            head.previous = p;
            head = p;
        }
    }

    //showNode
    public void showNode() {
        for (var node = head; node != null; node = node.next) {
            System.out.println(node.data);
        }
    }

    // upate node
    public boolean updateNodeData(T oldData, T newData) {
        Node<T> p = new Node<>(newData);
        Node<T> oldP = new Node<>(oldData);
        for (var node = head; node != null; node = node.next) {
            if (node.data.equals(oldP.data)) {
                node.data = p.data;
                return true;
            }
        }
        return false;
    }

    class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> previous;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

}
