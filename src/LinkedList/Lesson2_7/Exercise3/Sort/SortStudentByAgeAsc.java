package LinkedList.Lesson2_7.Exercise3.Sort;

import LinkedList.Lesson2_7.Exercise3.Student;

import java.util.Comparator;

public class SortStudentByAgeAsc implements Comparator<Student> {
    @Override
    public int compare(Student other1, Student other2) {
        return other1.getAge()-other2.getAge();
    }
}
