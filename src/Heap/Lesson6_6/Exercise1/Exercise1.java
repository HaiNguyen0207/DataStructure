package Heap.Lesson6_6.Exercise1;

import java.util.Scanner;

public class Exercise1 {
    public static <E extends Comparable<E>> void heapSort(E[] arr) {
        var n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) { // vun đống 
            siftDown(arr, n, i); // sàng xuống
        }
        for (int i = n - 1; i > 0; i--) {// đổi chỗi đầu vs cuối
            var tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            siftDown(arr, i, 0); // sàng lại
        }
    }

    private static <E extends Comparable<E>> void siftDown(E[] arr, int n, int index) {
        var largest = index;
        var left = 2 * index + 1;
        var right = 2 * index + 2;
        if (left < n && arr[left].compareTo(arr[largest]) > 0) {
            largest = left;
        }
        if (right < n && arr[right].compareTo(arr[largest]) > 0) {
            largest = right;
        }
        if (index != largest) {
            var tmp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = tmp;
            siftDown(arr, n, largest);
        }
    }

    //show element
    public static <E extends Comparable<E>> void showElement(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int t = input.nextInt();
        int count = 1;
        while (t > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            heapSort(arr);
            System.out.printf("\nTest %d: ", count++);
            showElement(arr);
            input.nextLine();
            t--;
        }
        input.close();
    }
}
