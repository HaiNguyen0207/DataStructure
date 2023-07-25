package Queue.Lesson4_2;

import java.util.ArrayList;

public class Queue<E> {
    private int currentElement;
    private ArrayList<E> data;

    public Queue() {
        currentElement = 0;
        data = new ArrayList<>();
    }

    //add
    public void enQueue(E e) {
        data.add(e);
        currentElement++;
    }

    //check is empty
    public boolean isEmpty() {
        return currentElement == 0;
    }

    //delete
    public E deQueue() {
        if (!isEmpty()) {
            currentElement--;
            var e = data.get(0);
            data.remove(0);
            return e;
        }
        return null;
    }

    // get element first
    public E peek() {
        return isEmpty() ? null : data.get(0);
    }

    //return size queue
    public int size() {
        return currentElement;
    }


}
