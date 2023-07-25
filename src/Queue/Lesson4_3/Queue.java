package Queue.Lesson4_3;

public class Queue<E> {
    private int currentElement;
    private LinkList<E> data;

    public Queue() {
        currentElement = 0;
        data = new LinkList<>();
    }

    //enqueue
    public void enQueue(E e) {
        currentElement++;
        data.add(e);
    }

    //deQueue
    public E delQueue() {
        if (currentElement != 0) {
            currentElement--;
        }
        return data.remove();
    }

    public boolean isEmpty() {
        return currentElement == 0;

    }

    //peek
    public E peek() {
        return data.front();

    }

    //get size
    public int size() {
        return currentElement;

    }
}
