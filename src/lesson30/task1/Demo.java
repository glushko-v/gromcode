package lesson30.task1;

public class Demo {
    public static void main(String[] args) {

        Bank usBank = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4,
                444343434);
        User Denis = new User(1001, "Denis", 12200, 40, "GMD", 1500, usBank);

        UkrainianBankSystem bankSystem = new UkrainianBankSystem();

        bankSystem.withdraw(Denis, 150);

        bankSystem.withdraw(Denis, 100);

        System.out.println(bankSystem.getTransactions());







    }
}
