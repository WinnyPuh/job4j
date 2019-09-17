package ru.job4j.labmda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LambdaFuncTest {
    LambdaFunc func = new LambdaFunc();
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = func.diapason(5, 8, x -> (2 * x + 1));
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = func.diapason(5, 8, x -> (2 * Math.pow(x, 2) + 4 * x + 4));
        List<Double> expected = Arrays.asList(74D, 100D, 130D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        List<Double> result = func.diapason(2, 5, x -> (Math.log(x)/Math.log(2)));
        List<Double> expected = Arrays.asList(1D, 1.5849625007211563, 2D);
        assertThat(result, is(expected));
    }
}