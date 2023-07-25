package LinkedList.Lesson2_7.Exercise3.Sort;

import LinkedList.Lesson2_7.Exercise3.Student;

import java.util.Comparator;

public class SortStudentByIdAsc implements Comparator<Student> {
    @Override
    public int compare(Student other1, Student other2) {
        return other1.getId().compareTo(other2.getId());
    }
}
