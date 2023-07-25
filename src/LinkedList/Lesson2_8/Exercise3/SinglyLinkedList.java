package LinkedList.Lesson2_8.Exercise3;

public class SinglyLinkedList<T> {
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
            tail = p;
        }
    }

    //insert after
    public void insertAfter(T x, T data) {
        Node<T> p = new Node<>(data);
        var nodeX = head;
        while (nodeX != null) {
            if (nodeX.data.equals(x)) {
                break;
            }
            nodeX = nodeX.next;
        }
        if (nodeX.equals(tail)) {
            insertTail(p.data);
        } else {
            p.next = nodeX.next;
            nodeX.next = p;
        }
    }

    //insert before
    public void insertBefore(T x, T data) {
        Node<T> p = new Node<>(data);
        var nodeX = head;
        var nodeBeforeX = head;
        while (nodeX != null) {
            if (nodeX.data.equals(x)) {
                break;
            }
            nodeBeforeX = nodeX;
            nodeX = nodeX.next;
        }
        if (nodeX.equals(head)) {
            insertHead(p.data);
        } else {
            nodeBeforeX.next = p;
            p.next = nodeX;
        }
    }



    // find node
    public Node<T> findNode(T x) {
        for (var node = head;
             node != null; node = node.next) {
            if (node.data.equals(x)) {
                return node;
            }
        }
        return null;
    }

    //show node
    public void showNode() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
