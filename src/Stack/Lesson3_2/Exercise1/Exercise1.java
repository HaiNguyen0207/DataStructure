package Stack.Lesson3_2.Exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        Stack<Student> studentStack = new Stack<>();
        addStudentInStack(studentStack);
        showStudents(studentStack);
    }

    private static void showStudents(Stack<Student> studentStack) {
        System.out.printf("%-20s%-25s%-20s%-20s%-15s%-15s\n", "StuentID",
                "FullName", "Address", "Email", "Age", "Gpa");
        while (!studentStack.isEmpty()) {
            var e =studentStack.peek();
            System.out.printf("%-20s%-25s%-20s%-20s%-15d%-15.2f\n", e.getId(),
                    e.getFullName(), e.getAddress(), e.getEmail(), e.getAge(), e.getGpa());
            studentStack.pop();
        }
    }

    private static void addStudentInStack(Stack<Student> studentStack) {
        studentStack.push(new Student("AT170415",
                "Nguyen Van Hai", "Ha Noi", "hai@xmail.com", 20, 2.75f));
        studentStack.push(new Student("AT170425",
                "Nguyen Van Hung", "Ha Giang", "hung@xmail.com", 22, 3.0f));
        studentStack.push(new Student("AT170417",
                "Trinh Thi Hoa", "Thanh Hoa", "hoa@xmail.com", 19, 2.25f));
        studentStack.push(new Student("AT170435",
                "Nguyen Cong Minh", "Ha Noi", "minh@xmail.com", 20, 2.95f));
        studentStack.push(new Student("AT170446",
                "Le Thi Hong", "Hung Yen", "hong@xmail.com", 21, 2.25f));
        studentStack.push(new Student("AT170409",
                "Nguyen Tat Duy",
                "Lao Cai", "duy@xmail.com", 21, 3.15f));
        studentStack.push(new Student("AT170411",
                "Nguyen Truong Giang", "Yen Bai", "giang@xmail.com", 20, 3.05f));
        studentStack.push(new Student("AT170437", "Tran Thanh Hai ", "Quang Binh",
                "hai@xmail.com", 22, 3.15f));
        studentStack.push(new Student("AT170438", "An Quang Hai ", "Son La",
                "hai@xmail.com", 21, 3.15f));
        studentStack.push(new Student("AT170421", "Tran Thanh Hoang ", "Cao Bang",
                "hai@xmail.com", 20, 3.15f));
    }
}
