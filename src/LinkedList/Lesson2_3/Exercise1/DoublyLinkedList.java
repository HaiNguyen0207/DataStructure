package LinkedList.Lesson2_3.Exercise1;


public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    // insert head
    public void insertHead(T data) {
        Node<T> p = new Node<>(data);
        if (head == null) {
            head = p;
            tail = p;
        } else {
            p.next = head;
            head.previously = p;
            head = p;
        }
        System.out.println("Success !");
    }

    //insert tail;
    public void insertTail(T data) {
        Node<T> p = new Node<>(data);
        if (tail == null) {
            tail = p;
            head = p;
        } else {
            tail.next = p;
            p.previously = tail;
            tail = p;
        }
        System.out.println("Success !");
    }

    //insert after x
    public void insertAfter(T data, T x) {
        Node<T> p = new Node<>(data);
        Node<T> nodeX = head;
        while (nodeX != null) {
            if (nodeX.data.equals(x)) {
                break;
            }
            nodeX = nodeX.next;
        }
        if (nodeX != null && nodeX.equals(tail)) {
            insertTail(p.data);
        } else if (nodeX != null) {
            p.next = nodeX.next;
            p.previously = nodeX;
            nodeX.next.previously = p;
            nodeX.next = p;
            System.out.println("Success !");
        }
        if (nodeX == null) {
            System.out.println("Fail ! Please try agin ! ");
        }
    }

    //show node order head -> tail
    public void showNodeHeadTail() {
        for (var node = head;
             node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    //show node order tail -> head
    public void showNodeTailHead() {
        for (var node = tail;
             node != null; node = node.previously) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    // insert before x
    public void insertBefore(T data, T x) {
        Node<T> p = new Node<>(data);
        Node<T> nodeX = head;
        Node<T> nodeBeforeX = head;
        while (nodeX != null) {
            if (nodeX.data.equals(x)) {
                break;
            }
            nodeBeforeX = nodeX;
            nodeX = nodeX.next;
        }
        if (nodeX != null && nodeX.equals(head)) {
            insertHead(p.data);
        } else if (nodeX != null) {
            p.next = nodeX; //update next p
            p.previously = nodeBeforeX; //update previously p
            nodeX.previously = p; //update previously nodeX
            nodeBeforeX.next = p; //update next nodeBeforeX
            System.out.println("Success !");
        }
        if (nodeX == null) {
            System.out.println("Fail ! Please try agin ! ");
        }
    }

    // find node middle
    public void findNodeMiddle() {
        int count = sumElementNode();
        if (count % 2 == 0) {
            showNodeMiddle(count / 2);
        } else {
            showNodeMiddle((count / 2) + 1);
        }
    }

    private void showNodeMiddle(int i) {
        Node<T> node = head;
        int count = 1;
        while (node != null) {
            if (count == i) {
                break;
            }
            count++;
            node = node.next;
        }
        if (node != null) {
            System.out.println("Node middle : " + node.data);
        } else {
            System.out.println("Null");
        }
    }

    private int sumElementNode() {
        int count = 0;
        Node<T> node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }//insert node after order k

    public void insertAfterK(T data, int k) {
        Node<T> p = new Node<>(data);
        Node<T> nodeK = head;
        var count = 1;
        while (nodeK != null) {
            if (k == count) {
                break;
            }
            count++;
            nodeK = nodeK.next;
        }
        if (nodeK != null) {
            insertAfter(p.data, nodeK.data);
        } else {
            System.out.println("Null ! ");
        }
    }

    public void insetAfterMiddle(T valueMiddle) {
        if (sumElementNode() % 2 == 0) {
            insertAfterK(valueMiddle, sumElementNode() / 2);
        } else {
            insertAfterK((valueMiddle), (sumElementNode() / 2) + 1);
        }
    }

    class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> previously;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.previously = null;
        }
    }
}
