package ru.job4j.singleton;

/**
 * Singleton - Eager loading 2.
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class TrackerSingleEager {
    private static final TrackerSingleEager INSTANCE = new TrackerSingleEager();

    private TrackerSingleEager() {
    }

    public static TrackerSingleEager getInstance() {
        return INSTANCE;
    }
}
