package LinkedList.Lesson2_4.Exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        SinLyLinkedList namesLinkedList = new SinLyLinkedList();
        namesLinkedList.insertHead("Huong");
        namesLinkedList.insertTail("Hai");
        namesLinkedList.insertHead("Quang");
        namesLinkedList.insertTail("Hoang");
        namesLinkedList.insertHead("Minh");
        namesLinkedList.showNode();
        System.out.println("Update node data Huong -> Huy : ");
        if (namesLinkedList.updateNodeData("Huong", "Ly")) {
            namesLinkedList.showNode();
        } else {
            System.out.println("Fail !");
        }
    }
}
