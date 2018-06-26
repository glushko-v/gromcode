package lesson22.HomeWork;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {

        Transaction transaction1 = new Transaction(111, "Kiev", 30, "supermarket",
                TransactionType.OUTCOME, new Date());

        Transaction transaction2 = new Transaction(222, "Odessa", 10, "deposit",
                TransactionType.INCOME, new Date());

        Transaction transaction3 = new Transaction(333, "Kiev", 10, "shop",
                TransactionType.OUTCOME, new Date());

        Transaction transaction4 = new Transaction(444, "Odessa", 5, "royalty",
                TransactionType.INCOME, new Date());

        Transaction transaction5 = new Transaction(555, "Odessa", 10, "deposit",
                TransactionType.INCOME, new Date());

        Transaction transaction6 = new Transaction(666, "Kiev", 5, "market",
                TransactionType.OUTCOME, new Date());

        Transaction transaction7 = new Transaction(777, "Odessa", 5, "fuel",
                TransactionType.OUTCOME, new Date());

        Transaction transaction8 = new Transaction(888, "Odessa", 5, "salary",
                TransactionType.INCOME, new Date());

        Transaction transaction9 = new Transaction(999, "Kiev", 10, "deposit",
                TransactionType.INCOME, new Date());

        Transaction transaction10 = new Transaction(101010, "Odessa", 5, "credit",
                TransactionType.OUTCOME, new Date());

        Transaction transaction11 = new Transaction(111111, "Odessa", 5, "credit",
                TransactionType.OUTCOME, new Date());







            Controller.save(transaction1);
            Controller.save(transaction2);
            Controller.save(transaction3);
            Controller.save(transaction4);


        System.out.println(Arrays.toString(Controller.transactionList("Odessa")));







    }
}
