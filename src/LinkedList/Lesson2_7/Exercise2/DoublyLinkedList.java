package LinkedList.Lesson2_7.Exercise2;

public class DoublyLinkedList<T extends Comparable<T>> {
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

    //insert after x
    public void insertAfrer(T x, T data) {
        Node<T> p = new Node<>(data);
        var node = head;
        while (node != null) {
            if (node.data.equals(x)) {
                break;
            }
            node = node.next;
        }

        if (node.equals(tail) && node != null) {
            insertTail(p.data);
        } else if (node != null) {
            p.next = node.next;
            p.previous = node;
            node.next.previous = p;
            node.next = p;
        }
    }

    //insert before x
    public void insertBefore(T x, T data) {
        Node<T> p = new Node<>(data);
        Node<T> nodeX = head;
        while (nodeX != null) {
            if (nodeX.data.equals(x)) {
                break;
            }
            nodeX = nodeX.next;
        }
        if (nodeX != null && nodeX.equals(head)) {
            insertHead(p.data);
        } else if (nodeX != null) {
            p.next = nodeX;
            p.previous = nodeX.previous;
            nodeX.previous.next = p;
            nodeX.previous = p;
        }
    }

    //show node
    public void showNodeHeadToTail() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    //show node
    public void showNodeTailToHead() {
        for (var node = tail; node != null; node = node.previous) {
            System.out.print(node.data + " -> ");
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
