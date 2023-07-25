package Heap.Lesson6_2.Exercise1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(Integer.class, 99);
        var input = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("=====================> Mennu <===================");
            System.out.println("=> 1. Thêm một phần tử vô Heap                 <=");
            System.out.println("=> 2. Hiển thị các phần tử trong Heap          <=");
            System.out.println("=> 3. Hiển thị phần tử Max trong Heap          <=");
            System.out.println("=> 4. Hiển thị kích thước hiện thời trong Heap <=");
            System.out.println("=> 0. Kết thúc chương trình                    <=");
            System.out.println("=================================================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("===> Kết thúc chương trình <=====");
                    break;
                case 1:
                    System.out.println("Nhập giá trị thêm : ");
                    input.nextLine();
                    var e = input.nextInt();
                    if (heap.add(e)) {
                        System.out.println("===> Thêm thành công <===");
                    } else {
                        System.out.println("===> Thêm thất bại <===");
                    }
                    break;
                case 2:
                    if (heap.getSize() < 0) {
                        System.out.println("===> Danh sách Heap rỗng <=====");
                    } else {
                        heap.showElement();
                        System.out.println();
                    }
                    break;
                case 3:
                    if (heap.getSize() == 0) {
                        System.out.println("===> Danh sách Heap rỗng <=====");
                    } else {
                        System.out.println(heap.getMaxHeap());
                    }
                    break;
                case 4:
                    if (heap.getSize() == 0) {
                        System.out.println("===> Danh sách Heap rỗng <=====");
                    } else {
                        System.out.println(heap.getSize());
                    }
                    break;
                default:
                    System.out.println("==> Sai chức năng ! Vui lòng chọn lại ");
                    break;
            }
        } while (choice != 0);
    }
}