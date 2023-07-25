package Queue.Lesson4_4.Test;

public class Test {
    public static void main(String[] args) {
        CircularQueue<Integer>  queue = new CircularQueue<>(5);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(1);
        queue.display();
        queue.enQueue(6);
        queue.enQueue(7);
        queue.display();
        queue.delQueue();
        System.out.println("Queue first : "+queue.peek());
        queue.display();
    }
}
