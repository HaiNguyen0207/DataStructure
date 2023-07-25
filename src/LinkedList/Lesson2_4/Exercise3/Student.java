package LinkedList.Lesson2_4.Exercise3;

import java.util.Objects;

public class Student {
    private String id;
    private String fullName;
    private String address;
    private int age;
    private float gpa;

    public Student() {
    }

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String fullName,
                   String address, int age, float gpa) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.age = age;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
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

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                '}';
    }
}
