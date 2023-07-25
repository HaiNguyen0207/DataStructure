package Sort.QuickSort.Exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 4, 1, 5, 6, 9};
        showElements(numbers);
        //mergeSort(numbers, 0, numbers.length - 1);
        //quickSort(numbers, 0, numbers.length - 1);
        quickSortPivotFirst(numbers, 0, numbers.length - 1);
        showElements(numbers);
    }

    // mergeSort
    public static void mergeSort(int[] arr, int first, int last) {
        if (first < last) {
            var middle = (first + last) / 2;
            mergeSort(arr, first, middle);
            mergeSort(arr, middle + 1, last);
            merge(arr, first, middle, last);
        }
    }

    // quick sort với chốt là cuối mảng
    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            var p = parition(arr, leftIndex, rightIndex);
            quickSort(arr, leftIndex, p - 1);
            quickSort(arr, p + 1, rightIndex);
        }
    }

    // quicksort với chốt làm đầu
    public static void quickSortPivotFirst(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            var p = parition1(arr, leftIndex, rightIndex);
            quickSortPivotFirst(arr, leftIndex, p - 1);
            quickSortPivotFirst(arr, p+1, rightIndex);
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

    //showElements
    public static void showElements(int[] arr) {
        for (var e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
