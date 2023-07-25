package Heap.Lesson6_5.Test;

public class Test {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(256);
        priorityQueue.add(2, 3);
        priorityQueue.add(5, 9);
        priorityQueue.showElement();
        priorityQueue.add(4, 6);
        priorityQueue.add(1, 7);
        priorityQueue.add(9, 2);
        System.out.println();
        priorityQueue.showElement();
        System.out.println("\nPop : ");
        var nodePop = priorityQueue.pop();
        if (nodePop != null) {
            System.out.println(nodePop);
        } else {
            System.out.println("==> Hàng đợi ưu tiên rỗng <===");
        }
        priorityQueue.showElement();
        priorityQueue.add(0,10);
        System.out.println();
        priorityQueue.showElement();
        priorityQueue.pop();
        System.out.println();
        priorityQueue.showElement();
        priorityQueue.pop();
        System.out.println();
        priorityQueue.showElement();
        System.out.println("\nPeek : ");
        System.out.println(priorityQueue.peek());
        System.out.println("Kich thước hiện tại : "+priorityQueue.getCurrentSize());
    }
}
