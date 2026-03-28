package org.example;

class Student {
    private String name;
    private String faculty;
    private String email;
    private boolean isHeadman = false;

    private Student() {}

    public String getName() { return name; }
    public String getFaculty() { return faculty; }
    public String getEmail() { return email; }

    public boolean isHeadman() { return isHeadman; }
    public void setHeadman(boolean headman) { isHeadman = headman; }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }

    public static class StudentBuilder {
        private final Student s = new Student();

        public StudentBuilder buildName(String n) {
            s.name = n;
            return this;
        }
        public StudentBuilder buildEmail(String e) {
            s.email = e;
            return this;
        }
        public StudentBuilder buildFaculty(String f) {
            s.faculty = f;
            return this;
        }

        public Student getResult() {
            return s;
        }
    }
}