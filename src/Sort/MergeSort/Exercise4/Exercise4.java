package Sort.MergeSort.Exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        int[] numbers = new int[]{12, 2, 1, 4, 5, 6, 7, 9, 0, 25, 34, 1};
        showElements(numbers);
        mergeSort(numbers, 0, numbers.length - 1);
        //heapSort(numbers);
        showElements(numbers);
    }

    private static void showElements(int[] numbers) {
        for (var e : numbers) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    // merge sort
    public static void mergeSort(int[] arr, int first, int last) {
        if (first < last) {
            var middle = (last + first) / 2; // tìm chỉ số phần tử phần tử
            mergeSort(arr, first, middle); // sắp xếp trộn nửa đầu mảng
            mergeSort(arr, middle + 1, last); // sắp xếp trộn nửa mảng sau
            merge(arr, first, middle, last); // trộn 2 nửa đã sắp xếp
        }
    }

    // heap sort
    public static void heapSort(int[] arr) {
        var n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) { // vun đống
            siftDown(arr, n, i); // sàng xuống từ vị trí i
        }
        // tráo đổi node đầu vs node cuối
        for (int i = n - 1; i > 0; i--) {
            var temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            siftDown(arr, i, 0);
        }
    }

    private static void siftDown(int[] arr, int n, int index) {
        var largest = index; // gán chỉ số lớn nhất
        var left = 2 * index + 1; // tìm chỉ số node trái
        var right = 2 * index + 2; // tìm chỉ số node phải
        if (left < n && arr[left] > arr[largest]) { // nếu node con trái lơn hơn node cha
            largest = left; // gán
        }
        if (right < n && arr[right] > arr[largest]) { // nếu node con phải lớn hơn node cha
            largest = right; // gán
        }
        if (index != largest) { // nếu node lớn nhất k phải node cha thì tráo đôi
            var temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            siftDown(arr, n, largest); // tiếp tục sàng xuống
        }
    }

    private static void merge(int[] arr, int first, int middle, int last) {
        var sizeLeft = middle - first + 1;// kích thước mảng con trái
        var sizeRight = last - middle; // kích thước mảng con phải
        int[] arrLeft = new int[sizeLeft];
        int[] arrRight = new int[sizeRight];

        for (int i = 0; i < sizeLeft; i++) { // chèn dữ liệu cho mảng con trái
            arrLeft[i] = arr[first + i];
        }
        for (int i = 0; i < sizeRight; i++) {// chèn dữ liệu cho mảng con phải
            arrRight[i] = arr[middle + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = first;
        // tiến hành trộn
        while (i < sizeLeft && j < sizeRight) {
            if (arrLeft[i] < arrRight[j]) {
                arr[k++] = arrLeft[i++];
            } else {
                arr[k++] = arrRight[j++];
            }
        }
        // chép dữ liệu còn lại của mảng con trái
        while (i < sizeLeft) {
            arr[k++] = arrLeft[i++];
        }
        // chép dữ liệu còn lại của mảng con phải
        while (j < sizeRight) {
            arr[k++] = arrRight[j++];
        }
    }
}
