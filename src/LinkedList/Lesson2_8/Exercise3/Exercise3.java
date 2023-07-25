package LinkedList.Lesson2_8.Exercise3;


import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        SinglyLinkedList<Student> studentsList = new SinglyLinkedList();
        addStudent(studentsList);
        int choice;
        do {
            System.out.println("=====================> Function <======================");
            System.out.println("= 1. Add new student in to the list                   =");
            System.out.println("= 2. Find and show information student by id          =");
            System.out.println("= 3. Find the number of  students named X             =");
            System.out.println("= 4. Find the number of students by gpa               =");
            System.out.println("= 5. List all students whose cluster name is x        =");
            System.out.println("= 6. Show students list                               =");
            System.out.println("= 0. End of the program                               =");
            System.out.println("=======================================================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("===> End of the program ! " +
                            "Thank you using the service <====");
                    break;
                case 1:
                    addNewStudent(studentsList, input);
                    break;
                case 2:
                    System.out.println("Enter student id want to search : ");
                    input.nextLine();
                    var id = input.nextLine();
                    findStudentById(studentsList, id);
                    break;
                case 3:
                    System.out.println("Enter name want to search : ");
                    input.nextLine();
                    var name = input.nextLine();
                    System.out.println(numberStudentSameName(studentsList, name));
                    break;
                case 4:
                    System.out.println("Enter gpa want to search : ");
                    input.nextLine();
                    var gpa = input.nextFloat();
                    System.out.println(numberStudentAboveGpa(studentsList, gpa));
                    break;
                case 5:
                    System.out.println("Enter words  wanto search : ");
                    input.nextLine();
                    var key = input.nextLine();
                    findStudentByKey(studentsList, key);
                    break;
                case 6:
                    showStudents(studentsList);
                    break;
                default:
                    System.out.println("===> Fuction selected invalid " +
                            "! Please try again <===");
            }

        } while (choice != 0);
    }

    private static void findStudentByKey(SinglyLinkedList<Student> studentsList,
                                         String key) {
        System.out.printf("%-20s%-25s%-20s%-20s%-15s%-15s\n", "ID", "Full Name",
                "Address", "Email", "Age", "Gpa");
        var count = 0;
        for (var x = studentsList.getHead();
             x != null; x = x.getNext()) {
            if (x.getData().getName().matches(".*" + key + ".*")) {
                count++;
                System.out.printf("%-20s%-25s%-20s%-20s%-15d%-15f\n", x.getData().getId(),
                        x.getData().getFullName(), x.getData().getAddress(),
                        x.getData().getEmail(), x.getData().getAge(),
                        x.getData().getGpa());
            }
        }
        if (count == 0) {
            System.out.println("===> There are no students ! <===");
        }
    }

    private static int numberStudentAboveGpa(SinglyLinkedList<Student> studentsList,
                                             float gpa) {
        var count = 0;
        for (var node = studentsList.getHead();
             node != null; node = node.getNext()) {
            if (node.getData().getGpa() >= gpa) {
                count++;
            }
        }
        return count;
    }

    private static int numberStudentSameName(SinglyLinkedList<Student> studentsList,
                                             String name) {
        var count = 0;
        for (var node = studentsList.getHead();
             node != null; node = node.getNext()) {
            if (node.getData().getName().compareToIgnoreCase(name) == 0) {
                count++;
            }
        }
        return count;
    }

    private static void findStudentById(SinglyLinkedList<Student> studentsList, String id) {
        for (var node = studentsList.getHead();
             node != null; node = node.getNext()) {
            if (node.getData().getId().equals(id)) {
                var x = studentsList.findNode(node.getData());
                if (x != null) {
                    System.out.printf("%-20s%-25s%-20s%-20s%-15s%-15s\n", "ID", "Full Name",
                            "Address", "Email", "Age", "Gpa");
                    System.out.printf("%-20s%-25s%-20s%-20s%-15d%-15f\n", x.getData().getId(),
                            x.getData().getFullName(), x.getData().getAddress(),
                            x.getData().getEmail(), x.getData().getAge(),
                            x.getData().getGpa());
                } else {
                    System.out.println("null ");
                }
            }
        }
    }

    private static void showStudents(SinglyLinkedList<Student> studentsList) {
        System.out.printf("%-20s%-25s%-20s%-20s%-15s%-15s\n", "ID", "Full Name",
                "Address", "Email", "Age", "Gpa");
        for (var x = studentsList.getHead(); x != null; x = x.getNext()) {
            System.out.printf("%-20s%-25s%-20s%-20s%-15d%-15f\n", x.getData().getId(),
                    x.getData().getFullName(), x.getData().getAddress(), x.getData().getEmail(),
                    x.getData().getAge(), x.getData().getGpa());
        }
    }

    private static void addNewStudent(SinglyLinkedList studentsList,
                                      Scanner input) {
        System.out.println("Enter ID : ");
        input.nextLine();
        var id = input.nextLine();
        System.out.println("Enter full name");
        var name = input.nextLine();
        System.out.println("Enter adrress : ");
        var adrress = input.nextLine();
        System.out.println("Enter email : ");
        var email = input.nextLine();
        System.out.println("Enter age : ");
        var age = Integer.parseInt(input.nextLine());
        System.out.println("Enter gpa  : ");
        var gpa = input.nextFloat();
        //default add tail
        studentsList.insertTail(new Student(id, name, adrress, email, age, gpa));
        System.out.println("Add new student success !");
    }

    private static void addStudent(SinglyLinkedList studentsList) {
        studentsList.insertHead(new Student("AT170415",
                "Nguyen Van Hai", "Ha Noi", "hai@xmail.com", 20, 2.75f));
        studentsList.insertTail(new Student("AT170425",
                "Nguyen Van Hung", "Ha Giang", "hung@xmail.com", 22, 3.0f));
        studentsList.insertTail(new Student("AT170417",
                "Trinh Thi Hoa", "Thanh Hoa", "hoa@xmail.com", 19, 2.25f));
        studentsList.insertTail(new Student("AT170435",
                "Nguyen Cong Minh", "Ha Noi", "minh@xmail.com", 20, 2.95f));
        studentsList.insertHead(new Student("AT170446",
                "Le Thi Hong", "Hung Yen", "hong@xmail.com", 21, 2.25f));
        studentsList.insertHead(new Student("AT170409",
                "Nguyen Tat Duy",
                "Lao Cai", "duy@xmail.com", 21, 3.15f));
        studentsList.insertTail(new Student("AT170411",
                "Nguyen Truong Giang", "Yen Bai", "giang@xmail.com", 20, 3.05f));
        studentsList.insertHead(new Student("AT170437", "Tran Thanh Hai ", "Son La",
                "nhan@xmail.com", 24, 3.15f));
    }
}
