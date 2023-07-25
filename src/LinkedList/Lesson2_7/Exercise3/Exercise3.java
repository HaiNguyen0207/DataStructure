package LinkedList.Lesson2_7.Exercise3;

import LinkedList.Lesson2_7.Exercise3.Sort.*;


import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        SinglyLinkedList studentsList = new SinglyLinkedList();
        addStudent(studentsList);
        int choice;
        do {
            System.out.println("=================> Functions <====================");
            System.out.println("= 1. Add new student in  to list                 =");
            System.out.println("= 2. Sort students list by id ascending          =");
            System.out.println("= 3. Sort students list by name ascending        =");
            System.out.println("= 4. Sort students list by age ascending         =");
            System.out.println("= 5. Sort students list by gpa ascending         =");
            System.out.println("= 6. Sort students list by gpa decrease          =");
            System.out.println("= 7. Show students list                          =");
            System.out.println("= 8. End of the program                          =");
            System.out.println("==================================================");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    addNewStudent(studentsList, input);
                    break;
                case 2:
                    studentsList.sortList(new SortStudentByIdAsc());
                    System.out.println("Sorted successful !");
                    break;
                case 3:
                    studentsList.sortList(new SortStudentByNameAsc());
                    System.out.println("Sorted successful !");
                    break;
                case 4:
                    studentsList.sortList(new SortStudentByAgeAsc());
                    System.out.println("Sorted successful !");
                    break;
                case 5:
                    studentsList.sortList(new SortStudentByGpaAsc());
                    System.out.println("Sorted successful !");
                    break;
                case 6:
                    studentsList.sortList(new SortStudentByGpaDec());
                    System.out.println("Sorted successful !");
                    break;
                case 7:
                    showListStudents(studentsList);
                    break;
                case 8:
                    System.out.println("==> End of the program ! " +
                            "Thank you for using the service <===");
                    break;
                default:
                    System.out.println("===> Fuction selected invalid ! Please try again <====");
                    break;
            }
        } while (choice != 8);
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

    private static void showListStudents(SinglyLinkedList<Student> studentsList) {
        System.out.printf("%-15s%-25s%-20s%-20s%-10s%-10s\n", "ID", "Họ Tên",
                "Địa Chỉ", "Email", "Tuổi", "Gpa");
        for (var x = studentsList.getHead(); x != null; x = x.getNext()) {
            System.out.printf("%-15s%-25s%-20s%-20s%-10d%-10f\n", x.getData().getId(),
                    x.getData().getFullName(), x.getData().getAddress(),
                    x.getData().getEmail(), x.getData().getAge(), x.getData().getGpa());
        }
    }

    private static void addStudent(SinglyLinkedList studentsList) {
        studentsList.insertHead(new Student("AT170415", "Nguyen Van Hai",
                "Ha Noi", "hai@xmail.com", 20, 3.15f));
        studentsList.insertTail(new Student("AT170425", "Nguyen Van Hung",
                "Ha Giang", "hung@xmail.com", 22, 3.25f));
        studentsList.insertTail(new Student("AT170417", "Trinh Thi Hoa",
                "Thanh Hoa", "hoa@xmail.com", 19, 3.15f));
        studentsList.insertTail(new Student("AT170435", "Nguyen Cong Minh",
                "Ha Noi", "minh@xmail.com", 20, 3.15f));
        studentsList.insertHead(new Student("AT170446", "Le Thi Hong",
                "Hung Yen", "hong@xmail.com", 21, 3.25f));
        studentsList.insertHead(new Student("AT170409", "Nguyen Tat Duy",
                "Lao Cai", "duy@xmail.com", 21, 3.15f));
        studentsList.insertTail(new Student("AT170411", "Nguyen Truong Giang",
                "Yen Bai", "giang@xmail.com", 20, 3.15f));
        studentsList.insertHead(new Student("AT170437", "Tran Thanh Hai ",
                "Son La", "nhan@xmail.com", 24, 3.15f));
    }
}
