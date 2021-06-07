import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {

        BankAccount obj = new BankAccount();
        obj.details();
        obj.showMenu();


    }

}

class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    void details(){
        Scanner ac = new Scanner(System.in);
        System.out.print("Enter your name: ");
        customerName = ac.next();
        System.out.print("Enter your ID: ");
        customerId = ac.next();   
    }

    void deposit(int amount) {
        if(amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if(amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if(previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        }
        else if(previousTransaction < 0) {
            System.out.println("Withdraw: " +Math.abs(previousTransaction));
        }

        else {
            System.out.println("No Transaction Occured");
        }
    }

    void showMenu() {

        String option;
        String finaloption;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " +customerName);
        System.out.println("Your ID is " +customerId);
        System.out.println("\n");

        System.out.println("A : Check Your Balance");
        System.out.println("B : Deposit");
        System.out.println("C : Withdraw");
        System.out.println("D : Previous Transaction");
        System.out.println("E : Exit The System");

        do {
            System.out.print("Enter Your Option : ");
            option = scanner.next();
            finaloption = option.toUpperCase();
            System.out.println("\n");

            switch (finaloption) {

            case "A":

                if(balance==0){
                    System.out.println("Enter some Money First");
                }
                else if(balance>0 && balance<100000){
                    System.out.println("Balnace = "+balance);
                }
                else if(balance>=100000 && balance<100000000){
                    System.out.println("Balance = "+balance);
                    System.out.println("You Are a millionare Now!!!");
                }
                System.out.println("\n");
                break;

            case "B":
                System.out.print("Enter an amount to deposit : ");
                
                int amount = scanner.nextInt();
                deposit(amount);
                System.out.println("\n");
                break;

            case "C":
                System.out.print("Enter an amount to withdraw :");
                
                int amount2 = scanner.nextInt();
                withdraw(amount2);
                System.out.println("\n");
                break;

            case "D":
                getPreviousTransaction();
                System.out.println("\n");
                break;

            case "E" :
                System.out.println("Exiting the system");
                break;

            default:
                System.out.println("Invalid Option!! Please Enter Correct Opton...");
                break;
            }
        }
        while(option != "E");
            System.out.println("Thank You for Using our Services.....!!");
    }
}