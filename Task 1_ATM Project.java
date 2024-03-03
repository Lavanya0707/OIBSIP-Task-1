/* Hello everyone
 * My name is Lavanya Shinde.
 * I am enrolled in Oasis Infobyte as a Java Intern.
   We have all come across ATMs in our cities and it is built on Java.
   This complex project consists of five different classes and is a console-based application. 
   When the system starts the user is  prompted with user id and user pin.
   On entering the details successfully, then ATM functionalities
   are unlocked. The project allows to perform following operations:

	1. Transactions History
	2. Withdraw
	3. Deposit
	4. Transfer
	5. Quit*/

package atmProject;

import java.util.Scanner;

// Class representing a user account
class Account {
    private String userId;
    private String pin;
    private double balance;

    public Account(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public boolean verifyPin(String pin) {
        return this.pin.equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance:  ₹" + balance);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Amount withdrawn:  ₹" + amount + "."
            		+ " Current balance:  ₹" + balance);
            return true;
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
            return false;
        }
    }

    public void transfer(Account recipient, double amount) {
        if (balance >= amount) {
            withdraw(amount);
            recipient.deposit(amount);
            System.out.println("Transfer successful. Amount transferred:  ₹" + amount);
        } else {
            System.out.println("Insufficient balance for transfer. Transfer failed.");
        }
    }
}

// Main ATM class
public class ATM_Project {
    private Account account;
    private Scanner scanner;

    public ATM_Project(Account account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM.");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (account.getUserId().equals(userId) && account.verifyPin(pin)) {
            System.out.println("Login successful.");
            showMenu();
        } else {
            System.out.println("Invalid User ID or PIN.");
        }
    }

    private void showMenu() {
        while (true) {
            System.out.println("\n1. View Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Implement transaction history functionality
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient's User ID: ");
                    String recipientId = scanner.next();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    // Implement transfer functionality
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void main(String[] args) {
        // Create an account
        Account account = new Account("atm123", "1234", 1000.0);
        // Create an ATM instance and start it
        ATM_Project atm = new ATM_Project(account);
        atm.start();
    }
}
