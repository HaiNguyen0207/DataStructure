package LinkedList.Lesson2_5.Exercise3;


import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        SinglyLinkedList<Student> studentsList = new SinglyLinkedList<>();
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
                    System.out.println("===> End of the program <====");
                    break;
                case 1:
                    addNewStudent(studentsList, input);
                    break;
                case 2:
                    System.out.println("Enter student ID want to remove : ");
                    input.nextLine();
                    var id = input.nextLine();
                    var result = studentsList.removeNode(new Student(id));
                    if (result) {
                        System.out.println("Success !");
                    } else {
                        System.out.println("Fail !");
                    }
                    break;
                case 3:
                    System.out.println("Enter name student want to remove : ");
                    input.nextLine();
                    var name = input.nextLine();
                    if (!removeAllByName(studentsList, name)) {
                        System.out.println("Remove Success !");
                    } else {
                        System.out.println("Remove fail ! Please try again !");
                    }
                    break;
                case 4:
                    System.out.println("Enter n = ");
                    input.nextLine();
                    var n = input.nextInt();
                    System.out.println("Enter gpa want to remove : ");
                    var gpa = input.nextFloat();
                    if (!removeNStudentByGpa(studentsList, gpa, n)) {
                        System.out.println("Success !");
                    } else {
                        System.out.println("Fail ! Please try again !");
                    }
                    break;
                case 5:
                    System.out.println("Enter age want to remove : ");
                    input.nextLine();
                    var age = Integer.parseInt(input.nextLine());
                    if (!removeAllByAge(studentsList, age)) {
                        System.out.println("Success !");
                    } else {
                        System.out.println("Fail ! Please try again !");
                    }
                    break;
                case 6:
                    showListStudents(studentsList);
                    break;
                default:
                    System.out.println("===> Function selected invalid ! Please try again <====");
            }
        } while (choice != 0);
    }

    private static boolean removeAllByAge(SinglyLinkedList<Student> studentsList, int age) {
        var isRemove = true;
        while (isRemove) {
            for (var x = studentsList.getHead(); x != null; x = x.getNext()) {
                if (x.getData().getAge() == age) {
                    isRemove = studentsList.removeNode(x.getData());
                }else {
                    isRemove=false;
                }
            }
        }
        return isRemove;
    }

    private static boolean removeNStudentByGpa(SinglyLinkedList<Student> studentsList,
                                               float gpa, int n) {
        var isRemove = false;
        while (n > 0) {
            for (var x = studentsList.getHead(); x != null; x = x.getNext()) {
                if (x.getData().getGpa() == gpa) {
                    isRemove = studentsList.removeNode(x.getData());
                }
            }
            n--;
        }
        return isRemove;
    }

    private static boolean removeAllByName(SinglyLinkedList<Student> studentsList,
                                           String name) {
        var isRemove = true;
        while (isRemove) {
            for (var x = studentsList.getHead(); x != null; x = x.getNext()) {
                if (x.getData().getName(x.getData().getFullName()).equals(name)) {
                    isRemove = studentsList.removeNode(x.getData());
                } else {
                    isRemove = false;
                }
            }
        }
        return isRemove;
    }


    private static void addNewStudent(SinglyLinkedList<Student> studentsList,
                                      Scanner input) {
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
    }

    private static void addStudent(SinglyLinkedList<Student> studentsList) {
        studentsList.insertHead(new Student("AT170145", "Nguyễn Văn Hùng",
                "Hà Nội", "hung@xmail.com", 21, 3.75f));
        studentsList.insertTail(new Student("AT170142", "Nguyễn Văn Hải",
                "Hà Nội", "hai@xmail.com", 20, 3.25f));
        studentsList.insertHead(new Student("AT170143", "Nguyễn Thị Hải",
                "Hà Nội", "hai@xmail.com", 22, 3.25f));
        studentsList.insertHead(new Student("AT170141", "Lê Thị Hồng",
                "Hà Nội", "hong@xmail.com", 19, 2.75f));
        studentsList.insertHead(new Student("AT170149", "Nguyễn Quang Anh ",
                "Hà Nội", "anh@xmail.com", 20, 3.25f));
    }

    public static void showListStudents(SinglyLinkedList<Student> studentsList) {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "ID", "Full Name",
                "Address", "Email", "Age", "Gpa");
        for (var p = studentsList.getHead(); p != null; p = p.getNext()) {
            System.out.printf("%-20s%-20s%-20s%-20s%-20d%-20f\n", p.getData().getId(),
                    p.getData().getFullName(), p.getData().getAddress(),
                    p.getData().getEmail(), p.getData().getAge(), p.getData().getGpa());
        }
    }
}
