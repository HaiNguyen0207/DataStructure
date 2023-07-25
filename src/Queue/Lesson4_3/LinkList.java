package Queue.Lesson4_3;

public class LinkList<E>{
    private Node<E> head;
    private Node<E> tail;

    public LinkList() {
    }
    //add
    public void add(E e) {
        Node p = new Node(e);
        if(isEmpty()) {
            head = tail = p;
        }else {
            tail.next = p;
            tail = p;
        }
    }
    // remove
    public E remove() {
        if(!isEmpty()) {
            E p = head.data;
            head = head.next;
            return  p;
        }
        return  null;
    }
    //get element first
    public E front() {
        return isEmpty() ? null : head.data;
    }


    public boolean isEmpty() {
        return  head == null;
    }


    static class Node<E> {
        private E data;
        private Node<E>  next;

        public Node(E data) {
            this.data= data;
            this.next = null;
        }
    }

}
