package LinkedList.Lesson2_7.Exercise1;


public class SinglyLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;

    //insert head
    public void insertHead(T data) {
        var p = new Node<>(data);
        if (head == null) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    //inset tail
    public void insertTail(T data) {
        var p = new Node<>(data);
        if (tail == null) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    //insert void insertAfter
    public void insertAfter(T x, T data) {
        var p = new Node<>(data);
        Node<T> nodeX = null;
        for (nodeX = head; nodeX != null; nodeX = nodeX.next) {
            if (nodeX.data.equals(x)) {
                break;
            }
        }
        if (nodeX.equals(tail)) {
            insertTail(data);
        } else {
            p.next = nodeX.next;
            nodeX.next = p;
        }
    }

    //insert before
    public void insertBefore(T x, T data) {
        var p = new Node<>(data);
        Node<T> nodeX = null;
        Node<T> nodeBeforeX = null;
        for (nodeX = head; nodeX != null; nodeX = nodeX.next) {
            if (nodeX.data.equals(x)) {
                break;
            }
            nodeBeforeX = nodeX;
        }
        if (nodeX.equals(head)) {
            insertHead(data);
        } else {
            nodeBeforeX.next = p;
            p.next = nodeX;
        }
    }

    //show node
    public void showNode() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " - > ");
        }
        System.out.println("null");
    }

    //sort list
    public void sortList() {
        Node<T> a = head;
        Node<T> b = null;
        while (a != null) {
            b = a.next;
            while (b != null) {
                if (a.data.compareTo(b.data) > 0) {
                    var tmp = a.data;
                    a.data = b.data;
                    b.data = tmp;
                }
                b = b.next;
            }
            a = a.next;
        }
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
