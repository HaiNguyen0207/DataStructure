package Heap.Lesson6_3.Exercise1;

import java.util.Scanner;

public class Exercise1 {
    private static int sizeMax = 256;

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(Integer.class, sizeMax);
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
                    System.out.println("===> Chương trình kết thức tại đây ! <====");
                    break;
                case 1:
                    System.out.println("Nhập giá trị node thêm : ");
                    input.nextLine();
                    var value = input.nextInt();
                    if (heap.add(value)) {
                        System.out.println("====> Thêm Node thành công <====");
                    } else {
                        System.out.println("====> Thêm Node thất bại <====");
                    }
                    break;
                case 2:
                    System.out.println("===> Danh sách các node <====");
                    heap.showElement();
                    break;
                case 3:
                    System.out.println("Nhập giá trị Node cần tìm : ");
                    input.nextLine();
                    var x = input.nextInt();
                    if (heap.findNode(x) != -1) {
                        System.out.println("====> True <====");
                    } else {
                        System.out.println("====> False <====");
                    }
                    break;
                case 4:
                    System.out.println("Nhập giá trị node cần xóa : ");
                    input.nextLine();
                    var valueRemove = input.nextInt();
                    if (heap.remove(valueRemove)) {
                        System.out.println("===> Xóa thành công <====");
                    } else {
                        System.out.println("===> Xóa thất bại <====");
                    }
                    break;
                case 5:
                    System.out.println("Node có giá trị lớn nhất là : " + heap.getMax());
                    break;
                case 6:
                    System.out.println("Kích cỡ hiện thời của Heap là : " + heap.getCurrentSize());
                    break;
                default:
                    System.out.println("===> Sai chức năng ! Vui lòng chọn lại <===");
                    break;
            }
        } while (choice != 0);
    }
}
