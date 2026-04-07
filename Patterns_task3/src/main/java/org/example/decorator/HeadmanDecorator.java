package org.example.decorator;

import org.example.builder.Student;
import org.example.proxy.InfoService;

public class HeadmanDecorator implements InfoService {
    private final InfoService wrapper;

    public HeadmanDecorator(InfoService wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public void showInfo(Student s) {
        System.out.print("Status: Headman ");
        wrapper.showInfo(s);
    }
}

