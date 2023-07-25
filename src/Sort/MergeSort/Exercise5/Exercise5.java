package Sort.MergeSort.Exercise5;

public class Exercise5 {
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 9, 7, 4, 3, 1, 6, 8, 5};
        showElements(numbers);
        // heapSort(numbers);
        // mergeSort(numbers, 0, numbers.length - 1);
        quickSort(numbers, 0, numbers.length - 1);
        showElements(numbers);
    }

    // thuật toán quickSort
    public static void quickSort(int arr[], int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            var p = parition1(arr, leftIndex, rightIndex);
            quickSort(arr, leftIndex, p - 1);
            quickSort(arr, p + 1, rightIndex);
        }
    }

    // chọn chốt ở đầu mảng
    private static int parition1(int[] arr, int leftIndex, int rightIndex) {
        var pivot = arr[leftIndex];
        var i = leftIndex + 1;
        var j = rightIndex;
        do {
            while (i <= j && arr[i] < pivot) { // arr[i] < pivot thì tăng i đv
                i++;
            }
            while (i <= j && arr[j] > pivot) { // arr[j] > pivot thì giảm i 1 đv
                j--;
            }
            if (i < j) {
                var temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        // đổi chỗ chốt về đúng vị trí nó
        var temp = arr[leftIndex];
        arr[leftIndex] = arr[j];
        arr[j] = temp;
        return j;
    }

    // chọn chốt ở cuối mảng
    private static int parition(int[] arr, int leftIndex, int rightIndex) {
        var pivot = arr[rightIndex];
        var i = leftIndex;
        for (int j = leftIndex; j <= rightIndex; j++) {
            if (arr[j] < pivot) {
                var temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        var temp = arr[rightIndex];
        arr[rightIndex] = arr[i];
        arr[i] = temp;
        return i;
    }

    // thuật toán merge sort
    public static void mergeSort(int[] arr, int first, int last) {
        if (first < last) {
            var middle = (last + first) / 2;
            mergeSort(arr, first, middle); // sắp xếp mảng con bên trái
            mergeSort(arr, middle + 1, last); // sắp xếp mảng con bến phải
            merge(arr, first, middle, last);// trộn 2 mảng đã sắp xếp
        }
    }

    private static void merge(int[] arr, int first, int middle, int last) {
        var sizeLeft = middle - first + 1; // kích thước mảng con bên trái
        var sizeRight = last - middle; // kích thước manrng cỏn bên phải
        int[] arrLeft = new int[sizeLeft];// tạo mảng con bên trái;
        int[] arrRight = new int[sizeRight];// tạo mảng con bên phải
        // chèn dữ liệu 2 mảng
        for (int i = 0; i < sizeLeft; i++) {
            arrLeft[i] = arr[first + i];
        }
        for (int j = 0; j < sizeRight; j++) {
            arrRight[j] = arr[middle + 1 + j];
        }
        // trộn 2 mảng
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
        // chép nốt phần tử còn lại của mảng con trái
        while (i < sizeLeft) {
            arr[k++] = arrLeft[i++];
        }
        while (j < sizeRight) {
            arr[k++] = arrRight[j++];
        }
    }

    private static void showElements(int[] arr) {
        for (var e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    // thuật toán sắp xếp heap sort
    public static void heapSort(int[] arr) {
        var n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) { // vun đống
            siftDown(arr, n, i); // sàng xuống ,tái cân bằng heap
        }
        // đổi chỗ a[ơ] vs a[n-1]
        for (int i = n - 1; i > 0; i--) {
            var temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            siftDown(arr, i, 0); // sàng xuống
        }
    }

    private static void siftDown(int[] arr, int n, int index) {
        var largest = index; //
        var left = 2 * index + 1; // chỉ số node trái
        var right = 2 * index + 2; // chỉ số node phải
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (index != largest) { // nếu node lớn nhất k phải node cha
            // đổi chỗ và đệ quy tiếp
            var temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            siftDown(arr, n, largest);
        }
    }
}
