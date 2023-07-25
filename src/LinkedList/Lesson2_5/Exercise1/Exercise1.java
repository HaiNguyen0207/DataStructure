package LinkedList.Lesson2_5.Exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        SinglyLinkedList<String> namesLinkedList = new SinglyLinkedList<>();
        namesLinkedList.insertHead("Huong");
        namesLinkedList.insertTail("Hai");
        namesLinkedList.insertHead("Huy");
        namesLinkedList.insertHead("Long");
        namesLinkedList.insertTail("Van");
        namesLinkedList.showNode();
        System.out.println("========> After remove Huy <==========");
        namesLinkedList.removeNode("Huy");
        namesLinkedList.showNode();
    }
}
