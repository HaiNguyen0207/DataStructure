package LinkedList.Lesson2_8.Exercise2;


public class Exercise2 {
    public static void main(String[] args) {
        SinglyLinkedList namesList = new SinglyLinkedList();
        namesList.insertHead("Huong");
        namesList.insertHead("Huy");
        namesList.insertTail("Hai");
        namesList.insertHead("Minh");
        namesList.insertTail("Anh");
        namesList.insertAfter("Anh", "Anh");
        namesList.insertBefore("Minh", "Anh");
        namesList.showNode();
        namesList.sortList();
        namesList.showNode();
        System.out.println(namesList.findNode("Anh"));
    }
}
