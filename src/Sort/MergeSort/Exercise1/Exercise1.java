package Sort.MergeSort.Exercise1;

public class Exercise1 {
    public static void mergeSort(int[] arr, int first, int last) {
        if (first < last) {
            var middle = (first + last) / 2;
            mergeSort(arr, first, middle);
            mergeSort(arr, middle + 1, last);
            merge(arr, first, middle, last);
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

    public static void main(String[] args) {
        int[] arr1 = {100, 26, 30, 27, 11,10};
        System.out.println("Trước khi sắp xếp: ");
        showArrayElements(arr1);
        mergeSort(arr1, 0, arr1.length - 1);
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
