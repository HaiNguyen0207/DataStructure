package LinkedList.Lesson2_11.Exercise1.Sort;

import LinkedList.Lesson2_11.Exercise1.Student;

import java.util.Comparator;

public class SortStudentsByNameAsc implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName(o1.getFullName()).
                compareToIgnoreCase(o2.getName(o2.getFullName()));
    }
}
