package LinkedList.Lesson2_6.Exercise3;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

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
        for (var node = head;
             node != null; node = node.next) {
            System.out.println(node.data);
        }
    }

    //show node tail to head
    public void showNodeTailTHead() {
        for (var node = tail;
             node != null; node = node.previous) {
            System.out.println(node.data);
        }
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

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
}
