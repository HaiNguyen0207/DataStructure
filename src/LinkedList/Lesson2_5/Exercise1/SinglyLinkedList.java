package LinkedList.Lesson2_5.Exercise1;

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

    //remove node
    public boolean removeNode(T data) {
        var nodeX = head;
        var nodePrevX = head;
        while (nodeX != null) {
            if (nodeX.data.equals(data)) {
                break;
            }
            nodePrevX = nodeX;
            nodeX = nodeX.next;
        }
        if (nodeX != null) {
            if (nodeX.equals(head)) {
                head = nodeX.next;
                nodeX.next = null;
            } else if (nodeX.equals(tail)) {
                nodePrevX.next = nodeX.next;
                tail = nodePrevX;
            } else {
                nodePrevX.next = nodeX.next;
                nodeX.next = null;
            }
            return true;
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
