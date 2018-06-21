package lesson20.task2;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {

        Transaction transaction1 = new Transaction(111, "Kiev", 30, "supermarket",
                TransactionType.OUTCOME, new Date());

        Transaction transaction2 = new Transaction(222, "Odessa", 10, "deposit",
                TransactionType.INCOME, new Date());

        TransactionDAO transactionDAO = new TransactionDAO();


        Controller controller = new Controller();


            transactionDAO.save(transaction1);


        System.out.println(Arrays.toString(transactionDAO.transactionList()));



    }
}
