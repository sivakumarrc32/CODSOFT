import java.util.Scanner;
import taskthree.BankAccount;

public class ATM 
{
    
    private final BankAccount account;
    
    public ATM(BankAccount account)
    {
        this.account = account;
    }
    

    public void start() 
    {
        
        Scanner scanner = new Scanner(System.in);
        
        boolean exit = false;
        

        while (!exit) {
            System.out.println("Welcome to the ATM!");
            System.out.println("Please select an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    handleWithdraw(scanner);
                    break;
                case 2:
                    handleDeposit(scanner);
                    break;
                case 3:
                    handleCheckBalance();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private void handleWithdraw(Scanner scanner) 
    {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) 
        {
            System.out.println("Withdrawal successful. Please collect your cash.");
        } 
        else 
        {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    private void handleDeposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful.");
    }

    private void handleCheckBalance() {
        double balance = account.getBalance();
        System.out.println("Your current balance is: $" + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(account);
        atm.start();
        
    }
}
