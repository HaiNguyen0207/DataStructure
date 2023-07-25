package Heap.Lesson6_3.Test;

public class Test {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(Integer.class ,10);
        heap.add(10);
        heap.add(2);
        heap.add(20);
        heap.add(30);
        heap.add(100);
        heap.add(70);
        heap.add(50);
        heap.add(22);
        heap.showElement();
        System.out.println("\n================");
        heap.remove(100);
        heap.showElement();
    }
}
