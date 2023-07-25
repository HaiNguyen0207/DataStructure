package LinkedList.Lesson2_5.Exercise2;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

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

    //remove all node value x
    public boolean removeAllNode(T data) {
        var x = head;
        var prevX = head;
        while (x != null) {
            if (x.data.equals(data)) {
                break;
            }
            prevX = x;
            x = x.next;
        }
        if (x != null) {
            if (x.equals(head)) {
                head = x.next;
                x.next = null;
            } else if (x.equals(tail)) {
                prevX.next = x.next;
                tail = prevX;
            } else {
                prevX.next = x.next;
                x.next = null;
            }
            return  true;
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
