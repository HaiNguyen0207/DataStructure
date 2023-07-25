package Sort.QuickSort.Test;

public class Test {
    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            var p = partition1(arr, leftIndex, rightIndex);
            quickSort(arr, leftIndex, p - 1);
            quickSort(arr, p + 1, rightIndex);
        }
    }

    private static int partition1(int[] arr, int leftIndex, int rightIndex) {
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

    private static int partition(int[] arr, int leftIndex, int rightIndex) {
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

    public static void main(String[] args) {
        int[] numbers = new int[]{7, 2, 1, 6, 9, 3, 8, 5, 4};
        showElements(numbers);
        quickSort(numbers, 0, numbers.length - 1);
        showElements(numbers);
    }

    private static void showElements(int[] numbers) {
        for (var e : numbers) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
