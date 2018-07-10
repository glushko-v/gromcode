package lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {


        if (!checkWithdraw(user, amount)) return;


        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));


        createAndSaveTransaction(new Date(), null, TransactionType.WITHDRAWAL, amount, "asda");

    }


    @Override
    public void fund(User user, int amount) {


        if (!checkFundingLimits(user, amount)) return;

        user.setBalance(user.getBalance() + amount);

        createAndSaveTransaction(new Date(), null, TransactionType.FUNDING, amount, "sfpvo");

    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {

        if (!checkWithdraw(fromUser, amount)) return;

        if (!checkFundingLimits(toUser, amount)) return;

        if (fromUser.getBank().getCurrency() == toUser.getBank().getCurrency()) {
            withdraw(fromUser, amount);
            fund(toUser, amount);
        } else System.err.println("Can't transfer money from " + fromUser.getName() + " to user " + toUser.getName());

        createAndSaveTransaction(new Date(), null, TransactionType.TRANSFER, amount, "rtj");

    }

    @Override
    public void paySalary(User user) {

        if (!checkFundingLimits(user, user.getSalary())) return;

        fund(user, user.getSalary());

        createAndSaveTransaction(new Date(), null, TransactionType.SALARY_INCOME, 1500, "0-42958");

    }

    private void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money " + amount + " from user" + user.toString());
    }

    private void printFundingErrorMsg(int amount, User user) {
        System.err.println("Can't fund " + amount + " to user" + user.toString());
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());

    }

    private boolean checkFundingLimits(User user, int amount) {
        if (amount + user.getBank().getCommission(amount) > user.getBank().getLimitOfFunding()) {
            printFundingErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private Transaction createAndSaveTransaction(Date dateCreated, Date dateConfirmed, TransactionType type,
                                                 int amount, String description) {

        Random random = new Random();

        Transaction tr = new Transaction(random.nextInt(), dateCreated, null, type,
                amount, description);

        transactions.add(tr);

        return tr;

    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
