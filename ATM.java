import java.util.Scanner;

public class ATM {

    private Account account;
    private TransactionHistory history;
    private ATMOperations operations;

    public ATM() {

        account = new Account("kavya123", "1234", 10000);

        history = new TransactionHistory();

        operations = new ATMOperations(account, history);
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Welcome to ATM =====");

        System.out.print("Enter User ID: ");
        String enteredId = sc.next();

        System.out.print("Enter PIN: ");
        String enteredPin = sc.next();

        if(account.getUserId().equals(enteredId)
                && account.getUserPin().equals(enteredPin)) {

            System.out.println("\nLogin Successful");

            int choice;

            do {

                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Check Balance");
                System.out.println("6. Quit");

                System.out.print("Enter Choice: ");
                choice = sc.nextInt();

                switch(choice) {

                    case 1:
                        history.showHistory();
                        break;

                    case 2:
                        operations.withdraw(sc);
                        break;

                    case 3:
                        operations.deposit(sc);
                        break;

                    case 4:
                        operations.transfer(sc);
                        break;

                    case 5:
                        operations.checkBalance();
                        break;

                    case 6:
                        System.out.println("Thank You for Using ATM");
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }

            } while(choice != 6);

        } else {

            System.out.println("Invalid User ID or PIN");
        }

        sc.close();
    }
}