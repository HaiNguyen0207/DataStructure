package LinkedList.Lesson2_2.Test;


public class Test {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> numberLinkedList =
                new SinglyLinkedList<>();
        System.out.println("===> Inser head <=== ");
        numberLinkedList.insertHead(1);
        numberLinkedList.insertHead(0);
        numberLinkedList.insertHead(9);
        numberLinkedList.insertHead(5);
        numberLinkedList.showNode();
//        System.out.println("===> Insert Tail <=== ");
//        numberLinkedList.insertTail(10);
//        numberLinkedList.insertTail(11);
//        numberLinkedList.insertTail(12);
//        numberLinkedList.showNode();
//        System.out.println("===> Insert After 5 <===");
//        numberLinkedList.insertAfterX(5,6);
//        numberLinkedList.showNode();
//        System.out.println("===> Insert Before 5 <==");
//        numberLinkedList.insertNodeBeforeX(5,4);
//        numberLinkedList.showNode();
    }
}
