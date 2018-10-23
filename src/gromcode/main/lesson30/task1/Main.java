package gromcode.main.lesson30.task1;

public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4,
        444343434);
        Bank chinaBank = new ChinaBank(213, "China", Currency.USD, 300, 1000, 3,
        500000000);
        User Denis = new User(1001, "Denis", 12200, 40, "GMD", 1500, usBank);
        User Alex = new User(638, "Alex", 13000, 38, "TMT", 2000, usBank);
        User Helen = new User(222, "Helen", 5000, 12, "FBI", 1500, chinaBank);

        BankSystem bankSystem = new UkrainianBankSystem();
//        bankSystem.withdraw(Denis, 150);
//        bankSystem.fund(Denis, 150);
//        bankSystem.fund(Alex, 200);
//       bankSystem.transferMoney(Alex, Denis, 200);
       bankSystem.paySalary(Alex);
//       bankSystem.transferMoney(Alex, Helen, 100);
//        bankSystem.paySalary(Denis);
//        bankSystem.paySalary(Alex);

        System.out.println("Denis balance is " + Denis.getBalance());
        System.out.println("Alex balance is " + Alex.getBalance());
    }
}
