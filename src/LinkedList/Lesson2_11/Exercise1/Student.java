package LinkedList.Lesson2_11.Exercise1;

import java.util.Comparator;
import java.util.Objects;

public class Student {
    private String id;
    private FullName fullName;
    private String address;
    private String email;
    private int age;
    private float gpa;

    public Student() {
    }

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String fullName, String address,
                   String email, int age, float gpa) {
        this.id = id;
        this.fullName = new FullName();
        this.setFullName(fullName);
        this.address = address;
        this.email = email;
        this.age = age;
        this.gpa = gpa;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName.lastName + " " +
                fullName.midName + fullName.firstName;
    }
    public String getLastName(String fullName) {
        var words =fullName.split(" ");
        return  words[0];
    }


    public void setFullName(String fullName) {
        var words = fullName.split(" ");
        this.fullName.lastName = words[0];
        this.fullName.firstName = words[words.length - 1];
        this.fullName.midName = "";
        for (int i = 1; i < words.length - 1; i++) {
            this.fullName.midName += words[i] + " ";
        }
    }

    public String getName(String fullName) {
        var words = fullName.split(" ");
        return words[words.length - 1];
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

    class FullName {
        private String lastName;
        private String midName;
        private String firstName;

        public FullName() {
        }

        public FullName(String lastName, String midName,
                        String firstName) {
            this.lastName = lastName;
            this.midName = midName;
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getMidName() {
            return midName;
        }

        public void setMidName(String midName) {
            this.midName = midName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    }
}
