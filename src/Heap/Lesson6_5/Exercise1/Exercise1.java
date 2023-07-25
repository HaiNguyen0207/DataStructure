package Heap.Lesson6_5.Exercise1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(256);
        var input = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("======================> Menu <=======================");
            System.out.println("= 1. Thêm mới một Node vào hàng đợi                 =");
            System.out.println("= 2. Hiển thị các Node trong hàng đợi               =");
            System.out.println("= 3. Tìm xem Node X có tồn tại không ?              =");
            System.out.println("= 4. Peek                                           =");
            System.out.println("= 5. Remove                                         =");
            System.out.println("= 6. Kiểm tra xem hàng đợi có rỗng ?                =");
            System.out.println("= 7. Kiểm tra xem hàng đợi đầy chưa                 =");
            System.out.println("= 8. Cho biết kích thước hiện thời của mảng         =");
            System.out.println("= 0. Kết thúc chương trình                          =");
            System.out.println("=====================================================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("==> Chương trình đã kết thúc <====");
                    break;
                case 1:
                    addNewNode(priorityQueue, input);
                    break;
                case 2:
                    showNode(priorityQueue);
                    break;
                case 3:
                    findNode(priorityQueue, input);
                    break;
                case 4:
                    peekQueue(priorityQueue);
                    break;
                case 5:
                    removeQueue(priorityQueue);
                    break;
                case 6:
                    checkEmpty(priorityQueue);
                    break;
                case 7:
                    checkIsFull(priorityQueue);
                    break;
                case 8:
                    getCurrentSize(priorityQueue);
                    break;
                default:
                    System.out.println("==> Sai chức năng ! Vui lòng thử lại <===");
                    break;
            }
        } while (choice != 0);
    }

    private static void getCurrentSize(PriorityQueue priorityQueue) {
        System.out.println("Kích thước hiện thời của mảng : " + priorityQueue.getCurrentSize());
    }

    private static void checkIsFull(PriorityQueue priorityQueue) {
        System.out.println("Hàng đợi có đầy ? " + priorityQueue.isFull());
    }

    private static void checkEmpty(PriorityQueue priorityQueue) {
        System.out.println("Hàng đợi có rỗng ? : " + priorityQueue.isEmpty());
    }

    private static void removeQueue(PriorityQueue priorityQueue) {
        System.out.println("Remove Queue : " + priorityQueue.remove());
    }

    private static void peekQueue(PriorityQueue priorityQueue) {
        System.out.println("Lấy giá trị có quyền ưu tiên đầu trong hàng đợi : \n"
                + priorityQueue.peek());
    }

    private static void findNode(PriorityQueue priorityQueue, Scanner input) {
        System.out.println("Nhập giá trị Node cần tìm : ");
        input.nextLine();
        var x = Integer.parseInt(input.nextLine());
        if (priorityQueue.search(x)) {
            System.out.println("===> Giá trị " + x + " có tồn tại <===");
        } else {
            System.out.println("===> Giá trị " + x + " không tồn tại <===");
        }
    }

    private static void showNode(PriorityQueue priorityQueue) {
        priorityQueue.showElement();
        System.out.println();
    }

    private static void addNewNode(PriorityQueue priorityQueue, Scanner input) {
        System.out.println("Nhập giá trị Node : ");
        input.nextLine();
        var value = Integer.parseInt(input.nextLine());
        System.out.println("Nhập giá trị ưu tiên : ");
        var priority = Integer.parseInt(input.nextLine());
        if (priorityQueue.add(value, priority)) {
            System.out.println("===> Thêm mới một Node thành công <===");
        } else {
            System.out.println("===> Thêm mới một Node thất bại <===");
        }
    }
}
