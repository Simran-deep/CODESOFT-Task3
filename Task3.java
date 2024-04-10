import java.util.Scanner;
//create ATM Class
class ATM {
    private BankAccount account;
    private Scanner scanner;
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }
//Menu for selection the choice    
    public void showMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    public void run() {
        int choice;
        do {
            showMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
    private void checkBalance() {
        System.out.println("Current balance is: " + account.getBalance());
    }
    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }
    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
//checking the balance in account    
    public double getBalance() {
        return balance;
    }
// Depositing the money in account    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful");
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Invalid");
        }
    }
//withdrawing the money from account    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful");
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Invalid amount");
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        System.out.println("ATM Machine Interface");
        BankAccount userAccount = new BankAccount(2000);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}

