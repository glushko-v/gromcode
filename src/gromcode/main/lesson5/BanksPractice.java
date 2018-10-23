package gromcode.main.lesson5;

import java.util.Arrays;

public class BanksPractice {
    public static void main(String[] args) {
        String [] names = {"Jack", "Nick", "Andrey", "Nina", "Walter", "Denis"};
        int[] balances =   {100, 500, 250, 3000, 780, -250};

        System.out.println(Arrays.toString(findClientsByBalance(names, balances, 500)));
        System.out.println(Arrays.toString(findClientsWithNegativeBalance(names, balances)));
        depositMoney(names, balances, "Denis", 300);
        System.out.println(Arrays.toString(balances));

    }

    static String[] findClientsByBalance(String[] clients, int[]balances, int n) {

        //Находим количество результатов
        int count = 0;
        for (int balance: balances) {
           if (balance >= n) count++;
        }
        //создаем массив с длиной результатов
        String [] results = new String[count];

        //записываем результаты
        int index = 0;
        int resIndex = 0;
        for (int balance: balances) {
            if (balance >= n) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }

    static String[] findClientsWithNegativeBalance(String[] clients, int[] balances) {
        int count = 0;
        for (int balance : balances) {
            if (balance < 0) count++;
        }

        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance < 0) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }
    static void depositMoney(String[] clients, int[]balances, String client, int money) {

        balances[findClientIndexByName(clients, client)] += calculateDepositAmountAfterCommission(money);
    }

    static int findClientIndexByName(String[]clients, String client) {
        int clientIndex = 0;

        for (String cl: clients) {
            if(cl == client) break;
            clientIndex++;
        }
        return clientIndex;
    }

    static int calculateDepositAmountAfterCommission(int money){
        return money <= 100 ? (int)(money - money*0.02) :(int)(money - money*0.01);

    }

    //метод withdraw, который списывает сумму со счета и возвращает остаток. если на счету нет денег
    //то возвращает -1

}
