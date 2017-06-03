

public class Account extends RegisteredAccounts {

    //ATTRIBUTES
    private String user;
    private int balance;

    /// /BEHAVIOR
    public void deposit(int amount) {
        balance += amount;
        System.out.println("Operation successful");
        System.out.printf("ACCOUNT BALANCE: %d \n", checkBalance());
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Operation successful");
            System.out.printf("ACCOUNT BALANCE: %d \n", checkBalance());
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public int checkBalance() {
        return balance;
    }

    public String toString(){
        return user;
    }

    //CONSTRUCTOR
    public Account(String u) {
        user = u;
        balance = 200;
        signUp(this);
    }
}
