package Queue.Lesson4_3;


public class Test {
    public static void main(String[] args) {
        Queue<String> nameQueue = new Queue<>();
        System.out.println(nameQueue.size());
        System.out.println(nameQueue.peek());
        nameQueue.enQueue("Nguyễn Văn Hải");
        nameQueue.enQueue("Nguyễn Văn Hưng");
        nameQueue.enQueue("Nguyễn Văn Hùng");
        nameQueue.enQueue("Nguyễn Văn Minh");
        System.out.println(nameQueue.size());
        System.out.println(nameQueue.peek());
        nameQueue.delQueue();
        nameQueue.delQueue();
        System.out.println(nameQueue.size());
        System.out.println(nameQueue.peek());

    }
}
