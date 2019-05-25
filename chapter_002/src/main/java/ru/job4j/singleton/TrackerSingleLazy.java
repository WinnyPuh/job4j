package ru.job4j.singleton;

/**
 * Singleton - Lazy loading.
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class TrackerSingleLazy {
    private static TrackerSingleLazy instance;

    private TrackerSingleLazy(){
    }

    public static TrackerSingleLazy getInstance() {
        if (instance == null) {
            instance = new TrackerSingleLazy();
        }
        return instance;
    }
}
