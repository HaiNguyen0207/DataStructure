package LinkedList.Lesson2_6.Exercise1;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    //insert head
    public void insertHead(T data) {
        Node<T> p = new Node<>(data);
        if (head == null) {
            head = p;
            tail = p;
        } else {
            p.next = head;
            head.previous = p;
            head = p;
        }
    }

    //insert tail
    public void insertTail(T data) {
        Node<T> p = new Node<>(data);
        if (tail == null) {
            head = p;
            tail = p;
        } else {
            tail.next = p;
            p.previous = tail;
            tail = p;
        }
    }

    //show node
    public void showNodeHeadToTail() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    public void showNodeTailToHead() {
        for (var node = tail; node != null; node = node.previous) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }


    //remove node
    public boolean removeNode(T data) {
        var x = head;
        while (x != null) {
            if (x.data.equals(data)) {
                break;
            }
            x = x.next;
        }
        if (x == null) {
            return false;
        } else if (x.equals(head)) {
            head = x.next;
            head.previous = null;
            x.next = null;
        } else if (x.equals(tail)) {
            tail = x.previous;
            tail.next = null;
            x.previous = null;
        } else {
            Node<T> xPrev = x.previous;
            Node<T> xNext = x.next;
            xPrev.next = x.next;
            xNext.previous = x.previous;
            x.next = null;
            x.previous = null;
        }
        return true;
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
