import java.util.Random;

public class BankTask implements Runnable {
    private Account account;

    public BankTask(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        Random random = new Random();
        boolean isDeposit = random.nextBoolean();
        double amount = random.nextInt(500) + 1;

        if (isDeposit) {
            System.out.println(Thread.currentThread().getName() + " is attempting to deposit $" + amount);
            account.deposit(amount);
        } else {
            System.out.println(Thread.currentThread().getName() + " is attempting to withdraw $" + amount);
            try {
                account.withdraw(amount);
            } catch (InsufficientBalanceException e) {
                System.out.println(Thread.currentThread().getName() + " failed: " + e.getMessage());
            }
        }
        account.displayBalance();  // Display balance after transaction
    }
}
