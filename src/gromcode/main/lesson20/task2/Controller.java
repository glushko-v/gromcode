package gromcode.main.lesson20.task2;

import gromcode.main.lesson20.task2.exception.BadRequestException;
import gromcode.main.lesson20.task2.exception.InternalServerException;
import gromcode.main.lesson20.task2.exception.LimitExceeded;

public class Controller {

    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws LimitExceeded, BadRequestException, InternalServerException {


        return transactionDAO.save(transaction);

    }

    Transaction[] transactionList() {

        return transactionDAO.transactionList();
    }

    Transaction[] transactionList(String city) {

        return transactionDAO.transactionList(city);
    }

    Transaction[] transactionList(int amount) {

        return transactionDAO.transactionList(amount);
    }
}
