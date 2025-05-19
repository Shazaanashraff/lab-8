public class BankDemo {
    public static void main(String[] args) {
        // Create a shared account with an initial balance
        Account account = new Account("12345", 1000.0);

        // Create several BankTask instances (representing users) that will operate on the account
        Thread user1 = new Thread(new BankTask(account), "User 1");
        Thread user2 = new Thread(new BankTask(account), "User 2");
        Thread user3 = new Thread(new BankTask(account), "User 3");

        // Start the threads
        user1.start();
        user2.start();
        user3.start();

        try {
            // Wait for all threads to finish
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display final balance
        System.out.println("Final balance in the account: $" + account.getBalance());
    }
}
