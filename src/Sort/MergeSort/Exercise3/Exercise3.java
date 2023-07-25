package Sort.MergeSort.Exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 1, 5, 4, 6, 8, 7, 3, 10};
        showElements(numbers);
        //mergeSort(numbers, 0, numbers.length - 1);
        heapSort(numbers);
        showElements(numbers);
    }

    // thuật toán sắp xếp heapsort
    public static void heapSort(int[] arr) {
        var n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) { // vun đống
            siftDown(arr, n, i); // sàng xuống từ vị trí i
        }
        for (int i = n - 1; i > 0; i--) {// tráo đổi nút đầu vs nút cuối
            var temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            siftDown(arr, i, 0); // sàng lại
        }
    }

    private static void siftDown(int[] arr, int n, int index) {
        var largest = index;  // gán  chỉ số giải định lớn nhất cho largest
        var left = 2 * index + 1; // lấy chỉ số node con trái
        var right = 2 * index + 2; // lấy chỉ số node con phải
        if (left < n && arr[left] > arr[largest]) { //  nếu node con trái lớn hơn node cha
            largest = left; // thiết lập lại largest
        }
        if (right < n && arr[right] > arr[largest]) {// nếu node con phải lớn hơn node cha
            largest = right;
        }
        if (index != largest) { // nếu node lớn nhất k phải node cha thì tráo đổi
            var temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            siftDown(arr, n, largest); // tiếp tục đệ quy sàng xuống
        }

    }

    private static void showElements(int[] numbers) {
        for (var e : numbers) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    // thuật toán sắp xếp merge sort
    public static void mergeSort(int[] arr, int first, int last) {
        if (first < last) {
            var middle = (last + first) / 2;
            mergeSort(arr, first, middle); // sắp xếp trộn  nửa đầu mảng
            mergeSort(arr, middle + 1, last); // sắp xếp trộn nửa sảu mảng
            merge(arr, first, middle, last); //trộn 2 mảng đã sắp xếp
        }
    }

    private static void merge(int[] arr, int first, int middle, int last) {
        var sizeLeft = middle - first + 1;// kích thước mảng con trái
        var sizeRight = last - middle; // kích thước mảng con phải
        int[] arrLeft = new int[sizeLeft]; // khởi tạo
        int[] arrRight = new int[sizeLeft];
        for (int i = 0; i < sizeLeft; i++) { // chép dữ liệu vào mảng con trái
            arrLeft[i] = arr[first + i];
        }
        for (int i = 0; i < sizeRight; i++) { // chép dữ liệu vào mảng con phải
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
        // chép phần tử còn lại của mảng con trái vô arr
        while (i < sizeLeft) {
            arr[k++] = arrLeft[i++];
        }
        // chép phần tử còn lại mảng con phải vô arr
        while (j < sizeRight) {
            arr[k++] = arrRight[j++];
        }
    }
}
