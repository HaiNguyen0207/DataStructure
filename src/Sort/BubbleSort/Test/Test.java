package Sort.BubbleSort.Test;

public class Test {
    public static <E extends Comparable<E>> void bubbleSort(E[] arr) {
        var n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    var tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static <E extends Comparable<E>> void showArrays(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Integer[] numers = new Integer[] {5,2,1,5,6,8,9,3,4,7,8,2};
        showArrays(numers);
        System.out.println();
        bubbleSort(numers);
        showArrays(numers);
    }
}
