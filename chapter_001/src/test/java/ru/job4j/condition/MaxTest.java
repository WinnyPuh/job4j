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
public class MaxTest {

    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax10To2Then10() {
        Max max = new Max();
        int result = max.max(10, 2);
        assertThat(result, is(10));
    }

    @Test
    public void whenMax1To5Then5() {
        Max max = new Max();
        int result = max.max(1, 5);
        assertThat(result, is(5));
    }

    @Test
    public void whenMax1and5and10Then10() {
        Max max = new Max();
        int result = max.max(1, 5, 10);
        assertThat(result, is(10));
    }
    @Test
    public void whenMax1and5and10and3Then10() {
        Max max = new Max();
        int result = max.max(1, 5, 10, 3);
        assertThat(result, is(10));
    }
}