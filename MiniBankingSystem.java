import java.util.Scanner;

// 2️⃣ BankAccount Class
class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance!");
        }
    }

    public void checkBalance() {
        System.out.println(accountHolder + "'s Balance: $" + balance);
    }
}

// 3️⃣ Main Program (Console Menu)
public class MiniBankingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Welcome to Mini Banking System ===");

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter initial deposit: $");
        double initialDeposit = input.nextDouble();

        BankAccount account = new BankAccount(name, initialDeposit);

        boolean running = true;

        while(running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = input.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = input.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdraw amount: $");
                    double withdrawAmount = input.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using Mini Banking System!");
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }

        input.close();
    }
}