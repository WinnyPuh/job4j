package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    public List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(30),
            new Student(25),
            new Student(54),
            new Student(78),
            new Student(99),
            new Student(87),
            new Student(56),
            new Student(14),
            new Student(67),
            new Student(28)
        ));
    @Test
    public void filterFrom0To50() {
        List<Student> result = new School().collect(students, student -> student.getScore() < 50);
        List<Student> expect = new ArrayList<>(Arrays.asList(
                new Student(30),
                new Student(25),
                new Student(14),
                new Student(28)
        ));
        assertThat(result, is(expect));
    }
    @Test
    public void filterFrom50To70() {
        List<Student> result = new School().collect(students, student -> student.getScore() >= 50 && student.getScore() < 70);
        List<Student> expect = new ArrayList<>(Arrays.asList(
                new Student(54),
                new Student(56),
                new Student(67)
        ));
        assertThat(result, is(expect));
    }
    @Test
    public void filterFrom70To100() {
        List<Student> result = new School().collect(students, student -> student.getScore() >= 70 && student.getScore() < 100);
        List<Student> expect = new ArrayList<>(Arrays.asList(
                new Student(78),
                new Student(99),
                new Student(87)
        ));
        assertThat(result, is(expect));
    }
    @Test
    public void convertListToMap() {
        Map<Integer, Student> result = new School().convertToMap(students);
        Map<Integer, Student> expect = new HashMap<>();
        for (Student stu : students) {
            expect.put(stu.getScore(), stu);
        }
        assertThat(result, is(expect));
    }
    @Test
    public void sortAndFilter() {
        List<Student> result = new School().levelOf(students, 50);
        List<Student> expect = new ArrayList<>(Arrays.asList(
                new Student(99),
                new Student(87),
                new Student(78),
                new Student(67),
                new Student(56),
                new Student(54)
        ));
        assertThat(result, is(expect));
    }
}