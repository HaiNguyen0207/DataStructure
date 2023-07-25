package LinkedList.Lesson2_6.Exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        DoublyLinkedList numberLinkedList = new DoublyLinkedList();
        numberLinkedList.insertHead(1);
        numberLinkedList.insertHead(2);
        numberLinkedList.insertTail(1);
        numberLinkedList.insertTail(4);
        numberLinkedList.insertHead(1);
        numberLinkedList.insertTail(6);
        numberLinkedList.showNodeHeadToTail();
        numberLinkedList.showNodeTailToHead();
        System.out.println("After remove 5 : ");
        var reslut = numberLinkedList.removeNode(1);
        while (reslut) {
            reslut = numberLinkedList.removeNode(1);
        }
        numberLinkedList.showNodeHeadToTail();
        numberLinkedList.showNodeTailToHead();

    }
}
