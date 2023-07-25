package Array.Lesson1_9;

public class Exercise1 {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4};
        generatePermutation(array);
    }

    private static void generatePermutation(int[] array) {
        var isFinal = false;
        while (!isFinal) {
            output(array);
            isFinal = nextPermutation(array);
        }
    }

    private static boolean nextPermutation(int[] arr) {
        int i = arr.length - 2; // xuất phát từ phần tử trước phần tử cuối
        while (i >= 0 && arr[i] > arr[i + 1]) { // tìm i sao cho arr[i] < arr[i+1]
            i--;
        }
        if (i >= 0) { // nếu i chưa vượt quá phần tử trái cùng
            int k = arr.length - 1; // xuất phát từ phần tử phải cùng
            while (arr[i] > arr[k]) { // tìm k sao cho arr[k] > arr[i]
                k--;
            }
            // đổi chỗ hai phần tử tại vị trí i và k
            int tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
            int r = i + 1; // gán r = i + 1
            int s = arr.length - 1; // gán s = vị trí cuối mảng
            while (r < s) { // lật ngược đoạn từ j + 1 đến n
                int t = arr[r];
                arr[r] = arr[s];
                arr[s] = t;
                r++;
                s--;
            }
            return false; // trả về thông báo cấu hình chưa phải cuối cùng
        } else {
            return true; // trả về thông báo cấu hình cuối cùng
        }
    }

    private static void output(int[] array) {
        for (var e : array) {
            System.out.printf("%5d", e);
        }
        System.out.println();
    }
}
