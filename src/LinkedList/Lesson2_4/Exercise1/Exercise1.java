package LinkedList.Lesson2_4.Exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        SinglyLinkedList numbersLinkedList = new SinglyLinkedList();
        numbersLinkedList.insertHead(1);
        numbersLinkedList.insertTail(9);
        numbersLinkedList.insertTail(10);
        numbersLinkedList.insertHead(11);
        numbersLinkedList.showNode();
        System.out.println("List after update 1 -> 2 : ");
        numbersLinkedList.updateNode(1, 2);
        numbersLinkedList.showNode();
    }
}