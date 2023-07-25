package LinkedList.Lesson2_5.Exercise3;

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
            System.out.println(node.data);
        }
    }

    //remove node
    public boolean removeNode(T data) {
        var x = head;
        var prevX = head;
        while (x != null) {
            if (x.data.equals(data)) {
                break;
            }
            prevX = x;
            x = x.next;
        }
        return removeSwitcher(x, prevX);
    }

    private boolean removeSwitcher(Node<T> x, Node<T> prevX) {
        if (x != null) {
            // xóa x, x là node head
            if (x == head) {
                head = x.next;
                x.next = null;
            } else if (x == tail) { // xóa x, x là node tail
                prevX.next = x.next;
                tail = prevX;
            } else { // xóa x, x là node (head, tail)
                prevX.next = x.next;
                x.next = null;
            }
            return true; // xóa node thành công
        } else {
            return false; // xóa thất bại
        }
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
}
