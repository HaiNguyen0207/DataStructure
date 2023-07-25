package LinkedList.Lesson2_11.Exercise1.Sort;

import LinkedList.Lesson2_11.Exercise1.Student;

import java.util.Comparator;

public class SortStudenByGpaDec implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getGpa() - o2.getGpa() > 0) {
            return -1;
        } else if (o1.getGpa() - o2.getGpa() < 0) {
            return 1;
        } else {
            if (o1.getName(o1.getFullName()).compareToIgnoreCase
                    (o2.getName(o2.getFullName())) > 0) {
                return 1;
            } else if (o1.getName(o1.getFullName()).compareToIgnoreCase
                    (o2.getName(o2.getFullName())) < 0) {
                return -1;
            } else {
                if (o1.getLastName(o1.getFullName()).compareToIgnoreCase
                        (o2.getLastName(o2.getFullName())) > 0) {
                    return 1;
                } else if (o1.getLastName(o1.getFullName()).compareToIgnoreCase
                        (o2.getLastName(o2.getFullName())) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
