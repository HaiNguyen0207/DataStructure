package LinkedList.Lesson2_6.Exercise3;


import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        DoublyLinkedList<Student> studentsList = new DoublyLinkedList();
        addStudent(studentsList);
        int choice;
        do {
            System.out.println("==============> Functions <===============");
            System.out.println("= 1. Add student in to the list          =");
            System.out.println("= 2. Remove student by ID                =");
            System.out.println("= 3. Remove all student by name          =");
            System.out.println("= 4. Remove maximum n student by gpa     =");
            System.out.println("= 5. Remove student by age               =");
            System.out.println("= 6. Show students                       =");
            System.out.println("= 0. End of the program                  =");
            System.out.println("==========================================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("=====> End of the program ! <=====");
                    break;
                case 1:
                    addNewStudent(studentsList, input);
                    break;
                case 2:
                    System.out.println("Enter ID want to remove  : ");
                    input.nextLine();
                    var id = input.nextLine();
                    if (studentsList.removeNode(new Student(id))) {
                        System.out.println("Success !");
                    } else {
                        System.out.println("Fail ! Please try again ! ");
                    }
                    break;
                case 3:
                    System.out.println("Enter name want to remove : ");
                    input.nextLine();
                    var name = input.nextLine();
                    if (!removeStudentByName(studentsList, name)) {
                        System.out.println("Remove Success !");
                    } else {
                        System.out.println("Remove Fail !");
                    }
                    break;
                case 4:
                    System.out.println("Enter maximum n : ");
                    var n = input.nextInt();
                    System.out.println("Enter number gpa wanto remove : ");
                    var gpa = input.nextFloat();
                    if (removeStudentByGpa(studentsList, n, gpa)) {
                        System.out.println("Remove Success !");
                    } else {
                        System.out.println("Fail ! Please try again ! ");
                    }
                    break;
                case 5:
                    System.out.println("Enter number age want to remove : ");
                    input.nextLine();
                    var age = input.nextInt();
                    if (!removeStudentByAge(studentsList, age)) {
                        System.out.println("Remove Success !");
                    } else {
                        System.out.println("Fail ! Please try again ! ");
                    }
                    break;
                case 6:
                    studentsList.showNodeHeadToTail();
                    System.out.println("=================");
                    studentsList.showNodeTailTHead();
                    System.out.println();
                    break;
                default:
                    System.out.println("===> Function selected invalid ! Please try again <===");
                    break;
            }
        } while (choice != 0);
    }

    private static boolean removeStudentByAge(DoublyLinkedList<Student> studentsList,
                                              int age) {
        boolean result = true;
        while (result) {
            for (var x = studentsList.getHead();
                 x != null; x = x.getNext()) {
                if (x.getData().getAge() == age) {
                    result = studentsList.removeNode(x.getData());
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

    private static boolean removeStudentByGpa(DoublyLinkedList<Student> studentsList,
                                              int n, float gpa) {
        var result = true;
        while (n < 0) {
            for (var x = studentsList.getHead();
                 x != null; x = x.getNext()) {
                if (x.getData().getGpa() == gpa) {
                    result = studentsList.removeNode(x.getData());
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

    private static boolean removeStudentByName(DoublyLinkedList<Student> studentsList,
                                               String name) {
        boolean result = true;
        while (result) {
            for (var x = studentsList.getHead();
                 x != null; x = x.getNext()) {
                if (x.getData().getName(x.getData().getFullName()).equals(name)) {
                    result = studentsList.removeNode(x.getData());
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

    private static void addNewStudent(DoublyLinkedList studentsList, Scanner input) {
        System.out.println("Enter ID : ");
        input.nextLine();
        var id = input.nextLine();
        System.out.println("Enter full name : ");
        var name = input.nextLine();
        System.out.println("Enter address : ");
        var address = input.nextLine();
        System.out.println("Enter email : ");
        var email = input.nextLine();
        System.out.println("Enter age : ");
        var age = Integer.parseInt(input.nextLine());
        System.out.println("Enter gpa : ");
        var gpa = Float.parseFloat(input.nextLine());
        studentsList.insertTail(new Student(id, name, address, email, age, gpa));
        System.out.println("Add new student success !");
    }

    private static void addStudent(DoublyLinkedList studentsList) {
        studentsList.insertHead(new Student("AT170145", "Nguyễn Văn Hùng",
                "Hà Nội", "hung@xmail.com", 21, 3.75f));
        studentsList.insertTail(new Student("AT170142", "Nguyễn Văn Hải",
                "Hà Nội", "hai@xmail.com", 20, 3.25f));
        studentsList.insertHead(new Student("AT170143", "Nguyễn Thị Hải",
                "Hà Nội", "hai@xmail.com", 20, 3.25f));
        studentsList.insertHead(new Student("AT170141", "Lê Thị Hồng",
                "Hà Nội", "hong@xmail.com", 20, 2.75f));
        studentsList.insertHead(new Student("AT170149", "Nguyễn Quang Hải ",
                "Hà Nội", "anh@xmail.com", 20, 3.25f));
    }
}
