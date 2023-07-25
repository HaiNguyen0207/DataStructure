package Sort.MergeSort.Exercise2;

public class Exercise2<E extends Comparable<E>> {
    // thuật toán sắp xếp merge sort
    public static void mergeSort(int[] arr, int first, int last) {
        if (first < last) {
            var middle = (first + last) / 2;
            mergeSort(arr, first, middle);//sắp xếp trộn nửa đầu  mảng
            mergeSort(arr, middle + 1, last); // sắp xếp nửa sau mảng
            merge(arr, first, middle, last);// trộn 2 nửa mảng đã sắp xếp
        }
    }

    private static void merge(int[] arr, int first, int middle, int last) {
        var sizeLeft = middle - first + 1;
        var sizeRight = last - middle;
        int[] arrLeft = new int[sizeLeft];
        int[] arrRight = new int[sizeRight];
        for (int i = 0; i < sizeLeft; i++) {
            arrLeft[i] = arr[first + i];
        }
        for (int j = 0; j < sizeRight; j++) {
            arrRight[j] = arr[middle + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = first;
        while (i < sizeLeft && j < sizeRight) {
            if (arrLeft[i] < arrRight[j]) {
                arr[k++] = arrLeft[i++];
            } else {
                arr[k++] = arrRight[j++];
            }
        }
        while (i < sizeLeft) {
            arr[k++] = arrLeft[i++];
        }
        while (j < sizeRight) {
            arr[k++] = arrRight[j++];
        }
    }

    // show elements
    public static void showElements(int[] arr) {
        for (var e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    // thuật toán sắp xếp heapSort
    public static void heapSort(int[] arr) {
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

    private static void siftDown(int[] arr, int n, int index) {
        var largest = index;
        var left = 2 * index + 1;
        var right = 2 * index + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != index) {
            var tmp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = tmp;
            siftDown(arr, n, largest);
        }
    }

    // thuật toán sắp xếp bubble
    public static void bubbleSort(int[] arr) {
        var n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    var tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    //  thuật toán insertion sort
    public static void insertionSort(int[] arr) {
        var n = arr.length;
        for (int i = 1; i <= n - 1; i++) {
            var targest = arr[i];
            var j = i - 1;
            while (j >= 0 && arr[j] > targest) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = targest;
        }
    }

    // thuật toán selectionSort
    public static void selectionSort(int[] arr) {
        var n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            var minIndex = i;
            for (int j = i + 1; j <= n - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            var tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{10, 2, 3, 8, 9, 23, 4, 5, 1, 6, 7, 8};
        showElements(numbers);
        // mergeSort(numbers, 0, numbers.length - 1);
        ///heapSort(numbers);
        // bubbleSort(numbers);
       // insertionSort(numbers);
        selectionSort(numbers);
        showElements(numbers);

    }
}
