package org.example.proxy;

import org.example.builder.Student;

public class ProxyInfoService implements InfoService {
    private RealInfoService real = new RealInfoService();

    @Override
    public void showInfo(Student s) {
        System.out.println("Access logging for student:  " + s.getName());
        real.showInfo(s);
    }
}