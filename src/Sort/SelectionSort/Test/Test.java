package Sort.SelectionSort.Test;

public class Test {
    public static <E extends Comparable<E>> void selectionSort(E[] arr) {
        var n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            var minMindex = i;
            for (int j = i + 1; j <= n - 1; j++) {
                if (arr[j].compareTo(arr[minMindex]) < 0) {
                    minMindex = j;
                }
            }
            var tmp = arr[minMindex];
            arr[minMindex] = arr[i];
            arr[i] = tmp;
        }
    }

    public static <E extends Comparable<E>> void showElements(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] numbers= new Integer[]{1,2,9,8,3,1,7,8,2,3,4,5,2,10};
        String[] names = new String[]{"Hương","Long","Minh","Vũ","Vân","Hồng"};
        showElements(numbers);
        showElements(names);
        selectionSort(numbers);
        selectionSort(names);
        showElements(numbers);
        showElements(names);
    }
}
