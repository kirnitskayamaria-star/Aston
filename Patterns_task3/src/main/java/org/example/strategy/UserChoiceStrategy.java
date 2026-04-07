package org.example.strategy;

import org.example.builder.Student;
import java.util.Map;


public interface UserChoiceStrategy {
    void invoke(String name, Map<String, Student> db);
}
