package ru.job4j.singleton;

/**
 * Singleton - Lazy loading 2.
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class TrackerSingleLazy2 {
    private TrackerSingleLazy2() {
    }

    public static TrackerSingleLazy2 getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleLazy2 INSTANCE = new TrackerSingleLazy2();
    }
}
