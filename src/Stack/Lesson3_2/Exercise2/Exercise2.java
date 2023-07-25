package Stack.Lesson3_2.Exercise2;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        var str = new Scanner(System.in).nextLine().split("\s+");
        for (int i = 0; i < str.length; i++) {
            stringStack.push(str[i]);
        }
        while (!stringStack.isEmpty()) {
            System.out.print(stringStack.peek() + " ");
            stringStack.pop();
        }
    }
}
