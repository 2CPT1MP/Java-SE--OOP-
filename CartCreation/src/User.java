import java.util.Scanner;
class User {

    //Attributes
    private Cart defaultCart;

    //Behavior
    private Cart createCart(String username, String password) {

        CartCreator defaultCartCreator = new CartCreator();
        return defaultCartCreator.createCart(username, password);
    }


    //Constructor
    private User(){
        defaultCart = null;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to create a new cart? (Y/N)");

        String input1 = scanner.next();
        switch(input1) {
            case "Y":
                System.out.println("\nPlease specify desired username and password by separating them with a space:");
                String user = scanner.next();
                String pass = scanner.next();
                signUp(user, pass);
                break;
            case  "N":
                break;
            default:

        }






    }

    private static void signUp(String usen, String passwor) {

        User defaultUser = new User();

        defaultUser.defaultCart = defaultUser.createCart(usen, passwor);
        //System.out.println(defaultUser.defaultCart.getCardNumber());

        System.out.println("\nYour credentials are:\n");

        System.out.printf("Cart Number: %d\nUsername: %s\nPassword: %s", defaultUser.defaultCart.getCardNumber(), defaultUser.defaultCart.getUsername(), defaultUser.defaultCart.getPassword());

    }

}
