public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(double amount, double balance) {
        super("Insufficient balance for withdrawal of: $" + amount + ". Current balance: $" + balance);
    }
}
