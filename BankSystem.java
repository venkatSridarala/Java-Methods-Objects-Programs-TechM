package Arrays;
import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double initialBalance) {
        balance = (initialBalance >= 0) ? initialBalance : 0;
    }

    //deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    //withdrawal
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    //check balance
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }
}

class User {
    private int accountNumber;
    private String name;
    private BankAccount account;

    public User(int accountNumber, String name, double initialBalance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.account = new BankAccount(initialBalance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void displayUserInfo() {
        System.out.println("Account Number: " + accountNumber + ", Name: " + name);
    }
}

 class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array of 10 users
        User[] users = new User[10];
        for (int i = 0; i < 10; i++) {
            int accountNumber = i + 1;  
            String userName = "User" + accountNumber;  
            double initialBalance = 500.0;

            users[i] = new User(accountNumber, userName, initialBalance);
        }

        while (true) {
            System.out.print("\nEnter your account number (1-10): ");
            int accountNumber = scanner.nextInt();

            if (accountNumber < 1 || accountNumber > 10) {
                System.out.println("Invalid account number. Please try again.");
                continue; 
            }

            User user = users[accountNumber - 1]; 
            user.displayUserInfo(); 
            System.out.println("\nBank Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount to deposit: $");
                double depositAmount = scanner.nextDouble();
                user.getAccount().deposit(depositAmount);
            } else if (choice == 2) {               
                System.out.print("Enter amount to withdraw: $");
                double withdrawAmount = scanner.nextDouble();
                user.getAccount().withdraw(withdrawAmount);
            } else if (choice == 3) {              
                user.getAccount().checkBalance();
            } else if (choice == 4) {               
                System.out.println("Thank you for using our banking system!");
                break; 
            } else {               
                System.out.println("Invalid option. Please try again later.");
            }
        }
    }
}