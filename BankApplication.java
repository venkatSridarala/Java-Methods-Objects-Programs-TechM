package Arrays;
import java.util.Scanner;
public class BankApplication {

	    private double balance;    
	    public BankApplication(double initialBalance) {
	        if (initialBalance >= 0) {
	            balance = initialBalance;
	        } else {
	            System.out.println("Initial balance must be non-negative.");
	            balance = 0;
	        }
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

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        BankApplication account = new BankApplication(1000.0);

	        while (true) {
	            System.out.println("\nBank Menu:");
	            System.out.println("1. Deposit");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Check Balance");
	            System.out.println("4. Exit");
	            System.out.print("Choose an option: ");
	            
	            int choice = scanner.nextInt();
	            
	            switch (choice) {
	                case 1:
	                    // Deposit
	                    System.out.print("Enter amount to deposit: $");
	                    double depositAmount = scanner.nextDouble();
	                    account.deposit(depositAmount);
	                    break;

	                case 2:
	                    // Withdraw
	                    System.out.print("Enter amount to withdraw: $");
	                    double withdrawAmount = scanner.nextDouble();
	                    account.withdraw(withdrawAmount);
	                    break;

	                case 3:
	                    // Check balance
	                    account.checkBalance();
	                    break;

	                case 4:
	                    // Exit
	                    System.out.println("Exiting... Thank you for using our banking system!");
	                    scanner.close();
	                    return;

	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	        }
	    }
	}
