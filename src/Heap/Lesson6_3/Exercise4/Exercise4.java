package Heap.Lesson6_3.Exercise4;

import java.lang.management.ThreadInfo;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Heap<Student> studentHeap = new Heap<Student>(Student.class, 256);
        var input = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("==================> Menu <========================");
            System.out.println("= 1. Thêm một node mới vào Heap                  =");
            System.out.println("= 2. Hiển thị các node                           =");
            System.out.println("= 3. Tìm kiếm xem Node có tồn tại không          =");
            System.out.println("= 4. Xóa một node                                =");
            System.out.println("= 5. Cho biết node lớn nhất trong heap hiện thời =");
            System.out.println("= 6. Cho biết kích cỡ hiện thời của Heap         =");
            System.out.println("= 0. Thoát chương trình                          =");
            System.out.println("==================================================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("==> Chương trình kết thúc <===");
                    break;
                case 1:
                    addNodeIntoHeap(studentHeap, input);
                    break;
                case 2:
                    showElement(studentHeap);
                    break;
                case 3:
                    seachNode(studentHeap, input);
                    break;
                case 4:
                    removeNode(studentHeap, input);
                    break;
                case 5:
                    System.out.println("==> Node lớn  nhất trong Heap hiện thời : " +
                            studentHeap.getNodeMax());
                    break;
                case 6:
                    System.out.println("==> Kích cỡ hiện thời của Heap : " +
                            studentHeap.getCurrentSize());

                    break;
                default:
                    System.out.println("==> Sai chức năng ! Vui lòng thử lại <===");
                    break;
            }
        } while (choice != 0);
    }

    private static void removeNode(Heap<Student> studentHeap, Scanner input) {
        System.out.println("Nhập mã sinh viên cần xóa: ");
        input.nextLine();
        var id = input.nextLine();
        if (studentHeap.remove(new Student(id))) {
            System.out.println("==> Xóa sinh viên ID : " + id + " thành công <===");
        } else {
            System.out.println("===> Thông tin không hợp lệ ! Vui lòng xem lại <===");
        }
    }

    private static void seachNode(Heap<Student> studentHeap, Scanner input) {
        System.out.println("Nhập mã sinh viên cần tìm : ");
        input.nextLine();
        var id = input.nextLine();
        if (studentHeap.findNode(new Student(id)) != -1) {
            System.out.println("===> Đã tìm thấy sinh viên hợp lệ <===");
            studentHeap.showDetail(studentHeap.findNode(new Student(id)));
        } else {
            System.out.println("===> Không tìm thấy sinh viên nào hợp lệ <===");
        }
    }

    private static void showElement(Heap<Student> studentHeap) {
        studentHeap.showElement();
    }

    private static void addNodeIntoHeap(Heap<Student> studentHeap, Scanner input) {
        System.out.println("Nhập mã sinh viên : ");
        input.nextLine();
        var id = input.nextLine();
        System.out.println("Nhập họ tên :");
        var name = input.nextLine();
        System.out.println("Nhập gpa : ");
        var gpa = Float.parseFloat(input.nextLine());
        if (studentHeap.add(new Student(id, name, gpa))) {
            System.out.println("===> Thêm mới sinh viên vô Heap thành công <==");
        } else {
            System.out.println("===> Thêm mới sinh viên vô Heap thất bại <==");
        }
    }
}
