package LinkedList.Lesson2_2.Exercise2;

public class SinglyLinkedList<T> {
    private Node<T> head;

    public class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    //insert head
    public void insertHead(T data) {
        Node<T> p = new Node<>(data);
        if (head == null) {
            head = p;
        } else {
            p.next = head;
            head = p;
        }
        System.out.println("Success ! ");
    }

    //insert tail
    public void insertTail(T data) {
        Node<T> p = new Node<>(data);
        Node<T> nodeTail = head;
        if (head == null) {
            head = p;
        } else {
            while (nodeTail.next != null) {
                nodeTail = nodeTail.next;
            }
            nodeTail.next = p;

        }
        System.out.println("Success ! ");
    }

    //insert after X
    public void insertAfter(T data, T x) {
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
            System.out.println("Success !");
        } else {
            System.out.println("Null ! ");
        }
    }

    //insert before x
    public void insertBefore(T data, T x) {
        Node<T> p = new Node<>(data);
        Node<T> nodeX = head;
        Node<T> nodeBeforeX = head;
        while (nodeX != null) {
            if (nodeX.data == x) {
                break;
            }
            nodeBeforeX = nodeX;
            nodeX = nodeX.next;
        }
        if (nodeX != null) {
            nodeBeforeX.next = p;
            p.next = nodeX;
            System.out.println("Success !");
        } else {
            System.out.println("Null ! ");
        }
    }

    public void insertAfterLocationK(int k, T data) {
        Node<T> p = new Node<>(data);
        int count = 1;
        Node<T> nodeK = head;
        while (nodeK != null) {
            if (count == k) {
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

    //find node  middle in linked list
    public void nodeMiddle(T data) {
        var count = sumElementNode();
        if (count % 2 == 0) {
            insertAfterLocationK(count / 2, data);
        } else {
            insertAfterLocationK((count / 2) + 1, data);
        }
    }

    public int sumElementNode() {
        var count = 0;
        for (var node = head; node != null; node = node.next) {
            count++;
        }
        return count;
    }

    //show node middle
    public void showNodeMiddle() {
        if (sumElementNode() % 2 == 0) {
            showMiddle(sumElementNode() / 2);
        } else {
            showMiddle((sumElementNode() / 2) + 1);
        }
    }

    private void showMiddle(int i) {
        var count = 1;
        Node<T> node = head;
        while (node != null) {
            if (count == i) {
                break;
            }
            count++;
            node = node.next;
        }
        System.out.println(node.data);
    }

    //show node in linked list
    public void showNode() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + "->");
        }
        System.out.println("null");
    }
}
