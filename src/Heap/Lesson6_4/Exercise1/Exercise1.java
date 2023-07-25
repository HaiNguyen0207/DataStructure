package Heap.Lesson6_4.Exercise1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Heap<Student> studentHeap = new Heap<>(Student.class, 256);
        var input = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("==================> Menu <========================");
            System.out.println("= 1. Thêm một node mới vào Heap                  =");
            System.out.println("= 2. Hiển thị các node                           =");
            System.out.println("= 3. Tìm kiếm xem Node có tồn tại không          =");
            System.out.println("= 4. Cập nhật Node có giá trị X                  =");
            System.out.println("= 5. Xóa một node                                =");
            System.out.println("= 6. Cho biết node lớn nhất trong heap hiện thời =");
            System.out.println("= 7. Cho biết kích cỡ hiện thời của Heap         =");
            System.out.println("= 0. Thoát chương trình                          =");
            System.out.println("==================================================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("==> Chương trình đã kết thúc <====");
                    break;
                case 1:
                    addNodeIntoHeap(studentHeap, input);
                    break;
                case 2:
                    showNode(studentHeap);
                    break;
                case 3:
                    findNode(studentHeap, input);
                    break;
                case 4:
                    update(studentHeap, input);
                    break;
                case 5:
                    removeNode(studentHeap, input);
                    break;
                case 6:
                    getNodeMax(studentHeap);
                    break;
                case 7:
                    getCurrentSize(studentHeap);
                    break;
                default:
                    System.out.println("==> Sai chức năng ! Vui lòng nhập lại <===");
                    break;
            }
        } while (choice != 0);
    }

    private static void getCurrentSize(Heap<Student> studentHeap) {
        System.out.println("===> Kích thước hiện thời của Heap là : " + studentHeap.getCurrentSize());
    }

    private static void getNodeMax(Heap<Student> studentHeap) {
        System.out.println("Giá trị lớn nhất hiện thời của Heal là : \n " + studentHeap.getMax());
    }

    private static void removeNode(Heap<Student> studentHeap, Scanner input) {
        System.out.println("Nhập mã sinh viên cần xóa : ");
        input.nextLine();
        var id = input.nextLine();
        if (studentHeap.remove(new Student(id))) {
            System.out.println("==> Xóa ID : " + id + " thành công <===");
        } else {
            System.out.println("==> Thông tin cần xóa không hợp lệ <===");
        }
    }

    private static void update(Heap<Student> studentHeap, Scanner input) {
        System.out.println("Nhập mã sinh viên cần sửa đổi : ");
        input.nextLine();
        var id = input.nextLine();
        if (studentHeap.findNode(new Student(id)) != -1) {
            System.out.println("Nhập dữ liệu mã sinh viên mới : ");
            var newId = input.nextLine();
            System.out.println("Nhập dữ liệu họ tên mới : ");
            var name = input.nextLine();
            System.out.println("Nhập dữ liệu gpa mới : ");
            var gpa = Float.parseFloat(input.nextLine());
            if (studentHeap.update(new Student(id), new Student(newId, name, gpa))) {
                System.out.println("==> Cập nhật dữ liệu thông công <===");
            } else {
                System.out.println("===> Cập nhật dữ liệu thất bại <===");
            }
        } else {
            System.out.println("===> Thông tin muốn sửa đổi không hợp lệ <===");
        }
    }

    private static void findNode(Heap<Student> studentHeap, Scanner input) {
        System.out.println("Nhập mã sinh viên cần tìm kiếm : ");
        input.nextLine();
        var id = input.nextLine();
        if (studentHeap.findNode(new Student(id)) != -1) {
            System.out.println("==> Đã tìm thấy sinh viên hợp lệ <===");
            System.out.println(studentHeap.showNodeDetail(new Student(id)));
        } else {
            System.out.println("==> Thông tin tìm kiếm không hợp lệ <===");
        }
    }

    private static void showNode(Heap<Student> studentHeap) {
        studentHeap.showElement();
    }

    private static void addNodeIntoHeap(Heap<Student> studentHeap, Scanner input) {
        System.out.println("Nhập mã sinh viên : ");
        input.nextLine();
        var id = input.nextLine();
        System.out.println("Nhập họ tên : ");
        var name = input.nextLine();
        System.out.println("Nhập gpa  : ");
        var gpa = Float.parseFloat(input.nextLine());
        if (studentHeap.add(new Student(id, name, gpa))) {
            System.out.println("===> Thêm mới sinh viên thành công <===");
        } else {
            System.out.println("===> Thêm mới sinh viên thất bại <===");
        }
    }
}
