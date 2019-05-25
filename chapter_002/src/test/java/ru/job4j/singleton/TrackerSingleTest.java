package ru.job4j.singleton;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class TrackerSingleTest {
    @Test
    public void whenCreateTrackerSingleEnum() {
        TrackerSingleEnum result = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum expected = TrackerSingleEnum.INSTANCE;
        assertThat(result, is(expected));
    }

    @Test
    public void whenCreateTrackerSingleLazy() {
        TrackerSingleLazy result = TrackerSingleLazy.getInstance();
        TrackerSingleLazy expected = TrackerSingleLazy.getInstance();
        assertThat(result, is(expected));
    }

    @Test
    public void whenCreateTrackerSingleEager() {
        TrackerSingleLazy result = TrackerSingleLazy.getInstance();
        TrackerSingleLazy expected = TrackerSingleLazy.getInstance();
        assertThat(result, is(expected));
    }

    @Test
    public void whenCreateTrackerSingleLazy2() {
        TrackerSingleLazy result = TrackerSingleLazy.getInstance();
        TrackerSingleLazy expected = TrackerSingleLazy.getInstance();
        assertThat(result, is(expected));
    }
}