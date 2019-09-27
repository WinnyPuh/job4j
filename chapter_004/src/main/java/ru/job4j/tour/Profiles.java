package ru.job4j.tour;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/** Класс содержащий коллекцию профилей клиентов.
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class Profiles {
    /**
     * Метод формирует коллекция адресов из коллекции профилей пользователей.
     * @param profiles - коллекция профилей.
     * @return - коллекция адресов.
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).sorted(Comparator.comparing(Address::getCity)).distinct().collect(Collectors.toList());
    }
}
