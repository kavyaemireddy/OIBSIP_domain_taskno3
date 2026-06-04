import java.util.ArrayList;

public class TransactionHistory {

    private ArrayList<String> history = new ArrayList<>();

    public void addTransaction(String transaction) {
        history.add(transaction);
    }

    public void showHistory() {

        if(history.isEmpty()) {
            System.out.println("No Transactions Available");
        } else {

            System.out.println("\n===== Transaction History =====");

            for(String transaction : history) {
                System.out.println(transaction);
            }
        }
    }
}