package LinkedList.Lesson2_4.Exercise2;


public class SinLyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    //insert head;
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

    // update node data
    public boolean updateNodeData(T oldData, T newDada) {
        Node<T> newP = new Node<>(newDada);
        for (var node = head; node != null; node = node.next) {
            if (node.data.equals(oldData)) {
                node.data = newP.data;
                return true;
            }
        }
        return false;
    }

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
