package LinkedList.Lesson2_4.Exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        DoublyLinkedList studentsLinkedList = new DoublyLinkedList();
        Student hai = new Student("AT170415", "Nguyễn Văn Hải",
                "Hà Nội", 20, 3.75f);
        studentsLinkedList.insertHead(hai);
        studentsLinkedList.insertTail(new Student("AT170411", "Nguyễn Văn An",
                "Hà Nội", 21, 2.75f));
        studentsLinkedList.insertTail(new Student("AT170414", "Nguyễn Trường Giang",
                "Hưng Yên", 20, 3.25f));
        studentsLinkedList.insertHead(new Student("AT170445", "Chu Thị Quỳnh",
                "Hà Giang", 22, 3.5f));
        studentsLinkedList.insertHead(new Student("AT170416", "Đinh Văn Công",
                "Lạng Sơn", 20, 3.66f));
        studentsLinkedList.showNode();
        System.out.println("Update ID AT170415  gpa 3.75 -> 3.5 ");
        hai.setGpa(3.5f);
        System.out.println();
        studentsLinkedList.updateNodeData(new Student("AT170415"), hai);
        studentsLinkedList.showNode();
    }
}
