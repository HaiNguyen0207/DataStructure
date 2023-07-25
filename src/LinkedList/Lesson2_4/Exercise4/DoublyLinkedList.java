package LinkedList.Lesson2_4.Exercise4;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    //insert head;
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
        var p = new Node<>(data);
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
    public void showNode() {
        for (var node = head; node != null; node = node.next) {
            System.out.println(node.data);
        }
    }

    // update node data
    public boolean updateNodeData(T oldData, T newData) {
        Node<T> newP = new Node<>(newData);
        for (var node = head; node != null; node = node.next) {
            if (node.data.equals(oldData)) {
                node.data = newP.data;
                return true;    //update success !
            }
        }
        return false;
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

    public T getNode(T data) {
        var node = head;
        while (node != null) {
            if (node.data.equals(data)) {
                return node.data;
            }
            node=node.next;
        }
        return null;
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
