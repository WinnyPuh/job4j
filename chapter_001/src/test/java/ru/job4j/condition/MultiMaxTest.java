package ru.job4j.condition;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 * @author Jora Abjora
 * @version $Id$
 * @since 0.1
 */
public class MultiMaxTest {

    @Test
    public void whenSecondMax() {
        MultiMax multiMax = new MultiMax();
        int result = multiMax.max(1, 4, 2);
        assertThat(result, is(4));
    }
}