package Lab1.Models.Transaction;

import Lab1.Entities.Account.Account;
import Lab1.Services.Validator;

public class Transaction {
    private final Account account;
    private double amount;
    private boolean isExecuted;

    public Transaction(Account account, double amount) {
        Validator.checkIfNull(account);
        Validator.checkIfBelowZero(amount);

        this.account = account;
        this.amount = amount;
        this.isExecuted = false;
    }

    public void cancel() {
        if (isExecuted) {
            //TODO: withdraw from history
            account.withdraw(amount);
            isExecuted = false;
        }
    }

    public void execute() {
        account.deposit(amount);
        isExecuted = true;
    }

    public double getAmount() {
        return amount;
    }
    private void setAmount(double amount) {
        this.amount = amount;
    }
}
