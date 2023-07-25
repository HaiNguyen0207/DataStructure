package Sort.MergeSort.Test;

public class Test {
    // thuật toán sắp xếp trộn đệ quy
    static void mergeSort(int[] arr, int first, int last) { // first, last: chỉ số phần tử đầu, cuối
        if (first < last) {              // nếu first nhỏ hơn last
            int middle = (first + last) / 2;  // tìm chỉ số phần tử giữa
            mergeSort(arr, first, middle); // sắp xếp trộn nửa đầu mảng
            mergeSort(arr, middle + 1, last); // sắp xếp trộn nửa sau mảng
            merge(arr, first, middle, last);  // trộn hai nửa đã sắp xếp
        }
    }

    // thuật toán trộn hai mảng đã sắp xếp tăng dần
    static void merge(int[] arr, int first, int middle, int last) {
        // xác định kích thước hai mảng con cần trộn
        int size1 = middle - first + 1; // kích thước mảng con trái
        int size2 = last - middle; // kích thước mảng con phải
        // tạo mảng con để lưu các phần tử để trộn
        int[] leftArr = new int[size1];
        int[] rightArr = new int[size2];
        // chép dữ liệu vào mảng con trái
        for (int i = 0; i < size1; i++) {
            leftArr[i] = arr[first + i];
        }
        // chép dữ liệu vào mảng con phải
        for (int j = 0; j < size2; j++) {
            rightArr[j] = arr[middle + j + 1];
        }
        // tiến hành trộn
        int i = 0, j = 0, k = first;
        while (i < size1 && j < size2) {
            if (leftArr[i] <= rightArr[j]) {
                // gán arr[k] = leftArr[i] sau đó tăng k, i
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++]; // gán sau đó tăng k, j
            }
        }
        // chép các phần tử còn lại của mảng trái vào mảng arr
        while (i < size1) {
            arr[k++] = leftArr[i++];
        }
        // chép các phần tử còn lại của mảng phải vào mảng arr
        while (j < size2) {
            arr[k++] = rightArr[j++];
        }
    }

    // thuật toán sắp xếp insetion sort
    public static void insertionSort(int[] arr) {
        var n = arr.length;
        for (int i = 1; i <= n - 1; i++) {
            var j = i - 1;
            var targest = arr[i];
            while (j >= 0 && arr[j] > targest) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = targest;
        }
    }

    // thuật toán sắp xếp nổi bọt ( bubble sort)
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

    // thuật toán sắp xếp selection sort
    public static void selectionSort(int[] arr) {
        var n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            var minIndex = i;
            for (int j = i + 1; j <= n - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            var tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;

        }
    }

    // thuật toán sắp xếp heap sort
    public static void heapSort(int[] arr) {
        var n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) { // vun đống
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

    public static void main(String[] args) {
        int[] arr1 = {100, 26, 30, 27, 11, 54, 3, 4, 0, 9, 8, 79, 6, 5};
        System.out.println("Trước khi sắp xếp: ");
        showArrayElements(arr1);
        //    mergeSort(arr1, 0, arr1.length - 1);
        //insertionSort(arr1);
        // bubbleSort(arr1);
       // selectionSort(arr1);
        heapSort(arr1);
        System.out.println("Sau khi sắp xếp: ");
        showArrayElements(arr1);
    }

    private static void showArrayElements(int[] arr) {
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println("\n-----------------------------------");
    }
}

