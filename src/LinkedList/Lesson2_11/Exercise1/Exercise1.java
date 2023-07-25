package LinkedList.Lesson2_11.Exercise1;

import LinkedList.Lesson2_11.Exercise1.Sort.SortStudenByGpaDec;
import LinkedList.Lesson2_11.Exercise1.Sort.SortStudentsByAgeAsc;
import LinkedList.Lesson2_11.Exercise1.Sort.SortStudentsByIdAsc;
import LinkedList.Lesson2_11.Exercise1.Sort.SortStudentsByNameAsc;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Exercise1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        Vector<Student> students = new Vector<>();
        addStudent(students);
        int choice;
        do {
            System.out.println("===================> Functions <====================");
            System.out.println("= 1. Add a new student                             =");
            System.out.println("= 2. Find student by ID                            =");
            System.out.println("= 3. Update GPA by ID                              =");
            System.out.println("= 4. Remove student by ID                          =");
            System.out.println("= 5. Sort student list                             =");
            System.out.println("= 6. Find student by GPA [ 0.0 - 4.0 ]             =");
            System.out.println("= 7. List all students whose name has the phrase x =");
            System.out.println("= 8. Show student list                             =");
            System.out.println("= 9. End of the program                            =");
            System.out.println("====================================================");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    addNewStudent(students, input);
                    break;
                case 2:
                    System.out.printf("Enter ID student wanto search : ");
                    input.nextLine();
                    var id = input.nextLine();
                    var student = findStudentById(students, id);
                    if (student != null) {
                        System.out.println(" Had found ID :  " + id + " !" +
                                " Information is displayed below the table : ");
                        System.out.println();
                        showStudent(student);
                    } else {
                        System.out.println("====> No find ID " + id + " ! Please try again <===");
                    }
                    break;
                case 3:
                    System.out.println("Enter student ID wanto update GPA : ");
                    input.nextLine();
                    var stuID = input.nextLine();
                    if (findStudentById(students, stuID) != null) {
                        System.out.println("Enter new GPA : ");
                        findStudentById(students, stuID).setGpa(input.nextFloat());
                        System.out.println("===> Update GPA of the ID :" +
                                " " + stuID + " successful <===");
                    } else {
                        System.out.println("===> Update GPA of the ID :" +
                                stuID + " fail <===");
                    }
                    break;
                case 4:
                    System.out.println("Enter student ID wanto remove : ");
                    input.nextLine();
                    var idRemove = input.nextLine();
                    if (findStudentById(students, idRemove) != null) {
                        students.remove(findStudentById(students, idRemove));
                        System.out.println("==> Remove ID : " + idRemove + " successful <===");
                    } else {
                        System.out.println("==> Remove ID : " + idRemove + " fail <===");
                    }
                    break;
                case 5:
                    System.out.println(" 1 . Sort list by student ID ascending ");
                    System.out.println(" 2.  Sort list by first name A-Z  ");
                    System.out.println(" 3.  Sort list by age ascending      ");
                    System.out.println(" 4.  Sort list by gpa decrease");
                    int option = input.nextInt();
                    var studentsSort = coppyStudents(students);
                    sortListStudent(studentsSort, option);
                    break;
                case 6:
                    System.out.println("Enter gpa wanto search : ");
                    var gpa = input.nextFloat();
                    var result = findStudentByGpa(students, gpa);
                    if (result.size() > 0) {
                        System.out.println("=== > List find <====");
                        showStudents(result);
                    } else {
                        System.out.println("===> List find is empty <===");
                    }
                    break;
                case 7:
                    if (!students.isEmpty()) {
                        boolean isExist = false;
                        System.out.println("Enter regex : ");
                        input.nextLine();
                        String regex = input.nextLine();
                        System.out.printf("%-20s%-25s%-20s%-20s%-15s%-15s\n", "StuentID",
                                "FullName", "Address", "Email", "Age", "Gpa");
                        for (var e : students) {
                            if (e.getName(e.getFullName()).toLowerCase().
                                    matches(".*" + regex.toLowerCase() + ".*")) {
                                showE(e);
                                isExist = true;
                            }
                        }
                        if (!isExist) {
                            System.out.println("===> NULL <===");
                        }
                    } else {
                        System.out.println("===> List student is empty <====");
                    }
                    break;
                case 8:
                    showStudents(students);
                    break;
                case 9:
                    System.out.println("==> End program ! Thank you for using the sevice  <===");
                    break;
                default:
                    System.out.println("===> Function selected invalid ! Please try again <====");
                    break;
            }
        } while (choice != 9);
    }

    private static void showE(Student e) {
        System.out.printf("%-20s%-25s%-20s%-20s%-15d%-15.2f\n", e.getId(),
                e.getFullName(), e.getAddress(), e.getEmail(), e.getAge(), e.getGpa());
    }

    private static Vector<Student> findStudentByGpa(Vector<Student> students, float gpa) {
        Vector<Student> result = new Vector<>();
        for (var e : students) {
            if (e.getGpa() >= gpa) {
                result.add(e);
            }
        }
        return result;
    }

    private static Vector<Student> coppyStudents(Vector<Student> students) {
        Vector<Student> s = new Vector<>();
        for (var e : students) {
            s.add(e);
        }
        return s;
    }

    private static void sortListStudent(Vector<Student> studentsSort,
                                        int option) {
        if (option == 1) {
            Collections.sort(studentsSort, new SortStudentsByIdAsc());
            showStudents(studentsSort);
        } else if (option == 2) {
            Collections.sort(studentsSort, new SortStudentsByNameAsc());
            showStudents(studentsSort);
        } else if (option == 3) {
            Collections.sort(studentsSort, new SortStudentsByAgeAsc());
            showStudents(studentsSort);
        } else if (option == 4) {
            Collections.sort(studentsSort, new SortStudenByGpaDec());
            showStudents(studentsSort);
        } else {
            System.out.println("==> Function selected invalid ! <======");
        }
    }

    private static Student findStudentById(Vector<Student> students, String id) {
        for (var e : students) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    private static void addNewStudent(Vector<Student> students,
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
        students.add(new Student(id, name, adrress, email, age, gpa));
        System.out.println("Add new student success !");
    }

    private static void addStudent(Vector<Student> students) {
        students.add(new Student("AT170415",
                "Nguyen Van Hai", "Ha Noi", "hai@xmail.com", 20, 2.75f));
        students.add(new Student("AT170425",
                "Nguyen Van Hung", "Ha Giang", "hung@xmail.com", 22, 3.0f));
        students.add(new Student("AT170417",
                "Trinh Thi Hoa", "Thanh Hoa", "hoa@xmail.com", 19, 2.25f));
        students.add(new Student("AT170435",
                "Nguyen Cong Minh", "Ha Noi", "minh@xmail.com", 20, 2.95f));
        students.add(new Student("AT170446",
                "Le Thi Hong", "Hung Yen", "hong@xmail.com", 21, 2.25f));
        students.add(new Student("AT170409",
                "Nguyen Tat Duy",
                "Lao Cai", "duy@xmail.com", 21, 3.15f));
        students.add(new Student("AT170411",
                "Nguyen Truong Giang", "Yen Bai", "giang@xmail.com", 20, 3.05f));
        students.add(new Student("AT170437", "Tran Thanh Hai ", "Quang Binh",
                "hai@xmail.com", 22, 3.15f));
        students.add(new Student("AT170438", "An Quang Hai ", "Son La",
                "hai@xmail.com", 21, 3.15f));
        students.add(new Student("AT170421", "Tran Thanh Hoang ", "Cao Bang",
                "hai@xmail.com", 20, 3.15f));
        students.add(new Student("AT170411", "Nguyen Thanh Hai ", "Lang Son",
                "hai@xmail.com", 21, 3.15f));
        students.add(new Student("AT170422", "Vu Thanh Hai ", "Ha Noi",
                "hai@xmail.com", 20, 3.15f));
    }

    private static void showStudents(Vector<Student> students) {
        System.out.printf("%-20s%-25s%-20s%-20s%-15s%-15s\n", "StuentID",
                "FullName", "Address", "Email", "Age", "Gpa");
        for (var e : students) {
            System.out.printf("%-20s%-25s%-20s%-20s%-15d%-15.2f\n", e.getId(),
                    e.getFullName(), e.getAddress(), e.getEmail(), e.getAge(), e.getGpa());
        }
    }

    private static void showStudent(Student e) {
        System.out.printf("%-20s%-25s%-20s%-20s%-15s%-15s\n", "StuentID",
                "FullName", "Address", "Email", "Age", "Gpa");
        System.out.printf("%-20s%-25s%-20s%-20s%-15d%-15.2f\n", e.getId(),
                e.getFullName(), e.getAddress(), e.getEmail(), e.getAge(), e.getGpa());
    }
}
