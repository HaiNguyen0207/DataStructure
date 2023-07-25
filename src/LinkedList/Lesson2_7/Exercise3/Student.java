package LinkedList.Lesson2_7.Exercise3;

public class Student implements Comparable<Student> {
    private String id;
    private FullName fullName;
    private String address;
    private String email;
    private int age;
    private float gpa;

    public Student() {
    }

    public Student(String id, String fullName, String address,
                   String email, int age, float gpa) {
        this.fullName = new FullName();
        this.id = id;
        this.setFullName(fullName);
        this.address = address;
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
        return fullName.lastName + " "
                + fullName.midName + fullName.firtsName;
    }
    //get name
    public String getName() {
        return  fullName.getFirtsName();
    }

    public void setFullName(String fullName) {
        var word = fullName.split("\s");
        this.fullName.lastName = word[0];
        this.fullName.firtsName = word[word.length - 1];
        this.fullName.midName = "";
        for (int i = 1; i < word.length - 1; i++) {
            this.fullName.midName += word[i] + " ";
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    class FullName {
        private String lastName;
        private String midName;
        private String firtsName;

        public FullName() {
        }

        public FullName(String lastName, String midName,
                        String firtsName) {
            this.lastName = lastName;
            this.midName = midName;
            this.firtsName = firtsName;
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

        public String getFirtsName() {
            return firtsName;
        }

        public void setFirtsName(String firtsName) {
            this.firtsName = firtsName;
        }
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
