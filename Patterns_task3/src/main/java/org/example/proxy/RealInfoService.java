package org.example.proxy;


import org.example.builder.Student;

public class RealInfoService implements InfoService {
    @Override
    public void showInfo(Student student) {
        System.out.println("Info from the database " + student.toString());
    }
}
