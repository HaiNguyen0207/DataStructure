package LinkedList.Lesson2_5.Exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        SinglyLinkedList numberLinkedList = new SinglyLinkedList();
        numberLinkedList.insertHead(1);
        numberLinkedList.insertHead(2);
        numberLinkedList.insertTail(2);
        numberLinkedList.insertHead(5);
        numberLinkedList.insertTail(3);
        numberLinkedList.insertHead(2);
        numberLinkedList.insertTail(2);
        numberLinkedList.showNode();
        var count = 0;
        var result = numberLinkedList.removeAllNode(2);
        while (result) {
            count++;
            result = numberLinkedList.removeAllNode(2);
        }
        System.out.println(count);
        numberLinkedList.showNode();
    }
}
