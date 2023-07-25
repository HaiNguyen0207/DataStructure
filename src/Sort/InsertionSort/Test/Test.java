package Sort.InsertionSort.Test;

public class Test {
    // insertion sort
    public static <E extends Comparable<E>> void insertionSort(E[] arr) {
        var n = arr.length;
        for (int i = 1; i <= n - 1; i++) {
            var target = arr[i];
            var j = i - 1;
            while (j >= 0 && arr[j].compareTo(target) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = target;
        }
    }

    // selection sort
    public static <E extends Comparable<E>> void selectionSort(E[] arr) {
        var n = arr.length;
        for (int i = 0; i <= n - 2; i++) {
            var minIndex = i;
            for (int j = i + 1; j <= n - 1; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            var tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }

    // bubble sort
    public static <E extends Comparable<E>> void bubbleSort(E[] arr) {
        var n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    var tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    // heap sort
    public static <E extends Comparable<E>> void heapSort(E[] arr) {
        var n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) { // vund dống
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
        var largest = index;
        var left = 2 * index + 1;
        var right = 2 * index + 2;
        if (left < n && arr[left].compareTo(arr[largest]) > 0) {
            largest = left;
        }
        if (right < n && arr[right].compareTo(arr[largest]) > 0) {
            largest = right;
        }
        if (largest != index) {
            var tmp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = tmp;
            siftDown(arr, n, largest);
        }
    }

    public static <E extends Comparable<E>> void showElements(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{1, 2, 3, 1, 9, 8, 2, 4, 5, 2, 6, 7, 8, 2};
        showElements(numbers);
        heapSort(numbers);
        showElements(numbers);

    }
}
