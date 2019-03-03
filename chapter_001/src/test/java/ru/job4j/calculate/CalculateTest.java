package ru.job4j.calculate;

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

public class CalculateTest {
    /**
     * Test echo
     */
    @Test
    public void whenTakeNmaeThreeEchoPlusName() {
        String input = "Jora Abjora";
        String expect = "Echo, echo, echo : Jora Abjora";
        Calculate calc = new Calculate();
        String result = calc.echo(input);
        assertThat(result, is(expect));
    }
}