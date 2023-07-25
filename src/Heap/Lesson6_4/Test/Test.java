package Heap.Lesson6_4.Test;

public class Test {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(Integer.class, 256);
        heap.add(1);
        heap.add(9);
        heap.add(19);
        heap.add(20);
        heap.add(2);
        heap.add(36);
        heap.add(8);
        heap.showElement();
        System.out.println();
        heap.remove(36);
        heap.showElement();
        heap.add(99);
        System.out.println();
        heap.showElement();
        heap.update(9,150);
        System.out.println();
        heap.showElement();
    }
}
