package Queue.Lesson4_2;

public class Exercise1 {
    public static void main(String[] args) {
        Queue<Integer> queueNumber = new Queue<>();
        System.out.println(queueNumber.size());
        queueNumber.enQueue(1);
        queueNumber.enQueue(2);
        queueNumber.enQueue(3);
        queueNumber.enQueue(9);
        System.out.println(queueNumber.size());
        System.out.println(queueNumber.peek());

    }
}
