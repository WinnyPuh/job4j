package ru.job4j.condition;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {
    @Test
    public void thenTwoPointWhen() {
        Point first = new Point(1, 1);
        Point second = new Point(2, 2);
        double result = 1.4142135623730951;
        double expect = first.distance(second);
        assertEquals(expect, 1.41, 0.01);
    }
    @Test
    public void thenPoint3DWhen() {
        Point first = new Point(1, 1, 1);
        Point second = new Point(2, 3, 4);
        double expect = first.distance3d(second);
        assertEquals(expect, 3.74d, 0.01);
    }
}