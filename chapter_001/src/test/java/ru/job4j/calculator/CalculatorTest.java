package ru.job4j.calculator;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Jora Abjora
 * @version $Id$
 * @since 0.1
 */

public class CalculatorTest {
    /**
     * Test echo
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        double result = calc.add(1, 1);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenThreeSubtractOneThenTwo() {
        Calculator calc = new Calculator();
        double result = calc.subtract(3, 1);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenForeDivTwoThenTwo() {
        Calculator calc = new Calculator();
        double result = calc.div(4, 2);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoMultipleTwoThenFore() {
        Calculator calc = new Calculator();
        double result = calc.multiple(2, 2);
        double expected = 4D;
        assertThat(result, is(expected));
    }
}
