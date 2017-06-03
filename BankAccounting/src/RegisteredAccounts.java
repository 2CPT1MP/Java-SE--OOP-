
public class RegisteredAccounts {

    //ATTRIBUTES
    static RegisteredAccounts storage[] = new Account[1];

    //BEHAVIOR
    static int c = 0;
    public static void signUp(Account a) {
        storage[c++] = a;
    }

    public static int viewRegs() {
        return storage.length;
    }

    public static String returnName(int i) {
        return storage[i].toString();
    }

}

