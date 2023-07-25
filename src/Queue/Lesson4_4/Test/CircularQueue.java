package Queue.Lesson4_4.Test;


import java.util.ArrayList;

public class CircularQueue<E> {
    private int headIndex;
    private int tailIndex;
    private int currentElement;
    private int capacity;
    private ArrayList<E> data;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        headIndex = -1;
        tailIndex = -1;
        currentElement = 0;
        data = new ArrayList<>(capacity);
    }

    //enqueue
    public boolean enQueue(E e) {
        if (isFull()) {
            System.out.println("Queue Full !");
            return false;
        } else {
            currentElement++;
            if (headIndex == -1) {
                headIndex++;
            }
            tailIndex = (tailIndex + 1) % capacity;
            if (data.size() == capacity) {
                data.add(tailIndex, e);
            } else {
                data.add(e);
            }
            return true;
        }

    }

    //check is full ?
    private boolean isFull() {
        return currentElement == capacity;
    }

    //delQueue
    public boolean delQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty !");
            return false;
        } else {
            currentElement--;
            if (headIndex == tailIndex) {
                headIndex = tailIndex = -1;
            } else {
                headIndex = (headIndex + 1) % capacity;
            }
            return true;
        }
    }

    private boolean isEmpty() {
        return currentElement == 0;
    }
    //show queue
    public void display() {
        if(isEmpty()) {
            System.out.println("Queue is empty !");
        }else {
            System.out.println("Queue first : "+data.get(headIndex));
            System.out.println("Queue order : ");
            for (int i = headIndex; i != tailIndex ; i = (i+1) %capacity) {
                System.out.print(data.get(i) +" ");
            }
            System.out.println(data.get(tailIndex));
            System.out.println("Queue tail : "+data.get(tailIndex));
        }
    }
    public E peek() {
        return isEmpty() ? null : data.get(headIndex);
    }
}
