package LinkedList.Lesson2_6.Exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        DoublyLinkedList numberLinkedList = new DoublyLinkedList();
        numberLinkedList.insertHead(1);
        numberLinkedList.insertTail(2);
        numberLinkedList.insertHead(3);
        numberLinkedList.insertTail(4);
        numberLinkedList.insertHead(5);
        numberLinkedList.showNodeHeadToTail();
        numberLinkedList.showNodeTailToHead();
        System.out.println("===> After remove 4 <===");
        numberLinkedList.removeNode(4);
        numberLinkedList.showNodeHeadToTail();
        numberLinkedList.showNodeTailToHead();
    }
}
