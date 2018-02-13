package gromcode;

import java.util.Arrays;

public class BankArrayTest {
    public static void main(String[] args) {
        String[]names = {"Jack", "Bill", "Dan", "Jeff"};
        int[]balance = {100, 50, 200, -20};
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(balance));
        System.out.println(withdraw(names, balance, "Bill", 75));

    }
    static int findBalanceByName(String []names, int[]balances, String name){

        int index = 0;
        for (String client: names) {
            if (client == name) break;
            index++;
        }
        return balances[index];

    }

    static int withdraw (String[]names, int[]balances, String name, int amount){

        if ((findBalanceByName(names, balances, name))>0) {

            int balanceAfter = findBalanceByName(names, balances, name) - amount;
            if (balanceAfter >= 0) return balanceAfter;
            else return -1;
        }
         else return -1;
    }

}
