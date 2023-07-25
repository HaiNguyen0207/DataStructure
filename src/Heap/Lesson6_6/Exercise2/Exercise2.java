package Heap.Lesson6_6.Exercise2;

public class Exercise2 {
    public static <E extends Comparable<E>> void heapSort(E[] arr) {
        var n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            var tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            siftDown(arr, i, 0);
        }
    }

    private static <E extends Comparable<E>> void siftDown(E[] arr, int n, int index) {
        var smallest = index;
        var left = 2 * index + 1;
        var right = 2 * index + 2;
        if (left < n && arr[left].compareTo(arr[smallest]) < 0) {
            smallest = left;
        }
        if (right < n && arr[right].compareTo(arr[smallest]) < 0) {
            smallest = right;
        }
        if (smallest != index) {
            var tmp = arr[index];
            arr[index] = arr[smallest];
            arr[smallest] = tmp;
        }
    }

    public static <E extends Comparable<E>> void showElements(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{10, 2, 1, 9, 2, 8, 3, 4, 1, 6, 19, 11, 23, 6};
        showElements(numbers);
        heapSort(numbers);
        System.out.println();
        showElements(numbers);

    }
}
