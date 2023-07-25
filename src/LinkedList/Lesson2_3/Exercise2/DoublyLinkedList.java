package LinkedList.Lesson2_3.Exercise2;

public class DoublyLinkedList<T> {

    private Node<T> head;

    //insert head;
    public void insertHead(T data) {
        Node<T> p = new Node<>(data);
        if (head == null) {
            head = p;
        } else {
            p.next = head;
            head.previously = p;
            head = p;
        }
        System.out.println("Success ! ");
    }

    //insert tail
    public void insertTail(T data) {
        Node<T> p = new Node<>(data);
        if (head == null) {
            head = p;
        } else {
            var tail = nodeTail();
            tail.next = p;
            p.previously = tail;
        }
        System.out.println("Success !");
    }

    //insert After x
    public void insertAfter(T data, T x) {
        Node<T> p = new Node<>(data);
        Node<T> nodeX = head;
        while (nodeX.next != null) {
            if (nodeX.data.equals(x)) {
                break;
            }
            nodeX = nodeX.next;
        }
        if (nodeX != null && nodeX.equals(nodeTail())) {
            insertTail(p.data);
        } else if (nodeX != null) {
            p.next = nodeX.next;
            p.previously = nodeX;
            nodeX.next.previously = p;
            nodeX.next = p;
            System.out.println("Success !");
        }
    }

    //insert before x
    public void insertBefore(T data, T x) {
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
        if (nodeX != null && nodeX.equals(head)) {
            insertHead(p.data);
        } else if (nodeX != null) {
            p.next = nodeX;
            p.previously = nodeBeforeX;
            nodeX.previously = p;
            nodeBeforeX.next = p;
        }
    }

    //show node head -> tail
    public void showHeadToTail() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    //show node Tail-Head
    public void showNodeTailToHead() {
        for (var node = nodeTail(); node != null; node = node.previously) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    //find node tail
    public Node<T> nodeTail() {
        Node<T> node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    public void insertAfterOrder(T valueK, int k) {
        var count = 1;
        Node<T> p = new Node<>(valueK);
        Node<T> nodeOrderK = head;
        while (nodeOrderK != null) {
            if (k == count) {
                break;
            }
            count++;
            nodeOrderK = nodeOrderK.next;
        }
        if (nodeOrderK != null && nodeOrderK.equals(nodeTail())) {
            insertTail(p.data);
        } else if (nodeOrderK != null) {
            p.next = nodeOrderK.next;
            p.previously = nodeOrderK;
            nodeOrderK.next.previously = p;
            nodeOrderK.next = p;
            System.out.println("Sucess ! ");
        }
        if (nodeOrderK == null) {
            System.out.println("=== > Fail ! Please try again ! <=== ");
        }
    }

    //find node middle
    public Node<T> findNodeMiddle() {
        var nodeCurrent = head;
        var nodeMidle = head;
        while (nodeCurrent != null && nodeCurrent.next != null
                && nodeCurrent.next.next != null) {
            nodeCurrent = nodeCurrent.next.next;
            nodeMidle = nodeMidle.next;
        }
        return nodeMidle;
    }

    //show node middle
    public void showNodeMiddle() {
        var node = findNodeMiddle();
        if (node != null) {
            System.out.println(node.data);
        } else {
            System.out.println("Null ! ");
        }
    }

    //insert node after middle
    public void insertAfterMiddle(T valueMiddle) {
        Node<T> p = new Node<>(valueMiddle);
        var nodeMiddle = findNodeMiddle();
        if (nodeMiddle != null) {
            p.next = nodeMiddle.next;
            p.previously = nodeMiddle;
            nodeMiddle.next.previously = p;
            nodeMiddle.next = p;
        } else {
            System.out.println(" Null ");
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
