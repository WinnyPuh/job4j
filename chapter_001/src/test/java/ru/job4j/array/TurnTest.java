package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 * @author Jora Abjora
 * @version $Id$
 * @since 0.1
 */
public class TurnTest {

    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = turn.back(input);
        int[] expect = new int[] {2, 6, 1, 4};
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayThenTurnedArray() {
        Turn turn = new Turn();
        int[] input = new int[] {4, 1, 6, 2, 3};
        int[] result = turn.back(input);
        int[] expect = new int[] {3, 2, 6, 1, 4};
        assertThat(result, is(expect));
    }
}