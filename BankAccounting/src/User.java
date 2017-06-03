import java.util.Scanner;

public class User {

    //BEHAVIOR
    public void deposit(Account a) {
        Scanner amountScan = new Scanner(System.in);
        System.out.println("Enter amount: ");
        int amount = amountScan.nextInt();
        a.deposit(amount);
    }

    public void withdraw(Account a) {
        Scanner amountScan = new Scanner(System.in);
        System.out.println("Enter amount: ");
        int amount = amountScan.nextInt();
        a.withdraw(amount);
    }

    public int checkBalance(Account a) {
        return a.checkBalance();
    }


    //ENTRY POINT
    public static void main(String args[]) {

        //PROVIDING ACCESS TO INPUT
        Scanner SO = new Scanner(System.in);

        //CREATION OF ACCOUNT
        Account acc = new Account("2CPT1MP");

        //GETTING USER INPUT
        System.out.println("Please enter your account username: ");
        String usernameInput = SO.next();

        for (RegisteredAccounts r : RegisteredAccounts.storage) {
            if (usernameInput.equals(r.toString())) {

                //IF MATCHES
                User currentUser = new User();

                System.out.printf("ACCOUNT BALANCE: %d \n", currentUser.checkBalance(acc));

                System.out.println("Choose Operation: ");
                System.out.println("1 - Deposit  2 - Withdraw");
                int opeerationInput = SO.nextInt();

                switch (opeerationInput) {
                    case 1:
                        currentUser.deposit(acc);
                        break;
                    case 2:
                        currentUser.withdraw(acc);
                        break;
                    default:
                        System.out.println("Wrong input");
                }
            }
        }
    }
}
