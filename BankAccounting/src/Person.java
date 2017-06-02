
public class Person {

    //BEHAVIOR
    public void deposit(BankAccount bankAccount, int amount) {
        bankAccount.deposit(amount);
    }

    public void withdraw(BankAccount bankAccount, int amount) {
        bankAccount.withdraw(amount);
    }

    public void checkBalance(BankAccount bankAccount) {
        bankAccount.checkBalance();
    }


    //EXECUTION FLOW
    public static void main(String args[]) {

        //INSTANTIATION
        Person James = new Person();
        BankAccount James_bankAcc = new BankAccount();



        //OPERATING
        James.deposit(James_bankAcc, 50);
        James.withdraw(James_bankAcc, 1);
        James.checkBalance(James_bankAcc);


    }


}
