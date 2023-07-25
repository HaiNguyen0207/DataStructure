package Heap.Lesson6_6.Test;

public class HeapSort {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{10, 2, 1, 8, 9, 3, 4, 11, 0, 6};
        String[] names = new String[]{"Hải", "Huy", "Hưng", "Thanh", "Hồng", "Ánh", "Loan", "Ly", "Thiện"};
        System.out.println("Mảng trước khi sắp xếp : ");
        showElement(numbers);
        System.out.println();
        showElement(names);
        System.out.println("\nMảng sau khi sắp xếp : ");
        heapSort(numbers);
        heapSort(names);
        showElement(numbers);
        System.out.println();
        showElement(names);
    }

    public static <E extends Comparable<E>> void heapSort(E[] arr) {
        // vun đống
        var n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(arr, n, i);
        }
        // đổi đầu vs cuối
        for (int i = n - 1; i > 0; i--) {
            var tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            siftDown(arr, i, 0); // sàng lại để tái cân bằng
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

    public static <E> void showElement(E[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
