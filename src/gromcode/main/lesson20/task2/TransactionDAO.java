package gromcode.main.lesson20.task2;


import gromcode.main.lesson20.task2.exception.BadRequestException;
import gromcode.main.lesson20.task2.exception.InternalServerException;
import gromcode.main.lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction[] getTransactions() {
        return transactions;
    }

    public Transaction save(Transaction transaction) throws LimitExceeded, BadRequestException, InternalServerException {


        validate(transaction);

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                transactions[i] = transaction;
                break;
            }

        }


        return transaction;
    }

    public void validate(Transaction transaction) throws LimitExceeded, BadRequestException, InternalServerException {


        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceeded " + transaction.getId() + "can't be saved");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {

            sum += tr.getAmount();
            count++;
        }


        if ((sum + transaction.getAmount()) > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceeded " + transaction.getId() + " can't be saved");

        if ((count + 1) > utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceeded " + transaction.getId() + " can't be saved");


        checkFreeSlots(transaction);
        if (!checkCity(transaction.getCity())) throw new BadRequestException("Invalid city. Can not save transaction "
                + transaction.getId());


    }

    public Transaction[] transactionList() {


        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null) index++;

        }


        Transaction[] res = new Transaction[index];

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                res[count] = tr;
                count++;
            }
        }


        return res;
    }

    public Transaction[] transactionList(String city) {


//        if (!checkCity(city)) throw new BadRequestException("Invalid city. Can not print transactions for "
//                + city);


        int index = 0;

        for (Transaction transaction : transactions)
            if (transaction != null && transaction.getCity().equals(city)) {
                index++;
            }

        Transaction[] result = new Transaction[index];

        int count = 0;

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] != null && transactions[i].getCity().equals(city)) {
                result[count] = transactions[i];
                count++;
            }


        }

        return result;
    }

    public Transaction[] transactionList(int amount) {


//        if (amount > utils.getLimitSimpleTransactionAmount()) throw new BadRequestException("Invalid amount. Can't" +
//                " print transactions for amount " + amount);


        int index = 0;

        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount)
                index++;
        }

        Transaction[] res = new Transaction[index];

        int count = 0;

        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                res[count] = tr;
                count++;
            }
        }

        return res;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;

        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);
                if (trMonth == month && trDay == day) count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }

            }
        }

        return result;
    }

    boolean checkCity(String city) {

        for (String city1 : utils.getCities()) {
            if (city1 == city) return true;
        }

        return false;
    }

    void checkFreeSlots(Transaction transaction) throws InternalServerException {
        int countFreeSlots = 0;

        for (Transaction tr : transactions) {
            if (tr == null)
                countFreeSlots++;
        }

        if (countFreeSlots <= 0)
            throw new InternalServerException("No free space. Can not save transaction " + transaction.getId());

    }


}
