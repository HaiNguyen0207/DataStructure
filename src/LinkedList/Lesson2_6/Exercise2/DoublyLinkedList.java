package LinkedList.Lesson2_6.Exercise2;


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

    //show node head to tail
    public void showNodeHeadToTail() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    //show node tail to head;
    public void showNodeTailToHead() {
        for (var node = tail; node != null; node = node.previous) {
            System.out.print(node.data+" -> ");
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
        } else {
            if (x.equals(head)) {
                removeHead(x);
            } else if (x.equals(tail)) {
                removeTail(x);
            } else {
                removeNodeX(x);
            }
            return true;
        }
    }

    private void removeNodeX(Node<T> x) {
        x.previous.next = x.next;
        x.next.previous = x.previous;
        x.next = null;
        x.previous = null;
    }

    private void removeTail(Node<T> x) {
        tail = x.previous;
        x.previous.next = null;
        x.previous = null;
    }

    private void removeHead(Node<T> x) {
        head = x.next;
        x.next.previous = null;
        x.next = null;
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
