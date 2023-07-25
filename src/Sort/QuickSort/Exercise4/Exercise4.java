package Sort.QuickSort.Exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        int[] numbers = new int[]{6, 3, 2, 7, 8, 4, 5, 9, 0, 1};
        showElements(numbers);
        //  heapSort(numbers);
        //  mergeSort(numbers, 0, numbers.length - 1);
        //quickSort(numbers, 0, numbers.length - 1);
        quickSort1(numbers, 0, numbers.length - 1);
        showElements(numbers);
    }

    public static void showElements(int[] arr) {
        for (var e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    // thuật toán sắp xếp nhanh quick sort
    // chọn chốt làm phần tử cuối mảng
    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            var p = parition(arr, leftIndex, rightIndex);
            quickSort(arr, leftIndex, p - 1);
            quickSort(arr, p + 1, rightIndex);
        }
    }

    // thuật toán sắp xếp nhanh quick sort
    // chọn chốt làm phần tử cuối mảng
    public static void quickSort1(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            var p = parition1(arr, leftIndex, rightIndex);
            quickSort(arr, leftIndex, p - 1);
            quickSort(arr, p + 1, rightIndex);
        }
    }

    private static int parition1(int[] arr, int leftIndex, int rightIndex) {
        var pivot = arr[leftIndex];
        var i = leftIndex + 1;
        var j = rightIndex;
        do {
            while (i <= j && arr[i] < pivot) {
                i++;
            }
            while (i <= j && arr[j] > pivot) {
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
        var temp = arr[leftIndex];
        arr[leftIndex] = arr[j];
        arr[j] = temp;
        return j;
    }

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


    // thuật toán sắp xếp heapsort
    public static void heapSort(int[] arr) {
        var n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {// vun đống
            siftDown(arr, n, i);
        }
        // đổi chỗ node gốc vs node cuối
        for (int i = n - 1; i > 0; i--) {
            var temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            siftDown(arr, i, 0);// sàng lại để tái cân bằng đống
        }
    }

    //thuật toán sắp xếp hòa nhập merge sort
    public static void mergeSort(int[] arr, int first, int last) {
        if (first < last) { //
            var middle = (last + first) / 2;
            mergeSort(arr, first, middle);
            mergeSort(arr, middle + 1, last);
            merge(arr, first, middle, last);
        }
    }

    private static void merge(int[] arr, int first, int middle, int last) {
        var sizeLeft = middle - first + 1; // kích thước mảng con trái
        var sizeRight = last - middle; // kích thước mảng con phải
        int[] arrLeft = new int[sizeLeft]; // khởi tạo mảng con trái
        int[] arrRight = new int[sizeRight]; // khởi tạo mảng con phải
        // chèn dữ liệu cho mảng con trái
        for (int i = 0; i < sizeLeft; i++) {
            arrLeft[i] = arr[first + i];
        }
        // chèn dữ liệu mảng còn phải
        for (int i = 0; i < sizeRight; i++) {
            arrRight[i] = arr[middle + 1 + i];
        }
        // tiền hành hòa nhập
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
        // chép cái phần tử còn lại của mảng con trái vào mảng arr
        while (i < sizeLeft) {
            arr[k++] = arrLeft[i++];
        }
        // chép cái phần tử còn lại mảng con phải vào mảng arr
        while (j < sizeRight) {
            arr[k++] = arrRight[j++];
        }

    }


    private static void siftDown(int[] arr, int n, int index) {
        var largest = index;// gán vị  trí lớn nhất là chỉ số hiện thời
        var left = 2 * index + 1; // tìm chỉ số node con trái
        var right = 2 * index + 2;// tìm chỉ số node con phải
        if (left < n && arr[left] > arr[largest]) {// nếu node con trái lớn hơn nodecha
            largest = left; // cập nhật lại node cha
        }
        if (right < n && arr[right] > arr[largest]) {// nếu node con phải lơn hơn node cha
            largest = right; // cập nhật node cha  bằng right
        }
        if (index != largest) {// nếu node cha k phải node index
            // thì đổi chỗ
            //rồi tieeos tục đệ quy
            var temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            siftDown(arr, n, largest);
        }
    }
}
