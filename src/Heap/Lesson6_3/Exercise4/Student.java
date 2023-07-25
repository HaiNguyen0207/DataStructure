package Heap.Lesson6_3.Exercise4;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private String id;
    private FullName fullName;
    private float gpa;

    public Student(String id) {
        this.id = id;
    }

    public Student() {
    }

    public Student(String id, String fullName, float gpa) {
        this.fullName = new FullName();
        this.id = id;
        this.setFullName(fullName);
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName.lastName + " " + fullName.midName + fullName.firstName;
    }

    public void setFullName(String fullName) {
        var word = fullName.split(" ");
        this.fullName.lastName = word[0];
        this.fullName.firstName = word[word.length - 1];
        this.fullName.midName = "";
        for (int i = 1; i < word.length - 1; i++) {
            this.fullName.midName += word[i] + " ";
        }
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student o) {
        return id.compareTo(o.id);
    }

    class FullName {
        private String lastName;
        private String midName;
        private String firstName;

        public FullName() {

        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", fullName=" + getFullName() +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
