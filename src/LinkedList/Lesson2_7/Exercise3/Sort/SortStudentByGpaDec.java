package LinkedList.Lesson2_7.Exercise3.Sort;

import LinkedList.Lesson2_7.Exercise3.Student;

import java.util.Comparator;

public class SortStudentByGpaDec implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getGpa()-o2.getGpa() >0) {
            return  -1;
        }else if(o1.getGpa()-o2.getGpa() ==0) {
            return  0;
        }else {
            return 1;
        }
    }
}
