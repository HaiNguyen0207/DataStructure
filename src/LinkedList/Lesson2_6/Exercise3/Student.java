package LinkedList.Lesson2_6.Exercise3;

import java.util.Objects;

public class Student {
    private String id;
    private String fullName;
    private String addrees;
    private String email;
    private int age;
    private float gpa;

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String fullName,
                   String addrees, String email, int age,
                   float gpa) {
        this.id = id;
        this.fullName = fullName;
        this.addrees = addrees;
        this.email = email;
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

    public String getAddrees() {
        return addrees;
    }

    public void setAddrees(String addrees) {
        this.addrees = addrees;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getName(String fullName) {
        var word = fullName.split(" ");
        return word[word.length - 1];
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
                ", addrees='" + addrees + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                '}';
    }
}
