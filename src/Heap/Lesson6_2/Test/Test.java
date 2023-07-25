package Heap.Lesson6_2.Test;

public class Test {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(Integer.class,8);
        heap.add(1);
        heap.add(3);
        heap.add(8);
        heap.add(5);
        heap.add(2);
        heap.showElement();
        heap.add(10);
        heap.add(7);
        System.out.println();
        heap.showElement();
    }
}
