package lesson22.HomeWork;

import lesson22.HomeWork.exception.BadRequestException;
import lesson22.HomeWork.exception.InternalServerException;
import lesson22.HomeWork.exception.LimitExceeded;

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
