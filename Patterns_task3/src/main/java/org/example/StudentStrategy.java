package org.example;

import java.util.Map;

interface StudentStrategy { void executeStrategy(String name, Map<String, Student> db); }

class AddStrategy implements StudentStrategy {
    public void executeStrategy(String name, Map<String, Student> db) {
        System.out.println("Addition selected");
    }
}

class DeleteStrategy implements StudentStrategy {
    public void executeStrategy(String name, Map<String, Student> db) {
        db.remove(name);
        System.out.println("The student " + name + " is deleted.");
    }
}