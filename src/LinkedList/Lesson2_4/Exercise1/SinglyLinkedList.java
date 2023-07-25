package LinkedList.Lesson2_4.Exercise1;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    //insert head
    public void insertHead(T data) {
        Node<T> p = new Node<>(data);
        if (head == null) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    //insert tail
    public void insertTail(T data) {
        Node<T> p = new Node<>(data);
        if (tail == null) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    //show node
    public void showNode() {

        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    //update node
    public boolean updateNode(T oldData, T newData) {
        Node<T> newP = new Node<>(newData);

        Node<T> oldP = new Node<>(oldData);
        for (var node = head; node != null; node = node.next) {
            if (node.data.equals(oldP.data)) {
                node.data = newP.data;
                return true;   //update Success
            }
        }
        return false;//update fail
    }
}
