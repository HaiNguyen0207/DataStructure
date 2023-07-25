package Sort.QuickSort.Exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 21, 1, 4, 7, 8, 6, 3, 9, 10, 5};
        showElements(numbers);
        //heapSort(numbers);
        // mergeSort(numbers, 0, numbers.length - 1);
        quickSort(numbers, 0, numbers.length - 1);
        showElements(numbers);
    }

    private static void showElements(int[] arr) {
        for (var e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    // thuật toán heapsort
    public static void heapSort(int[] arr) {
        var n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(arr, n, i); // vun đống
        }
        // đổi chỗ node đầu và node cuối
        for (int i = n - 1; i > 0; i--) {
            var temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            siftDown(arr, i, 0);
        }
    }

    private static void siftDown(int[] arr, int n, int index) {
        var largest = index;
        var left = 2 * index + 1; // tìm chỉ số node con trái
        var right = 2 * index + 2; // tìm chỉ số node con phải
        if (left < n && arr[left] > arr[largest]) { // nếu node con trái lớn hơn node cha
            largest = left; // cập nhật lại
        }
        if (right < n && arr[right] > arr[largest]) { // nếu node con phải lơn hơn node cha
            largest = right; // chập nhật lại
        }
        if (index != largest) {//nếu node lớn nhất k phải là node cha
            // đổi chỗ
            var temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            // đệ quy
            siftDown(arr, n, largest);

        }
    }

    // thuật toán mergesort
    public static void mergeSort(int[] arr, int first, int last) {
        if (first < last) {
            var middle = (first + last) / 2;
            mergeSort(arr, first, middle); // sắp xếp  trộn nửa đầu mảng
            mergeSort(arr, middle + 1, last); // sắp xếp trộn nửa sau mảng
            merge(arr, first, middle, last); // trộn 2 mảng đã sắp xếp
        }
    }

    private static void merge(int[] arr, int first, int middle, int last) {
        var sizeLeft = middle - first + 1; // kích thước mảng con trái
        var sizeRight = last - middle; // kích thước mảng con phải
        int[] arrLeft = new int[sizeLeft];
        int[] arrRight = new int[sizeRight];
        // chèn dữ liệu mảng con trái
        for (int i = 0; i < sizeLeft; i++) {
            arrLeft[i] = arr[first + i];
        }
        // chèn dữ liệu mảng con phải
        for (int j = 0; j < sizeRight; j++) {
            arrRight[j] = arr[middle + 1 + j];
        }
        // tiến hành trộn
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

    // thuật toán quicksort
    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            var p = partitionFirst(arr, leftIndex, rightIndex);
            quickSort(arr, leftIndex, p - 1);
            quickSort(arr, p + 1, rightIndex);
        }
    }
    // chốt đầu mảng
    private static int partitionFirst(int[] arr, int leftIndex, int rightIndex) {
        var pivot = arr[leftIndex];
        var i = rightIndex;
        for (int j = rightIndex; j >= leftIndex; j--) {
            if (arr[j] < pivot) {
                var temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        var temp = arr[i];
        arr[i] = arr[rightIndex];
        arr[rightIndex] = temp;
        return i;
    }

    //  chốt là cuối mảng
    private static int partitionLast(int[] arr, int leftIndex, int rightIndex) {
        var pivot = arr[rightIndex];
        var i = leftIndex;
        for (int j = leftIndex; j <= rightIndex; j++) {
            if (arr[j] < pivot) {
                var temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        var temp = arr[i];
        arr[i] = arr[rightIndex];
        arr[rightIndex] = temp;
        return i;
    }


}
