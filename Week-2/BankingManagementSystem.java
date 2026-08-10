import java.util.HashMap;
import java.util.Scanner;

// Account class - Encapsulation
class Account {
    private int accountId;
    private String accountHolderName;
    private double balance;

    public Account(int accountId, String accountHolderName, double balance) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        }
    }
}

// Main class
public class BankingManagementSystem {

    // Week 2: HashMap Storage
    static HashMap<Integer, Account> accounts = new HashMap<>();

    static Scanner sc = new Scanner(System.in);

    // Create Account
    public static void createAccount() {

        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Check duplicate Account ID using HashMap
        if (accounts.containsKey(id)) {
            System.out.println("Account ID already exists.");
            return;
        }

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        if (balance < 0) {
            System.out.println("Balance cannot be negative.");
            return;
        }

        Account account = new Account(id, name, balance);

        accounts.put(id, account);

        System.out.println("Account created successfully.");
    }

    // Deposit Money
    public static void depositMoney() {

        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        // Direct lookup using HashMap
        Account account = accounts.get(id);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter Deposit Amount: ");
        double amount = sc.nextDouble();

        account.deposit(amount);
    }

    // Withdraw Money
    public static void withdrawMoney() {

        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        // Direct lookup using HashMap
        Account account = accounts.get(id);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter Withdrawal Amount: ");
        double amount = sc.nextDouble();

        account.withdraw(amount);
    }

    // Check Balance
    public static void checkBalance() {

        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        // Direct lookup using HashMap
        Account account = accounts.get(id);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("\n--- Account Details ---");
        System.out.println("Account ID      : " + account.getAccountId());
        System.out.println("Account Holder  : " + account.getAccountHolderName());
        System.out.println("Balance         : Rs." + account.getBalance());
    }

    // Main method
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("   BANKING MANAGEMENT SYSTEM");
            System.out.println("         WEEK 2");
            System.out.println("==============================");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    depositMoney();
                    break;

                case 3:
                    withdrawMoney();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    System.out.println(
                        "Thank you for using Banking Management System."
                    );
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
