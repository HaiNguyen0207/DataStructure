package LinkedList.Lesson2_7.Exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> numberLinkedList = new DoublyLinkedList();
        numberLinkedList.insertHead(1);
        numberLinkedList.insertHead(2);
        numberLinkedList.insertTail(3);
        numberLinkedList.insertHead(4);
        numberLinkedList.insertTail(5);
        numberLinkedList.insertBefore(1, 6);
        numberLinkedList.insertBefore(4, 9);
        numberLinkedList.insertAfrer(6, 7);
        numberLinkedList.insertAfrer(5, 10);
        numberLinkedList.removeNode(9);
        numberLinkedList.removeNode(4);
        numberLinkedList.showNodeHeadToTail();
        numberLinkedList.showNodeTailToHead();
        System.out.println("After sort : ");
        numberLinkedList.sortList();
        numberLinkedList.showNodeHeadToTail();
        numberLinkedList.showNodeTailToHead();
    }
}
