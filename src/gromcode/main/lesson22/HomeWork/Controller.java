package gromcode.main.lesson22.HomeWork;

import gromcode.main.lesson22.HomeWork.exception.BadRequestException;
import gromcode.main.lesson22.HomeWork.exception.InternalServerException;
import gromcode.main.lesson22.HomeWork.exception.LimitExceeded;

public class Controller {

//    private TransactionDAO transactionDAO = new TransactionDAO();

    public static Transaction save(Transaction transaction) throws LimitExceeded, BadRequestException, InternalServerException {


        return TransactionDAO.save(transaction);

    }

    static Transaction[] transactionList() {

        return TransactionDAO.transactionList();
    }

    static Transaction[] transactionList(String city) {

        return TransactionDAO.transactionList(city);
    }

    static Transaction[] transactionList(int amount) {

        return TransactionDAO.transactionList(amount);
    }
}
