package lesson20.task2;

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




        TransactionDAO transactionDAO = new TransactionDAO();


        Controller controller = new Controller();


            transactionDAO.save(transaction1);
            transactionDAO.save(transaction2);
            transactionDAO.save(transaction3);
            transactionDAO.save(transaction4);
            transactionDAO.save(transaction5);
            transactionDAO.save(transaction6);
            transactionDAO.save(transaction7);
            transactionDAO.save(transaction8);
            transactionDAO.save(transaction9);
            transactionDAO.save(transaction10);
//            transactionDAO.save(transaction11);

        System.out.println(Arrays.toString(transactionDAO.transactionList("Odessa")));







    }
}
