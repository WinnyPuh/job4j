package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Банк.
 * @version $.
 * @since 0.1
 */
public class Bank {

    private TreeMap<User, ArrayList<Account>> userMap = new TreeMap<>();

    public void addUser(User user) {
        this.userMap.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.userMap.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        if (passport == null || account == null) {
            System.out.println("Пользователь не найден!");
        } else {
            this.userMap.get(getUser(passport)).add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        if (passport == null || account == null) {
            System.out.println("Пользователь не найден!");
        } else {
            this.userMap.get(getUser(passport)).remove(account);
        }
    }

    private Account getActualAccount(User user, Account account) {
        ArrayList<Account> list = this.userMap.get(user);
        int index = list.indexOf(account);
        if (index < 0) {
            System.out.println("Пользователь не найден!");
            return null;
        }
        return list.get(index);
    }

    public List<Account> getUserAccounts(String passport) {
        return this.userMap.get(getUser(passport));
    }

    public Account getUserAccount(String passport, String requisite) {
        List<Account> acc = getUserAccounts(passport);
        Account result = null;
        for (Account value : acc) {
            if (value.getReqs().equals(requisite)) {
                result = value;
                break;
            }
        }
        return result;
    }

    public boolean transferMoney(String  srcPassport, String srcRequisite,
                                 String dstPassport, String dstRequisite, double amount) {
        Account srcAccount = getUserAccount(srcPassport, srcRequisite);
        Account dstAccount = getUserAccount(dstPassport, dstRequisite);
        boolean result;
        if (srcAccount == null || dstAccount == null) {
            result = false;
        } else {
            result = srcAccount.transfer(dstAccount, amount);
        }
        return result;
    }
    
    private User getUser(String passport) {
        User result = null;
        for (Map.Entry<User, ArrayList<Account>> entry : this.userMap.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                result = entry.getKey();
            }
        }
        return result;
    }

//    private Account getAccount(User user,String requisite) {
//        ArrayList<Account> acc = this.userMap.get(user);
//
//        return acc.;
//    }

    public String toString() {
        return "Bank{" + "accounts=" + userMap + "}";
    }
}