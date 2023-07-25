package LinkedList.Lesson2_7.Exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        SinglyLinkedList<String> nameLinkedList = new SinglyLinkedList();
        nameLinkedList.insertHead("Hải");
        nameLinkedList.insertHead("Huy");
        nameLinkedList.insertTail("Hoàng");
        nameLinkedList.insertTail("Ân");
        nameLinkedList.insertHead("Minh");
        nameLinkedList.insertAfter("Hải", "Ánh");
        nameLinkedList.insertAfter("Ân", "Giang");
        nameLinkedList.insertBefore("Hải", "Tuệ");
        nameLinkedList.insertHead("Nam");
        nameLinkedList.insertBefore("Nam", "Phúc");
        nameLinkedList.insertAfter("Giang", "Phương");
        nameLinkedList.showNode();
        System.out.println("After sort : ");
        nameLinkedList.sortList();
        nameLinkedList.showNode();
    }
}
