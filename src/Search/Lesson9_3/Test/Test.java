package Search.Lesson9_3.Test;

public class Test {
    public static int binarySearch(int[] arr, int left, int right, int key) {
        if (left < right) {
            var mid = left + right / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (mid < key) {// tìm kiếm bên trái
                return binarySearch(arr, left, mid - 1, key);
            } else {
                return binarySearch(arr, mid + 1, right, key);
            }
        }
        return -1;
    }

    //
    public static void main(String[] args) {
        int[] numbers = new int[]{0, 2, 4, 6, 8, 10, 11, 12, 14, 18};
        var key = 3;
        if (binarySearch(numbers, 0, numbers.length - 1, key) != -1) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

}
