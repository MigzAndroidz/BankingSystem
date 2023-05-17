import java.util.Scanner;

public class BankingSystem {

    private static int MAX_ACCOUNT = 100;
    private static int numAccounts = 0;
    private static Account[] accounts = new Account[MAX_ACCOUNT];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\nWelcome to the BDO, We are glad that you're here!");
            System.out.println("1. Create an account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check balance");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");
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
                    System.out.println("Thank you for using BDO!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 5);
    }

    private static void depositMoney() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter account number: ");
        int accountNumber = input.nextInt();

        System.out.print("Enter amount to deposit: ");
        double amount = input.nextDouble();

        int index = findAccount(accountNumber);
        if (index == -1) {
            System.out.println("Account not found.");
            return;
        }

        accounts[index].deposit(amount);

        System.out.println("Amount deposited successfully.");
    }

    private static void withdrawMoney() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter account number: ");
        int accountNumber = input.nextInt();

        System.out.print("Enter amount to withdraw: ");
        double amount = input.nextDouble();

        int index = findAccount(accountNumber);
        if (index == -1) {
            System.out.println("Account not found.");
            return;
        }

        if (!accounts[index].withdraw(amount)) {
            System.out.println("Insufficient balance.");
            return;
        }

        System.out.println("Amount withdrawn successfully.");
    }

    private static void checkBalance() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter account number: ");
        int accountNumber = input.nextInt();

        int index = findAccount(accountNumber);
        if (index == -1) {
            System.out.println("Account not found.");
            return;
        }
        System.out.println("\nBalance for account " + (index + 1) + ": " + (int) accounts[index].getBalance());
    }

    private static void createAccount() {
        Scanner input = new Scanner(System.in);

        if (numAccounts >= MAX_ACCOUNT) {
            System.out.println("Sorry, maximum number of accounts reached.");
            return;
        }

        System.out.print("\nEnter account number: ");
        int accountNumber = input.nextInt();

       
        if (findAccount(accountNumber) != -1) {
            System.out.println("Account number already exists. Please enter a different account number.");
            return;
        }

        System.out.print("Enter account holder name: ");
        String accountHolderName = input.next();

        System.out.print("Enter initial balance: ");
        double balance = input.nextDouble();

        accounts[numAccounts] = new Account(accountNumber, accountHolderName, balance);
        numAccounts++;

        System.out.println("Account created successfully.");
    }
    
        private static int findAccount(int num){
            for(int m = 0; m < numAccounts; m++){
                if(accounts[m].getAccountNumber()== num){
                    return m;
                }
            }
            return -1 ;
        }
}
