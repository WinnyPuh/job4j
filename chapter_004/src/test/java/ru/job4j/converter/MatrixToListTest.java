package ru.job4j.converter;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixToListTest {
    @Test
    public void thenMartixWhenList() {
        List<List<Integer>> matrix = List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6));
        List<Integer> result = new MatrixToList().converter(matrix);
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }
}