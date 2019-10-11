package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public Map<Integer, Student> convertToMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(Student::getScore, student -> student));
    }
}
