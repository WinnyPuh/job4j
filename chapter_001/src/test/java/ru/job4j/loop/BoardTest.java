package ru.job4j.loop;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 * @author Jora Abjora
 * @version $Id$
 * @since 0.1
 */
public class BoardTest {

    @Test
    public void when3x3() {
        Board board = new Board();
        String result = board.paint(3, 3);
        String ln = System.lineSeparator();
        assertThat(result, is(String.format("X X%s X %sX X%s", ln, ln, ln)));
    }

    @Test
    public void when4x3() {
        Board board = new Board();
        String result = board.paint(4, 3);
        String ln = System.lineSeparator();
        assertThat(result, is(String.format("X X %s X X%sX X %s", ln, ln, ln)));
    }
}