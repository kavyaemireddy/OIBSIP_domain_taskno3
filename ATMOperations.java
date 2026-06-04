import java.util.Scanner;

public class ATMOperations {

    private Account account;
    private TransactionHistory history;

    public ATMOperations(Account account, TransactionHistory history) {
        this.account = account;
        this.history = history;
    }

    public void deposit(Scanner sc) {

        System.out.print("Enter Amount to Deposit: ");
        double amount = sc.nextDouble();

        if(amount > 0) {

            account.setBalance(account.getBalance() + amount);

            history.addTransaction("Deposited: Rs." + amount);

            System.out.println("Amount Deposited Successfully");
        } else {
            System.out.println("Invalid Amount");
        }
    }

    public void withdraw(Scanner sc) {

        System.out.print("Enter Amount to Withdraw: ");
        double amount = sc.nextDouble();

        if(amount <= account.getBalance()) {

            account.setBalance(account.getBalance() - amount);

            history.addTransaction("Withdrawn: Rs." + amount);

            System.out.println("Withdrawal Successful");

        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void transfer(Scanner sc) {

        System.out.print("Enter Receiver Account Number: ");
        String receiver = sc.next();

        System.out.print("Enter Amount to Transfer: ");
        double amount = sc.nextDouble();

        if(amount <= account.getBalance()) {

            account.setBalance(account.getBalance() - amount);

            history.addTransaction(
                "Transferred Rs." + amount + " to Account: " + receiver
            );

            System.out.println("Transfer Successful");

        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs." + account.getBalance());
    }
}