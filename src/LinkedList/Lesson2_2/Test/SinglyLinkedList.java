package LinkedList.Lesson2_2.Test;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // insert head
    public void insertHead(T data) {
        Node<T> p = new Node<>(data);
        if (head == null) {
            head = tail = p;
        } else {
            p.next = head;
            head =p;
        }
    }

    // insert tail
    public void insertTail(T data) {
        Node<T> p = new Node<>(data);
        if (tail == null) {
            tail = head = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    //insert node p after x;
    public void insertAfterX(T x, T data) {
        Node<T> p = new Node<>(data);
        Node<T> nodeX = head;
        while (nodeX != null) {
            if (nodeX.data == x) {
                break;
            }
            nodeX = nodeX.next;
        }
        if (nodeX != null) {
            p.next = nodeX.next;
            nodeX.next = p;
        } else {
            System.out.println("No Find Node !");
        }
    }

    //insert node p before x
    public void insertNodeBeforeX(T x, T data) {
        Node<T> p = new Node<>(data);
        Node<T> nodeX = head;
        Node<T> nodeBeforeX = head;
        while (nodeX != null) {
            if (nodeX.data == x) {
                break;
            }
            nodeBeforeX = nodeX;
            nodeX=nodeX.next;
        }
        if (nodeX != null) {
            nodeBeforeX.next =p;
            p.next =nodeX;
        } else {
            System.out.println("No Find Node !");
        }
    }

    public void showNode() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " ");
        }
        System.out.println();
    }
}
