import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankSystem {
    public static void main(String[] args) {
        while (true) {
            String name = JOptionPane.showInputDialog("Enter the name of the account holder:");
            double initialBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter the initial balance:"));
            BankAccount account = new BankAccount(name, initialBalance);
            account.menu();
            
            int option = JOptionPane.showConfirmDialog(null, "Would you like to continue?", "Continue/Exit", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION) {
                break;
            }
        }
    }

    public static void messagePane(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    protected static class Transaction {
        private LocalDateTime dateTime;
        private String type;
        private double amount;
        private double balanceAfter;

        public Transaction(String type, double amount, double balanceAfter) {
            this.dateTime = LocalDateTime.now();
            this.type = type;
            this.amount = amount;
            this.balanceAfter = balanceAfter;
        }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return String.format("%s | %-20s | Amount: VND %-20.2f | Balance: VND %-20.2f",
                dateTime.format(formatter), 
                type,
                amount,
                balanceAfter);
        }
    }

    protected static class BankAccount {
        private String accountHolder;
        private double balance;
        private double monthlyInterestRate = 0.005; // 0.5%
        private int withdrawalInThisMonth = 0;
        private List<Transaction> transactionHistory;

        public BankAccount(String accountHolder, double initialBalance) {
            this.accountHolder = accountHolder;
            this.balance = initialBalance;
            this.transactionHistory = new ArrayList<>();
            addTransaction("Initial Deposit", initialBalance);
        }

        private void addTransaction(String type, double amount) {
            Transaction transaction = new Transaction(type, amount, balance);
            transactionHistory.add(transaction);
        }

        public void menu() {
            while (true) {
                String[] options = {"Deposit", "Withdraw", "Check Balance", "Balance after monthly interest", "Transaction Log", "Exit"};
                int choice = JOptionPane.showOptionDialog(null, "Choose an action:", "Menu", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                switch (choice) {
                    case 0:
                        deposit();
                        break;
                    case 1:
                        if (withdrawalInThisMonth < 3) {
                            withdraw();
                        } else {
                            messagePane("Withdrawal limit reached for this month.", "Limit Reached");
                        }
                        break;
                    case 2:
                        checkBalance();
                        break;
                    case 3:
                        calculateMonthlyInterest();
                        break;
                    case 4:
                        showTransactionLog();
                        break;
                    case 5:
                        return;
                }
            }
        }

        private void deposit() {
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount to deposit:"));
            balance += amount;
            addTransaction("Deposit", amount);
            messagePane("Deposited: " + amount + "\nNew Balance: " + balance, "Deposit");
        }

        private void withdraw() {
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount to withdraw:"));
            if (amount <= balance) {
                balance -= amount;
                withdrawalInThisMonth++;
                addTransaction("Withdrawal", amount);
                messagePane("Withdrew: " + amount + "\nNew Balance: " + balance, "Withdraw");
            } else {
                messagePane("Insufficient funds.", "Error");
            }
        }

        private void checkBalance() {
            messagePane("Current Balance: " + balance, "Balance");
        }

        private void calculateMonthlyInterest() {
            double interestEarned = balance * monthlyInterestRate;
            double balanceWithInterest = balance + interestEarned;
            messagePane(
                String.format("Current Balance: %.2f\nMonthly Interest Rate: %.1f%%\nInterest Earned: %.2f\nBalance with Interest: %.2f", 
                    balance, 
                    monthlyInterestRate * 100, 
                    interestEarned,
                    balanceWithInterest),
                "Monthly Interest Calculation"
            );
        }

        private void showTransactionLog() {
            if (transactionHistory.isEmpty()) {
                messagePane("No transactions found.", "Transaction Log");
                return;
            }

            StringBuilder log = new StringBuilder();
            log.append("Transaction History for ").append(accountHolder).append("\n\n");
            
            for (Transaction transaction : transactionHistory) {
                log.append(transaction.toString()).append("\n");
            }

            messagePane(log.toString(), "Transaction Log");
        }
    }
}