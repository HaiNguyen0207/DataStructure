package Sort.QuickSort.Exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        int[] numbers = new int[]{3, 7, 8, 4, 3, 2, 1, 9, 10, 2, 5};
        showElements(numbers);
        quickSort(numbers, 0, numbers.length - 1);
        //heapSort(numbers);
        // mergeSort(numbers, 0, numbers.length - 1);
        showElements(numbers);
    }

    // merge sort
    public static void mergeSort(int[] numbers, int first, int last) {
        if (first < last) {
            var middle = (first + last) / 2;
            mergeSort(numbers, first, middle);
            mergeSort(numbers, middle + 1, last);
            merge(numbers, first, middle, last);
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
        for (int i = 0; i < sizeRight; i++) {
            arrRight[i] = arr[middle + i + 1];
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

    // heapsort
    public static void heapSort(int[] arr) {
        var n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) { // vun đống
            siftDown(arr, n, i);// sáng xuống
        }
        for (int i = n - 1; i > 0; i--) { // đổi chỗ node cuối vs node cha
            var temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            siftDown(arr, i, 0);
        }
    }

    private static void siftDown(int[] arr, int n, int index) {
        var largest = index;
        var left = 2 * index + 1; // node trái
        var right = 2 * index + 2;// chỉ số node con phải
        if (left < n && arr[left] > arr[largest]) { // nếu node con trái > node cha
            largest = left; // cập nhất node cha mới
        }
        if (right < n && arr[right] > arr[largest]) { // nếu node con phải > node cha
            largest = right; // cập nhật lại
        }
        if (index != largest) {// nếu node lớn nhất k phải node cha ,đổi chỗ ,rồi đệ quy
            var temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            siftDown(arr, n, largest);
        }
    }


    // quick sort
    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            var p = partition(arr, leftIndex, rightIndex);
            quickSort(arr, leftIndex, p - 1);
            quickSort(arr, p + 1, rightIndex);
        }
    }

    private static int partition(int[] arr, int leftIndex, int rightIndex) {
        var pivot = arr[rightIndex];
        int i = leftIndex;
        for (int j = leftIndex; j <=rightIndex; j++) {
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

    public static void showElements(int[] arr) {
        for (var e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

}
