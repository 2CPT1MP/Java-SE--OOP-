
public class BankAccount {

    //ATTRIBUTES

    private int balance;

    //BEHAVIOR
    public void checkBalance() {
        System.out.printf("Your account balance is %d\n", balance);
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.printf("You have successfully deposited %d\n", amount);
    }

    public void withdraw(int amount) {
        balance -= amount;
        System.out.printf("You have successfully withdrawn %d\n", amount);
    }

}

