package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class StudentLoader {
    public List<Student> loadFromResource(String path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream stream = Main.class.getClassLoader().getResourceAsStream(path)) {
            return mapper.readValue(stream, new TypeReference<List<Student>>() {});
        }
    }
}
