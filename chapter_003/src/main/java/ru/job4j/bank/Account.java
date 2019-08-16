package ru.job4j.bank;
/**
 * Счет.
 * @version $.
 * @since 0.1
 */

public class Account {
    /**
     * Средства на счету.
     */
    private double values;
    /**
     * Номер счета.
     */
    private String reqs;

    public Account(double values, String requisites) {
        this.values = values;
        this.reqs = requisites;
    }

    public double getValues() {
        return this.values;
    }


    public String getReqs() {
        return this.reqs;
    }

    /**
     * Переводит средства на другой счет.
     * @param destination - счет получатель.
     * @param amount - сумма перевода.
     * @return - результат перевода.
     */
    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    public String toString() {
        String otvet;
        otvet = "Account{" + "values=" + values + ", reqs='" + reqs + "\\" + "}";
        return otvet;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return this.reqs.equals(account.reqs);
    }

    public int hashCode() {
        return this.reqs.hashCode();
    }
}