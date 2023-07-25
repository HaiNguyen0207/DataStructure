package LinkedList.Lesson2_8.Exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        SinglyLinkedList numberList = new SinglyLinkedList();
        numberList.insertHead(1);
        numberList.insertHead(2);
        numberList.insertTail(3);
        numberList.insertHead(4);
        numberList.insertTail(5);
        numberList.insertAfter(2, 6);
        numberList.insertBefore(5, 7);
        numberList.showNode();
        numberList.sortList();
        numberList.showNode();
        System.out.println(numberList.findNode(8));
    }
}
