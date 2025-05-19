import java.util.Random;

public class UserTask implements Runnable {
    private JointAccount jointAccount;

    public UserTask(JointAccount jointAccount) {
        this.jointAccount = jointAccount;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            double amount = random.nextInt(101);
            boolean isDeposit = random.nextBoolean();
            try {
                if (isDeposit) {
                    jointAccount.deposit(amount);
                } else {
                    jointAccount.withdraw(amount);
                }
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Current balance: $" + jointAccount.getBalance());
        }
    }
}
