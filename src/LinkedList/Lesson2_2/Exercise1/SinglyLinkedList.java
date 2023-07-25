package LinkedList.Lesson2_2.Exercise1;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

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
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    //insert p before x ;
    public void insertBeforeX(T x, T data) {
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
            System.out.println("Null !");
        }
    }

    //insert node after K
    public void insertAfterK(int k, T data) {
        Node<T> p = new Node<>(data);
        Node<T> nodeK = head;
        int count = 1;
        while (nodeK != null) {
            if (count == k) {
                break;
            }
            nodeK = nodeK.next;
            count++;
        }
        if (nodeK != null) {
            p.next = nodeK.next;
            nodeK.next = p;
            System.out.println("Success !");
        } else {
            System.out.println("Null");
        }
    }

    //find location between linked list
    public int findNodeBetween() {
        int count = 0;
        Node<T> node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    public void showNodeBetween(int count) {
        int k = 1;
        Node<T> node = head;
        while (node != null) {
            if (k == count) {
                break;
            }
            node = node.next;
            k++;
        }
        System.out.println(node.data);
    }

    public void nodeBetween() {
        var count = findNodeBetween();
        if (count % 2 == 0) {
            showNodeBetween(count / 2); //số chẵn
        } else {
            showNodeBetween((count / 2) + 1);
        }

    }

    public void insertAfterBetween(T value) {
        var location = findNodeBetween();
        if (location % 2 == 0) {
            insertAfterK(location / 2, value);
            System.out.println("Succees !");
        }
        if (location % 2 != 0) {
            insertAfterK((location / 2) + 1, value);
            System.out.println("Succees !");
        }

    }

    public void showNode() {
        for (var node = head;
             node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }
}
