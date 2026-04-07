package org.example.builder;

public class Student {
    private final String name;
    private final String email;
    private boolean isHeadman;

    private Student(StudentBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.isHeadman = builder.isHeadman;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', email='" + email + "', isHeadman=" + isHeadman + "}";
    }

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    public static class StudentBuilder {
        private String name;
        private String email;
        private boolean isHeadman;

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder email(String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder isHeadman(boolean isHeadman) {
            this.isHeadman = isHeadman;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isHeadman() {
        return isHeadman;
    }

    public void setHeadman(boolean headman) {
        isHeadman = headman;
    }
}
